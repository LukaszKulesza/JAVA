package pl.codeme.examples.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.codeme.examples.jpa.models.People;
import pl.codeme.examples.jpa.models.PersonalData;

public class JpaExample {
	
	EntityManagerFactory emf;
	private EntityManager em;
	
	public static void main(String[] args) {
		JpaExample example = new JpaExample();
		example.createHuman();
		example.searchHuman();
//		example.searchHumans();
	}

	private JpaExample() {
		emf = Persistence.createEntityManagerFactory("company");
		em = emf.createEntityManager();
	}

	private void searchHumans() {
		List<People> humans;
		
		Query q = em.createQuery("select p from People p");
		humans = q.getResultList();
		
		for (People h : humans) {
			System.out.println(h.getId() + ": " + h.getName() + ' ' + h.getAge());
		}
	}
	
	private void searchHuman() {
		People human = em.find(People.class, 1);
		human.setAge(100);

		System.out.println(human.getName() + ' ' + human.getAge());
		System.out.println(human.getPersonalData().getAdres() + ' ' + human.getPersonalData().getMiasto());
	}
	
	private void createHuman() {
		em.getTransaction().begin();

		PersonalData personalData = new PersonalData();
		personalData.setAdres("ul. Lęborska");
		personalData.setMiasto("Gdańsk");
		em.persist(personalData);
		
		People human = new People();
		human.setName("Marek");
		human.setAge(10);
		human.setPersonalData(personalData);
		em.persist(human);
		
		em.getTransaction().commit();
	}

}
