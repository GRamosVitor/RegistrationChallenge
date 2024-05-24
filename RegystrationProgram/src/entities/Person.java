package entities;

public class Person {
	
	private String name;
	private String email;
	private Integer age;
	private Double height;
	
	public Person() {
		
	}

	public Person(String name, String email, Integer age, Double height) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s%n"
				+ "Email: %s%n"
				+ "Idade: %d%n"
				+ "Altura: %.2f", 
				name, email, age, height);
	}
	
	
}
