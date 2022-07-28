package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		System.out.println("\n+++ TEST 1: selle findById +++");
		System.out.println(seller);
		
		System.out.println("\n+++ TEST 2: seller findByDepartment +++");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}	
		
		System.out.println("\n+++ TEST 3: seller findAll +++");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n+++ TEST 4: seller insert +++");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted ! New ID: " + newSeller.getId());
		
		System.out.println("\n+++ TEST 5: seller update +++");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update Complete!");
		
		System.out.println("\n+++ TEST 5: seller delete +++");
		System.out.println("Enter Id for delete test: ");
		int id = sc.nextInt();
		
		int rows = sellerDao.deleteById(id);
		
		if(rows > 0) {
			System.out.println("Delete Complete!");
		}else {
			System.out.println("Id not found! No rows are affected.");
		}


		sc.close();
	}
}
