package org.example.Controller;

import org.example.model.Cinta;
import org.example.Dao.CintaDAO;

import java.util.List;

public class ProgramController {

    public static void main(String[] args) {
        ProgramController programController = new ProgramController();
        programController.creaCinta();
    }
    public void creaCinta() {
        Cinta cinta = new Cinta(getCintaId(), generateCintaName(), generateCintaDirector());
        CintaDAO cintaDAO = new CintaDAO(); // Create an instance of the CintaDAO class
        cintaDAO.CreateCinta(cinta);
        cintaDAO.CreateDirector(cinta);
        System.out.println(cinta);
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

    public int getCintaId(){
        CintaDAO cintaDAO = new CintaDAO();
        return cintaDAO.GetLastIdCinta() + 1;
    }
}
