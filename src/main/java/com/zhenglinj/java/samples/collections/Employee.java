package com.zhenglinj.java.samples.collections;

class Employee implements Comparable<Employee> {//

	private String name;
	private int salary;
	private int id;

	public Employee(int id, String n, int s) {
		this.id = id;
		this.name = n;
		this.salary = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "<Id: " + this.id + " Name: " + this.name + " Salary: " + this.salary + ">";
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		System.out.println("In hashcode");
		return this.getId();
	}

	@Override
	public boolean equals(Object obj) {
		Employee e = null;
		if (obj instanceof Employee) {
			e = (Employee) obj;
		}
		System.out.println("In equals");
		if (this.getId() == e.getId()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Employee arg0) {
		if (this.getId() == arg0.getId())
			return 0;
		else if (this.getId() > arg0.getId())
			return 1;
		else
			return -1;
	}
}
