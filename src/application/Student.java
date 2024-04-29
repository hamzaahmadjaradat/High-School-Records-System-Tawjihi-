package application;

public class Student {

	int id;
	String branch;
	double grade;



	public Student(int id, String branch, double grade) {
		this.id = id;
		this.branch = branch;
		this.grade = grade;
	}

	public Student() {
		super();
	}

	public double getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", branch=" + branch + ", grade=" + grade + "]";
	}

}
