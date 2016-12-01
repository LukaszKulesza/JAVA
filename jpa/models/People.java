package pl.codeme.examples.jpa.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name="ludzie")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//@Column(name="imie")
	private String name;
	
	private int age;

	@OneToOne
	private PersonalData personalData;
	
	@OneToMany(targetEntity = Salary.class)
	private List<Salary> salary;
	
	@ManyToMany(targetEntity = Team.class)
	private Set<Team> teams;

	public List<Salary> getSalary() {
		return salary;
	}

	public void setSalary(List<Salary> salary) {
		this.salary = salary;
	}

	public PersonalData getPersonalData() {
		return personalData;
	}

	public void setPersonalData(PersonalData personalData) {
		this.personalData = personalData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
