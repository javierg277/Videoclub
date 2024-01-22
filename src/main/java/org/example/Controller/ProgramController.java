package org.example.Controller;

import org.example.model.Cinta;
import org.example.Dao.CintaDAO;

import java.sql.SQLException;
import java.util.List;

public class ProgramController {

    public static void main(String[] args) {
        ProgramController programController = new ProgramController();

        // Crear y ejecutar múltiples hilos con retardo
        for (int i = 0; i < 50; i++) {
            Thread thread;
            if (i % 5 == 0) {
                thread = new Thread(programController::alquilaCinta);
            } else {
                thread = new Thread(programController::creaCinta);
            }
            thread.start();

            try {
                Thread.sleep(2000); // Retardo de 2 segundos entre la ejecución de cada hilo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void alquilaCinta() {
        try {
            String resultado = AlquilaCinta();
            System.out.println(resultado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void creaCinta() {
        Cinta cinta = new Cinta(0, generateCintaName(), generateCintaDirector());
        CintaDAO cintaDAO = new CintaDAO(); // Crear una instancia de la clase CintaDAO
        cintaDAO.CreateCinta(cinta);
        cintaDAO.CreateDirector(cinta);
        System.out.println(cinta.getName() + " by " + cinta.getDirector() + " Cinta añadida");
    }
    public String generateCintaDirector() {
        List nombres = List.of("Antonio","Javi","Cristian","Manuel","Mariano","Matías","Alvaro");
        List Apellidos = List.of("González","Jímenez","Aguilar","Gutierrez","Barcenas","Romero","Rajoy");

        return nombres.get((int) (Math.random() * nombres.size())) + " " + Apellidos.get((int) (Math.random() * Apellidos.size()));
    }

    public String generateCintaName(){
        List nombre1 = List.of("mining","race","explosives","sadness","loving","farting","Spitting");
        List nombre2 = List.of("At The Leaders","In the river","Of the cock","With the tits","at my anus","of the pussy","in my mouth");
        return nombre1.get((int) (Math.random() * nombre1.size())) + " " + nombre2.get((int) (Math.random() * nombre2.size()));
    }

    public String AlquilaCinta()throws SQLException {
        CintaDAO cintaDAO = new CintaDAO();
        String cintaAlquilada = generateCintaName();
        if(cintaDAO.ExisteCinta(cintaAlquilada)) {
            System.out.println( "Cinta Alquilada " + cintaAlquilada);
        }else {
            System.out.println("La cinta no existe " + cintaAlquilada);
            return "Saldre de la tienda";
        }
        return "Seguire comprando";
    }
}
