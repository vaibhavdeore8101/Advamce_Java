package com.hibernate.OneToOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.OneToOne.dto.Voter;
import com.hibernate.OneToOne.dto.VotingCard;

public class VoterDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("Voter");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	public static void closeConnection() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if(entityManager!=null) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Voter voter = new Voter();
		voter.setId(1);
		voter.setName("Nayan");
		voter.setAddress("Delhi");

		VotingCard votingCard = new VotingCard();
		votingCard.setId(1);
		votingCard.setCardNumber("abcd1234");
		votingCard.setDateOfIssue("01/06/2003");
		votingCard.setVoter(voter);

		voter.setVotingCard(votingCard);

		entityManager.persist(votingCard);
		entityManager.persist(voter);

		entityTransaction.commit();
		closeConnection();
	
	

	}

}
