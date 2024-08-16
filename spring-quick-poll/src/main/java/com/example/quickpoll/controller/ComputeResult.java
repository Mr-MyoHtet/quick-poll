package com.example.quickpoll.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quickpoll.domain.Vote;
import com.example.quickpoll.dto.OptionCount;
import com.example.quickpoll.dto.VoteResult;
import com.example.quickpoll.repository.VoteRepository;

@RestController
public class ComputeResult {

	@Autowired
	private VoteRepository voteRepository;

	@GetMapping("/computeresult")
	public ResponseEntity<?> computeResult(@RequestParam Long pollId) {

		VoteResult voteResult = new VoteResult();

		Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);

		// Algorithm to count votes

		int totalVotes = 0;

		Map<Long, OptionCount> temMap = new HashMap<Long, OptionCount>();

		for (Vote v : allVotes) {
			totalVotes++;
			OptionCount optionCount = temMap.get(v.getOption().getId());
		
			

			if (optionCount == null) {
				optionCount = new OptionCount();
				optionCount.setOptionId(v.getOption().getId());
				temMap.put(v.getOption().getId(), optionCount);
			}
             System.out.println(optionCount.getCount());
             
			optionCount.setCount(optionCount.getCount() + 1);
		}
		voteResult.setTotalVotes(totalVotes);
		voteResult.setResults(temMap.values());

		return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);

	}

}
