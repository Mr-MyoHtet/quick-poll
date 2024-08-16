package com.example.quickpoll.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.quickpoll.domain.Poll;

public interface PollRepository extends CrudRepository<Poll,Long>{

}
