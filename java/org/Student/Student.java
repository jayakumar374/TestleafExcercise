package org.Student;

import org.Department.Department;

public class Student extends Department {
	public void studentName()
	{
		System.out.println("JK");
	}
	public void studentID()
	{
		System.out.println("22");
	}
	public void studentDept()
	{
		System.out.println("CSE");
	}

	public static void main(String[] args) {
		
		Student s = new Student();
		s.colleageCode();
		s.colleageName();
		s.colleageRank();
		s.deptName();
		s.studentDept();
		s.studentName();
		s.studentID();
	}
}
