package com.goott.eco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleDBConnectionTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String user = "eco"; 
//        String pw = "eco1234";
//        String url = "jdbc:oracle:thin:@172.16.5.1:1521:orcl";
        String pw = "eco123456789";
        String url = "jdbc:oracle:thin:@studydb.csm9yowkmr1i.ap-northeast-2.rds.amazonaws.com:1521:orcl";
        
        Class.forName("oracle.jdbc.driver.OracleDriver");        
        Connection conn = DriverManager.getConnection(url, user, pw);

        
        String detail = "<p></p><div style=\"text-align: center;\\\" align=\\\"center\\\"><img src=\\\"/upload/img/temp/202103181810430a884646-c4ea-43a8-b3ec-2f4d7a3ee951.jpg\\\" title=\\\"5c312d93306b13d41e4dc4810f6260878dc0afd62ad75f5264aa3c233f65%20(1).jpg\\\"></div><div style=\\\"text-align: center;\\\" align=\\\"center\\\"><img src=\\\"/upload/img/temp/2021031818104366b20338-c8e6-4d6b-843b-62dbd96044a6.jpg\\\" title=\\\"6b64aaf771a77c0ceb4119ab5ed1816c80bc49b5f571a4f9ce8a8f3399b4.jpg\\\"></div><div style=\\\"text-align: center;\\\" align=\\\"center\\\"><img src=\\\"/upload/img/temp/20210318181043597c4e7d-0c8a-4ceb-aa96-3b30708b7c03.jpg\\\" title=\\\"414bcabb4a83e2c2a68a8a59afd37f99beea963b1a784d0a1dfc062829b4.jpg\\\"></div><div style=\\\"text-align: center;\\\" align=\\\"center\\\"><img src=\\\"/upload/img/temp/202103181810437b421ee6-bbc7-4f60-a22f-cc245de86f8b.jpg\\\" title=\\\"8700bde15dd1f6094d8b259ec72d4b389f8068b41903b99438361c831e02.jpg\\\"></div><div style=\\\"text-align: center;\\\" align=\\\"center\\\"><img src=\\\"/upload/img/temp/2021031818104386d709c2-8eaf-4728-bff3-a3bac67be309.jpg\\\" title=\\\"62519adb223ee2917e271e9c2850b5520c81317a7ac5d4e9177fe083287a%20(1).jpg\\\"></div><div style=\\\"text-align: center;\\\" align=\\\"center\\\"><img src=\\\"/upload/img/temp/202103181810438be141fb-fa4a-4eae-9652-e7a3cd3604fa.jpg\\\" title=\\\"efbce69dd99906cb3b0e14cbc4fd49384579ece06c7dc0d678228d2a8290.jpg\\\"></div><div style=\\\"text-align: center;\\\"><br></div><p></p>";
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("update goods set goods_detail = '" + detail + "' where goods_seq = 7");
        
        rs.next();
        rs.close();
        stmt.close();
        conn.close();
	}
}
