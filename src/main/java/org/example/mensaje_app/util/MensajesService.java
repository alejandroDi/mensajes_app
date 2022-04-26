package org.example.mensaje_app.util;

import java.util.Scanner;

public class MensajesService {


    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu mensaje:");
        String mensaje = sc.nextLine();

        System.out.println("tu nombre:");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);

        MensajesDAO.crearMensajeDB(registro);


    }

    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();

    }

    public static Inicio borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        int id = 0;
        System.out.println("Escribe id a eliminar");
        id = sc.nextInt();
        boolean idverif = MensajesDAO.ValidarId(id);
        if (idverif == false){
            Inicio inicio = new Inicio();
            return inicio;
        }else {
            MensajesDAO.borrarMensajeDB(id);
        }

        return null;
    }

    public static Inicio editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje:");
        String mensaje = sc.nextLine();

        System.out.println("Indica el id del mensaje a editar:");
        int id = sc.nextInt();
        boolean idverif = MensajesDAO.ValidarId(id);
        if (idverif == false){
            Inicio inicio = new Inicio();
            return inicio;
        }else {
            Mensajes actualizacion = new Mensajes();
            actualizacion.setId_mensaje(id);
            actualizacion.setMensaje(mensaje);

            MensajesDAO.actualizarMensajeDB(actualizacion);
        }


        return null;
    }
}
