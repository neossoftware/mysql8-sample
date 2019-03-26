package org.neosuniversity;

import java.sql.*;

public class SampleConnection {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driverClassName = "com.mysql.jdbc.Driver";
        //nuevo driver mysql 8 com.mysql.cj.jdbc.Driver
        String connectionUrl = "jdbc:mysql://localhost:3306/inventory?serverTimezone=UTC";
        String dbUser = "root";
        String dbPwd = "discom";

        Class.forName(driverClassName);

        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);

       PreparedStatement stm = conn.prepareStatement("Select * from proveedor");


        ResultSet rs = stm.executeQuery();
        while(rs.next()){

            System.out.println(rs.getString("nombre"));

        }



    }
}
