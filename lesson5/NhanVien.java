package stt07_VuHoaBinh_JListDemo;

import java.util.Objects;

public class NhanVien {
	private String employeeID;
	private String lastName;
	private String firstName;
	private int age;
	private boolean sex;
	private double salary;
	
	public NhanVien(String employeeID, String firstName, String lastName, int age, boolean sex, double salary) {
		super();
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.sex = sex;
		this.salary = salary;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(employeeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(employeeID, other.employeeID);
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Nhanvien [IDnv =" + employeeID + ",First Name =" + firstName + ", Last Name =" + lastName + ", Age =" + age + ", Sex ="
				+ sex + ", Salary =" + salary + "]";
	}

}
