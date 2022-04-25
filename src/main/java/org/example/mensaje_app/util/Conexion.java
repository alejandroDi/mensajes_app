package org.example.mensaje_app.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connetion(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/mensajes_app","postgres","Postgres2022$");

        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
