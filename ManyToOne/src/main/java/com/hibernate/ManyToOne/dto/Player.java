package com.hibernate.ManyToOne.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Player {
	
	@Id
	private int id;
	private String name;
	private int jerseyNumber;
	private int age;
	@ManyToOne
	private Team team;

}
