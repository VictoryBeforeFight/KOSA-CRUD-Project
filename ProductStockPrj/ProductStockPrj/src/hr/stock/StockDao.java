package hr.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hr.DataSource;

public class StockDao implements IStockDao{
	//제품정보 등록, 가격 & 수량 수정, 삭제(단종), 선택한제품 조회, 전제 조회
	
	@Override
	public void insertProduct(StockVo info) {
		Connection con = null;
		try {
			con = DataSource.getConnection();
			String sql = "insert into products (product_id, name, price, company, quantity, margin_rate) "
					+ "values (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, info.getProductId());
			stmt.setString(2, info.getName());
			stmt.setInt(3, info.getPrice());
			stmt.setString(4, info.getCompany());
			stmt.setInt(5, info.getQuantity());
			stmt.setDouble(6, info.getMarginRate());
			stmt.executeUpdate();
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			DataSource.closeConnection(con);
		}	
	}	
	
  @Override
   public void updatePrice(StockVo info) {
      //가격 수정 
      Connection con = null;
      try {
         con = DataSource.getConnection();
         String sql = "update products set price=? where name=?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setInt(1, info.getPrice());
         stmt.setString(2, info.getName());
         stmt.executeUpdate();
      }catch(Exception e) {
         throw new RuntimeException(e);
      }finally {
         DataSource.closeConnection(con);
      }      
   }

  
   @Override
   public void updateQuantity(StockVo info) {
      //개수 수정
      Connection con = null;
      try {
         con = DataSource.getConnection();
         String sql = "update products set quantity=? where name=?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setInt(1, info.getQuantity());
         stmt.setString(2, info.getName());
         stmt.executeUpdate();
      }catch(Exception e) {
         throw new RuntimeException(e);
      }finally {
         DataSource.closeConnection(con);
      }   
      
   }
   
   
   @Override
	public void deleteProduct(String name) {
		Connection con = null;
		try {
			con = DataSource.getConnection();
			con.setAutoCommit(false);
			String sql = "DELETE FROM products WHERE name = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			int deleteCount = stmt.executeUpdate();
			if (deleteCount == 0) {
				throw new RuntimeException("제품 정보가 삭제되지 않았습니다.");
			}
			con.commit();
		}catch(Exception e) {
			try {con.rollback();} catch(Exception e2) {
				System.out.println(e2.getMessage());
			}
			throw new RuntimeException(e);
		}finally {
			try {con.setAutoCommit(true);} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			DataSource.closeConnection(con);
		}	
	}

	
	@Override
	public StockVo selectProduct(String name) {
		
		Connection con = null;
		try {
			con = DataSource.getConnection();

			String sql = "select product_id, name, price, company, quantity, "
					+ "margin_rate from products where name=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				//조회한 데이터가 있을 경우
				StockVo product = new StockVo();
				product.setProductId(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setCompany(rs.getString("company"));
				product.setQuantity(rs.getInt("quantity"));
				product.setMarginRate(rs.getDouble("margin_rate"));
				return product;
			}
			else {
				//조회한 데이터가 없을 경우
				throw new RuntimeException("조회한 제품의 정보가 없습니다.");
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			DataSource.closeConnection(con);
		}
		
	}
	
	
	
	
	
	@Override
	public List<StockVo> selectAllProduct() {
		
		Connection con = null;
		List<StockVo> productList = new ArrayList<>();
		try {
			con = DataSource.getConnection();
			String sql = "select product_id, name, price, company, quantity, margin_rate from products";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//제품 정보 조회해서 product 객체에 저장하고, product 객체를 productList에 add()
				StockVo product = new StockVo();
				product.setProductId(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setCompany(rs.getString("company"));
				product.setQuantity(rs.getInt("quantity"));
				product.setMarginRate(rs.getDouble("margin_rate"));
				productList.add(product);
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			DataSource.closeConnection(con);
		}
		return productList;
	}
	
}
