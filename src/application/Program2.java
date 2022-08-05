package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department department = departmentDao.findById(3);
		System.out.println("\n+++ TEST 1: department findById +++");
		System.out.println(department);
		
		System.out.println("\n+++ TEST 2: department findByDepartment +++");
		Department department1 = new Department(5, null);
		List<Department> list = departmentDao.findByDepartment(department1);
		for(Department obj : list) {
			System.out.println(obj);
		}	
		
		System.out.println("\n+++ TEST 3: department findAll +++");
		list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n+++ TEST 4: department insert +++");
		Department newDepartment = new Department(null, "Fisica Aplicada");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted ! New ID: " + newDepartment.getId());
		
		System.out.println("\n+++ TEST 5: department update +++");
		department1 = departmentDao.findById(1);
		department1.setName("Media");
		departmentDao.update(department1);
		System.out.println("Update Complete!");
		
		System.out.println("\n+++ TEST 5: department delete +++");
		System.out.println("Enter Id for delete test: ");
		int id = sc.nextInt();
		
		int rows = departmentDao.deleteById(id);
		
		if(rows > 0) {
			System.out.println("Delete Complete!");
		}else {
			System.out.println("Id not found! No rows are affected.");
		}


		sc.close();
	}
}
