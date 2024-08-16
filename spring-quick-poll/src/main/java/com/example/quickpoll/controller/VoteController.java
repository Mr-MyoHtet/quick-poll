package com.example.quickpoll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.quickpoll.domain.Vote;
import com.example.quickpoll.repository.VoteRepository;

@RestController
public class VoteController {
	
	@Autowired
	private VoteRepository voteRepository;
	
	
	@PostMapping("/polls/{pollId}/votes")
	public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote){
		
		vote = voteRepository.save(vote);
		
		//Set the headers for the newly created resource
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(vote.getId()).toUri());
		
		return new ResponseEntity<>(null,responseHeaders,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/polls/{pollId}/votes")
	public Iterable<Vote> getAllVotes(@PathVariable Long pollId){
		return voteRepository.findByPoll(pollId);
	}
	

}
