package org.example.mensaje_app.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {
    static Conexion db_connect = new Conexion();
    public static void crearMensajeDB(Mensajes mensajes){
        try (Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps=null;
            try {
                String query ="INSERT INTO mensajes (mensaje,autor_mensaje,fecha_mensaje) VALUES (?,?,now());";
                ps=conexion.prepareStatement(query);
                ps.setString(1,mensajes.getMensaje());
                ps.setString(2,mensajes.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");

            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void leerMensajesDB(){
        try (Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps= null;
            ResultSet rs = null;
                String query ="SELECT *FROM mensajes;";
                ps=conexion.prepareStatement(query);
                rs=ps.executeQuery();
                while (rs.next()){
                    System.out.println("ID: "+rs.getInt("id"));
                    System.out.println("Mensaje: "+rs.getString("mensaje"));
                    System.out.println("Autor: "+rs.getString("autor_mensaje"));
                    System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                    System.out.println("");
                }


        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void borrarMensajeDB(int id_mensaje){
        try (Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps=null;
            try {
                String query ="DELETE FROM mensajes WHERE id = ?;";
                ps=conexion.prepareStatement(query);
                ps.setInt(1,id_mensaje);
                ps.executeUpdate();
                System.out.println("el mensaje ha sido borrado");

            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void actualizarMensajeDB(Mensajes mensaje){
        try (Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps=null;
            try {
                String query ="UPDATE mensajes SET mensaje = ? WHERE id = ?;";
                ps=conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setInt(2,mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje se ha actualizado correctamente");

            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static boolean ValidarId(int id){
        try (Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps= null;
            ResultSet rs = null;
            String query ="SELECT *FROM mensajes WHERE id = ?;";
            ps=conexion.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            rs=ps.executeQuery();



        }catch (SQLException e){
            System.out.println("No exite ID ("+e+")");
            return false;
        }

        return false;
    }
}
