package com.jsp.customer_management.service;

import java.util.List;

import com.jsp.customer_management.dao.CustomerManagementDao;
import com.jsp.customer_management.dto.Admin;
import com.jsp.customer_management.dto.Dealer;
import com.jsp.customer_management.dto.Product;

public class CustomerManagementService {

	CustomerManagementDao cmd = new CustomerManagementDao();
	Admin tempAdmin = new Admin();

//insert new admin details
	public Admin insertAdmin(Admin admin) {
		tempAdmin = cmd.insertAdmin(admin);
		return tempAdmin;
	}

//login as admin 
	public Admin getAdminLoggedIn(Admin admin) {

		tempAdmin = cmd.getAdminLoggedIn(admin);

		if (tempAdmin.getAdminName() == admin.getAdminName()) {
			return tempAdmin;
		} else {
			return null;
		}

	}

//display all admin
	public List<Admin> displayAllAdmin() {
		return cmd.displayAllAdmin();
	}

//display single admin
	public Admin displaySingleAdmin(int adminId) {

		return cmd.displaySingleAdmin(adminId);
	}

//delete single admin 
	public void deleteAdmin(int id) {
		if (cmd.getById(id) == id) {
			cmd.deleteAdmin(id);
		} else {
			System.err.println("id doest not match");
		}

	}

// update single admin
	public Admin updateAdmin(Admin admin) {

		return cmd.updateAdmin(admin);
	}

//create a new dealer 
	public Dealer createNewDealer(Dealer dealer) {

		return cmd.createNewDealer(dealer);
	}

//display all dealer via list 	
	public List<Dealer> displayAllDealer() {
		return cmd.displayAllDealer();
	}

// delete single dealer
	public void deleteDealer(int id) {

		if (cmd.getDealerById(id) == id) {
			cmd.deleteDealer(id);
		} else {
			System.err.println("id doest not match");
		}
	}
	
//display single dealer
	public Dealer displaySingleDealer(int dealerId) {
		
		
		return cmd.displaySingleDealer(dealerId);
	
	}
//update dealer
	public Dealer updateDealer(Dealer dealer) {
		return cmd.updateDealer(dealer);
	}
	
//dealer method starts from here ///
//login as dealer
	public List<Dealer> dealerLoginRqst(String name,String email) {
		boolean login = false;
		
		List<Dealer> dealer = cmd.dealerLoginRqst(email);
	
		for(Dealer s: dealer) {
		
			if(s.getdealerName().equals(name)) {
				login = true;
			}else {
				login = false;
			}	
		}
		if(login) {
			return dealer;
		}else {
			return null;
		}
		
	}
	
//insert product
	public Product insertProduct(Product product, int dealerId) {
		return cmd.insertProduct(product, dealerId);	
	}
// insert product
	public int deleteProductByProductId(int productId) {
		if(cmd.fetchProductById(productId).getProductId()==productId) {
			return cmd.deleteProductByProductId(productId);
		}else {
			return 0;	
		}
		
	}
	//get product data object by product id 
	public Product fetchProductById(int productId) {
		Product product = cmd.fetchProductById(productId);
		if(product.getProductId()==productId) {
			return product;
		}else {
			return null;	
		}	
	}
	
//update product data
	public int updateProductData(Product product) {
		if(cmd.fetchProductById(product.getProductId()).getProductId()==product.getProductId()) {
		return cmd.updateProductData(product);			
		}else {
			return 0;
		}
	}
}
	
