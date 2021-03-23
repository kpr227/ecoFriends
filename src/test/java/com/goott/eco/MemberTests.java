package com.goott.eco;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={
		com.goott.eco.config.WebConfig.class,
		com.goott.eco.config.ServletConfig.class,
		com.goott.eco.config.RootConfig.class,
		com.goott.eco.config.SecurityConfig.class,
		com.goott.eco.config.SecurityIntializer.class
  })
@Log4j
public class MemberTests {

	@Setter(onMethod_ = { @Autowired})
	private PasswordEncoder pwEncoder;
  
	  
	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
	
	/*
	@Test
	public void testEncode() {
		String str = "member";
		String enStr = pwEncoder.encode(str);
		log.info("결과: "+enStr);
		System.out.println("결과: "+enStr);
	} 

*/
/*
	@Test
	public void testInsertMember() {

		String sql = "";
		sql +="insert into eco.cust(memberId, password, name, phone, email, regDate, regUser) "
	    	+ "values (?,?,?,?,?,?,?)";
		for(int k = 0; k < 2; k++) {
			for(int i = 0; i < 10; i++) {
		      
				Connection con = null;
				PreparedStatement pstmt = null;
		      
				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(sql);
		        
					pstmt.setString(2, pwEncoder.encode("pw" + i));
					pstmt.setString(4, "01055558888");
					pstmt.setString(6, "2021/03/08" );
					
					if(k == 0) {
		          
						pstmt.setString(1, "member"+i);
						pstmt.setString(3, "사용자"+i);
						pstmt.setString(5, "member"+i+"@goott.com");
						pstmt.setString(7, "member"+i );
					}else{
						pstmt.setString(1, "admin"+i);
						pstmt.setString(3,"운영자"+i);
						pstmt.setString(5, "admin"+i+"@goott.com");
						pstmt.setString(7, "admin"+i );
		          
					}
		        
					pstmt.executeUpdate();
		        
				}catch(Exception e) {
						e.printStackTrace();
				}finally {
					if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
					if(con != null) { try { con.close();  } catch(Exception e) {} }
			        
				}
			}//end for
		}
	}
}
*/

	@Test
	public void testInsertAuth() {
    
	    String sql ="";
	    sql +="insert into eco.cust_auth (memberId, auth) "
	    	+ "values (?,?)";
		    for(int i = 0; i < 10; i++) {
		      
		      Connection con = null;
		      PreparedStatement pstmt = null;
		      
		      try {
		        con = ds.getConnection();
		        pstmt = con.prepareStatement(sql);
		      
		        pstmt.setString(1, "admin"+i);
		        pstmt.setString(2, "ROLE_CUST");

		        pstmt.executeUpdate();
		        
		      }catch(Exception e) {
		    	  e.printStackTrace();
		      }finally {
		    	  if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
		    	  if(con != null) { try { con.close();  } catch(Exception e) {} }
		      }
		    }//end for
		}
	}





