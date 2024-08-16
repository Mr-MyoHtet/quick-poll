package com.example.quickpoll.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.quickpoll.domain.Poll;
import com.example.quickpoll.exception.ResourceNotFoundException;
import com.example.quickpoll.repository.PollRepository;

@RestController
public class PollController {

	@Autowired
	private PollRepository pollRepository;

	@GetMapping("/polls")
	public ResponseEntity<?> getAllPolls() {

		return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping("/polls")
	public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
		poll = pollRepository.save(poll);
//		HttpHeaders responseHeaders = new HttpHeaders();
//		URI newPollUri = ServletUriComponentsBuilder
//		.fromCurrentRequest()
//		.path("/{id}")
//		.buildAndExpand(poll.getId())
//		.toUri();
//		responseHeaders.setLocation(newPollUri);
		System.out.println("Hellow world");
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping("/polls/{pollId}")
	public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
		Optional<Poll> p = pollRepository.findById(pollId);
		if (p == null) {
			throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
		}
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@PutMapping("/polls/{pollId}")
	public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
		Poll p = pollRepository.save(poll);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@DeleteMapping("/polls/{pollId}")
	public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
		pollRepository.deleteById(pollId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
