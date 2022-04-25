package org.example.mensaje_app.util;

import java.sql.Connection;

public class Inicio {
    public static void main(String[] args){
        Conexion conexion= new Conexion();
        try (Connection cnx = conexion.get_connetion()){

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
