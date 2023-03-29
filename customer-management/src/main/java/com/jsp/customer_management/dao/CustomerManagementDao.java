package com.jsp.customer_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.customer_management.connection.JDBCConnection;
import com.jsp.customer_management.dto.Admin;
import com.jsp.customer_management.dto.Dealer;
import com.jsp.customer_management.dto.Product;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class CustomerManagementDao {

	Connection connection = null;

//super user methods=============================================================================// 	

	// insert admin method
	public Admin insertAdmin(Admin admin) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String InsertAdmin = "INSERT INTO sadmin VALUES(?,?,?)";
				ps = connection.prepareStatement(InsertAdmin);
				ps.setInt(1, admin.getAdminId());
				ps.setString(2, admin.getAdminName());// this should be of 8
				ps.setString(3, admin.getAdminEmail());

				ps.execute();

				return admin;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

		return null;
	}

//display single admin 
	public Admin displaySingleAdmin(int adminId) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String singleAdmin = "SELECT * from sadmin where adminId = ?";

				ps = connection.prepareStatement(singleAdmin);
				ps.setInt(1, adminId);
				ResultSet resultSet = ps.executeQuery();
				Admin admin = new Admin();

				while (resultSet.next()) {

					admin.setAdminId(resultSet.getInt("adminId"));
					admin.setAdminName(resultSet.getString("adminName"));
					admin.setAdminEmail(resultSet.getString("adminEmail"));

				}

				return admin;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		}
		return null;
	}

// display all admin 
	public List<Admin> displayAllAdmin() {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String allAdmin = "SELECT * from sadmin";

				ps = connection.prepareStatement(allAdmin);
				ResultSet resultSet = ps.executeQuery();
				List<Admin> adminList = new ArrayList<Admin>();

				while (resultSet.next()) {
					Admin admin = new Admin();

					admin.setAdminId(resultSet.getInt("adminId"));
					admin.setAdminName(resultSet.getString("adminName"));
					admin.setAdminEmail(resultSet.getString("adminEmail"));

					adminList.add(admin);
				}

				return adminList;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		}
		return null;
	}

// update admin with name and email
	public Admin updateAdmin(Admin admin) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {

				String update = "UPDATE sadmin SET adminName=?, adminEmail=? WHERE adminId=?";

				ps = connection.prepareStatement(update);

				ps.setString(1, admin.getAdminName());
				ps.setString(2, admin.getAdminEmail());
				ps.setInt(3, admin.getAdminId());

				ps.executeUpdate();

				return admin;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}
		return null;

	}

	// delete admin
	public void deleteAdmin(int adminId) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String delete = "DELETE FROM sadmin WHERE adminId=?";

				ps = connection.prepareStatement(delete);

				ps.setInt(1, adminId);

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}
	}

	// get by admin id
	public int getById(int id) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		int temp = 0;

		if (connection != null) {
			try {

				String getById = "SELECT * from sadmin where adminId = ?";

				ps = connection.prepareStatement(getById);
				ps.setInt(1, id);
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					temp = resultSet.getInt("adminId");
				}
				return temp;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("Please check your url or username or password");
		}

		return 0;
	}

	// logged in admin dao
	// methods==============================================================================//

	// admin login name and email confirmation
	public Admin getAdminLoggedIn(Admin admin) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String getById = "SELECT * from sadmin where adminId = ?";

				ps = connection.prepareStatement(getById);

				ps.setInt(1, admin.getAdminId());

				ResultSet resultSet = ps.executeQuery();

				while (resultSet.next()) {
					admin.setAdminName(resultSet.getString("adminName"));
					admin.setAdminEmail(resultSet.getString("adminEmail"));
				}

				return admin;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("Please check your url or username or password");
		}

		return null;
	}

	// insert new dealer
	public Dealer createNewDealer(Dealer dealer) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String insertNewDealer = "INSERT INTO sdealer VALUES(?,?,?,?)";
				ps = connection.prepareStatement(insertNewDealer);
				ps.setInt(1, dealer.getdealerId());
				ps.setString(2, dealer.getdealerName());// this should be of 8
				ps.setString(3, dealer.getdealerEmail());
				ps.setLong(4, dealer.getdealerPhone());

				ps.execute();
				return dealer;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

		return null;
	}

	// display single dealer
	public Dealer displaySingleDealer(int dealerId) {

		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String singledealer = "SELECT * from sdealer where dealerId = ?";

				ps = connection.prepareStatement(singledealer);
				ps.setInt(1, dealerId);
				ResultSet resultSet = ps.executeQuery();
				Dealer dealer = new Dealer();

				while (resultSet.next()) {

					dealer.setdealerId(resultSet.getInt("dealerId"));
					dealer.setdealerName(resultSet.getString("dealerName"));
					dealer.setdealerEmail(resultSet.getString("dealerEmail"));
					dealer.setdealerPhone(resultSet.getLong("dealerPhone"));

				}

				return dealer;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		}
		return null;
	}

	// display all dealer
	public List<Dealer> displayAllDealer() {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String dispalayAllDealer = "SELECT * from sdealer";

				ps = connection.prepareStatement(dispalayAllDealer);
				ResultSet resultSet = ps.executeQuery();
				List<Dealer> dealerList = new ArrayList<Dealer>();

				while (resultSet.next()) {
					Dealer dealer = new Dealer();

					dealer.setdealerId(resultSet.getInt("dealerId"));
					dealer.setdealerName(resultSet.getString("dealerName"));
					dealer.setdealerEmail(resultSet.getString("dealerEmail"));
					dealer.setdealerPhone(resultSet.getLong("dealerPhone"));

					dealerList.add(dealer);
				}

				return dealerList;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		}
		return null;

	}

	// get dealer by id
	public int getDealerById(int id) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		int temp = 0;

		if (connection != null) {
			try {

				String getById = "SELECT * from sdealer where dealerId = ?";

				ps = connection.prepareStatement(getById);
				ps.setInt(1, id);
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					temp = resultSet.getInt("dealerId");
				}
				return temp;

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("Please check your url or username or password");
		}

		return 0;

	}

	// delete dealer
	public void deleteDealer(int dealerId) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String delete = "DELETE FROM sdealer WHERE dealerId=?";

				ps = connection.prepareStatement(delete);

				ps.setInt(1, dealerId);

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

	}

	//update dealer
	public Dealer updateDealer(Dealer dealer) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		if (connection != null) {
			try {

				String update = "UPDATE sdealer SET dealerName=?, dealerEmail=?, dealerPhone=? WHERE dealerId=?";

				ps = connection.prepareStatement(update);

				ps.setString(1, dealer.getdealerName());
				ps.setString(2, dealer.getdealerEmail());
				ps.setLong(3, dealer.getdealerPhone());
				ps.setInt(4, dealer.getdealerId());

				ps.executeUpdate();

				return dealer;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}
		return null;
	}
	
//
//dealer method starts from here.////////////////////////////////////////
	//login  in as dealer 
	public List<Dealer> dealerLoginRqst(String email) {
		
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		
		if (connection != null) {
			try {
				
				String seclectQueryForLogin = "SELECT * from sdealer where dealerEmail=?";

				ps = connection.prepareStatement(seclectQueryForLogin);
				ps.setString(1, email);
				List<Dealer> dealers = new ArrayList<Dealer>();
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {
					
					Dealer dealer = new Dealer();
					
					dealer.setdealerId(resultSet.getInt("dealerId")); 					
					dealer.setdealerName(resultSet.getString("dealerName"));					
					dealer.setdealerEmail(resultSet.getString("dealerEmail"));					
					dealer.setdealerPhone(resultSet.getLong("dealerPhone"));
					
					dealers.add(dealer);	
				}
			
			return dealers;
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("Please check your url or username or password");
		}
		return null;
	}
	
	//insert product with dealerId
	public Product insertProduct(Product product,int dealerId) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;

		if (connection != null) {
			try {

				String insertNewproduct = "INSERT INTO sproduct VALUES(?,?,?,?,?)";
				ps = connection.prepareStatement(insertNewproduct);
				ps.setInt(1, product.getProductId());
				ps.setString(2, product.getProductName());
				ps.setDouble(3, product.getProductPrice());
				ps.setBoolean(4, product.getProductAvailable());
				
				
				ps.setInt(5, dealerId);

				ps.execute();
				
				return product;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("Please check your url or username or password");
		}

		return null;
	}

	//diplay product by dealerId
	public List<Product> displayProduct(int dealerId) {
		
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		List<Product> productList= new ArrayList<Product>();
		
		if(connection!=null) {
			try {
			
				String displayAllProduct = "SELECT * from sproduct where dealerId = ?";
				
				ps = connection.prepareStatement(displayAllProduct);
				ps.setInt(1, dealerId);
				
				ResultSet resultSet = ps.executeQuery();
				
				System.out.println("in try block");
				
				while(resultSet.next()) {
					
					Product product = new Product();
					
					product.setProductId(resultSet.getInt("productId"));
					product.setProductName(resultSet.getString("productName"));
					product.setProductPrice(resultSet.getDouble("productPrice"));
					product.setProductAvailable(resultSet.getBoolean("productAvailability"));
					
					productList.add(product);
				
				}
				
				return productList;
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	//delete product by dealer id
	public int deleteProductByProductId(int productId) {
		
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		
		if(connection!=null) {
			try {
				
				String delete = "DELETE FROM sproduct where productId = ?";
				ps = connection.prepareStatement(delete);
				ps.setInt(1, productId);
				int i = ps.executeUpdate();
				
			return i;
			}catch (Exception e) {
			e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return 0;
	}
	
	//get productid confirmation by giving product id 
	public Product fetchProductById(int productId) {
		
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		
		if(connection!=null) {
			try {
			
				String fectchOneProduct = "SELECT * from sproduct where productId = ?";
				
				ps = connection.prepareStatement(fectchOneProduct);
				ps.setInt(1, productId);
				
				ResultSet resultSet = ps.executeQuery();
				
				Product product = new Product();
				while(resultSet.next()) {
					
					product.setProductId(resultSet.getInt("productId"));
					product.setProductName(resultSet.getString("productName"));
					product.setProductPrice(resultSet.getDouble("productPrice"));
					product.setProductAvailable(resultSet.getBoolean("productAvailability"));	
				}
				return product;
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	//update product data 
	public int updateProductData(Product product) {
		connection = JDBCConnection.getJdbcConnection();
		PreparedStatement ps = null;
		try {
			String updateProduct = "UPDATE sproduct SET productName=?, ProductPrice=?, ProductAvailability=? WHERE productId=?";
			
			ps = connection.prepareStatement(updateProduct);
			
			ps.setString(1, product.getProductName());
			ps.setDouble(2, product.getProductPrice());
			ps.setBoolean(3, product.getProductAvailable());
			ps.setInt(4, product.getProductId());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}

}































