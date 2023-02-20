package logic;

import java.util.Scanner;

import bean.Student;

public class GetData {
	 static public Student data() {
		 Student s = new Student();
		 Scanner sc  = new Scanner(System.in);
		 System.out.println("enter roll no : ");
		 s.setRoll(sc.nextInt());
		 System.out.println("enter name : ");
		 s.setName(sc.next());
		 System.out.println("enter branch : ");
		 s.setBranch(sc.next());
		 System.out.println("enter semester : ");
		 s.setSemester(sc.nextInt());
		 return s;
	 }
}
