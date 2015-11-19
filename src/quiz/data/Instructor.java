package quiz.data;

public class Instructor {
	
	public Instructor() {
		// no-arg constructor for Spring to use.
	}
	
	public Instructor(String firstName, int age) {
		super();
		this.firstName = firstName;
		this.age = age;
	}
	
	private String firstName;
	private int age;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
