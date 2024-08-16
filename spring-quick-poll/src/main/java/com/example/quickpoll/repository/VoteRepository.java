package com.example.quickpoll.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.quickpoll.domain.Vote;

public interface VoteRepository  extends CrudRepository<Vote,Long>{
	
	@Query(value="select v.* from poll_option o, vote v where o.poll_id = ?1 and v.option_id = o.option_id", nativeQuery = true)
	public Iterable<Vote> findByPoll(Long pollId);

}
