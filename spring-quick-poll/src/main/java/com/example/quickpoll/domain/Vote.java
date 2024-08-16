package com.example.quickpoll.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vote {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "VOTE_ID")
	private long id;

	@ManyToOne
	@JoinColumn(name = "OPTION_ID")
	private PollOption option;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PollOption getOption() {
		return option;
	}

	public void setOption(PollOption option) {
		this.option = option;
	}

}
