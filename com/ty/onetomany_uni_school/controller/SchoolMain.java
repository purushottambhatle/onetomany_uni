package com.ty.onetomany_uni_school.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.ty.onetomany_uni_school.dao.SchoolDao;
import com.ty.onetomany_uni_school.dao.StudentDao;
import com.ty.onetomany_uni_school.dto.School;
import com.ty.onetomany_uni_school.dto.Student;


public class SchoolMain {

	public static void main(String[] args) {

		boolean condition = false;
		School school = new School();
		StudentDao studentDao = new StudentDao();
		SchoolDao schoolDao = new SchoolDao();

		Scanner scanner = new Scanner(System.in);
		do {
			System.out
					.println("enter your choice \n 1.insert \n 2.update \n 3.delete \n 4.get by id \n 5.retrive all ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("enter school name");
				String name = scanner.next();
				System.out.println("enter school addreess");
				String address = scanner.next();
				System.out.println("enter phone number ");
				Long phone = scanner.nextLong();

				school.setName(name);
				school.setAddress(address);
				school.setPhone(phone);

				Student student1 = new Student();
				System.out.println("enter student name");
				String snameString1 = scanner.next();
				System.out.println("enter student address");
				String saddressString1 = scanner.next();

				student1.setName(snameString1);
				student1.setAddress(saddressString1);

				Student student2 = new Student();
				System.out.println("enter student name");
				String sname = scanner.next();
				System.out.println("enter student address");
				String saddress = scanner.next();

				student2.setName(sname);
				student2.setAddress(saddress);

				List<Student> list = new ArrayList<Student>();
				list.add(student1);
				list.add(student2);

				school.setStudents(list);
				schoolDao.saveSchool(school);
			}
			break;
			case 2: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("enter school name");
				String nameString = scanner.next();
				school.setName(nameString);
				school.setId(id);
				schoolDao.updateSchoool(id, school);
				
			}

				break;
			case 3: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				school.setId(id);
				schoolDao.removeSchool(id);
			}

				break;
			case 4: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				school.setId(id);
				schoolDao.getSchool(id);
			}

				break;
			case 5: {

				schoolDao.getAllSchool();
			}

				break;

			default:
				break;
			}

		} while (condition);

	}

}


