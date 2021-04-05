import angleterre.model.SalaireAngleterre;
import mediateur.Mediateur;
import model.Salaire;

import java.io.IOException;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Mediateur m = new Mediateur();

        m.getEmployesMaxSalaires("01/02/2021-28/02/2021").forEach(s-> System.out.println(s.toString()));
       // m.getEmployesMinSalaires("01/01/2021-31/01/2021").forEach(salaire -> System.out.println(salaire.toString()));

        //System.out.println(m.getPourcentageCadres());
        //System.out.println(m.getPourcentageOuvrier());
        //System.out.println(m.getPourcentageHomme());
        //System.out.println(m.getPourcentageFemme());
        //System.out.println(m.getSenegal().getBudgetTotal("01/01/2021-31/01/2021"));


    }
}
