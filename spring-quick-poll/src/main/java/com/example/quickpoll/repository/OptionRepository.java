package com.example.quickpoll.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.quickpoll.domain.PollOption;

public interface OptionRepository  extends CrudRepository<PollOption,Long>{

}
