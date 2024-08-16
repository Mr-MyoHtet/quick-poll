package com.example.quickpoll.domain;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

@Entity
public class Poll {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "POLL_ID")
	private Long id;

	@Column(name = "QUESTION")
	private String question;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "POLL_ID")
	@OrderBy
	private Set<PollOption> options;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<PollOption> getOptions() {
		return options;
	}

	public void setOptions(Set<PollOption> options) {
		this.options = options;
	}

}
