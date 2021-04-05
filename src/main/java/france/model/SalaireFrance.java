package france.model;


import lombok.*;
import model.Salaire;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor @Data
public class SalaireFrance extends Salaire {

    private double indTransport;
    private double indMatrimoniale;

    public SalaireFrance(String matricule, String nom, String prenom, Double nombreHeure, int heureSup, double avantage, double pret, double salaire, String periodePaie, String pays, String poste, String contrat, double indTransport, double indMatrimoniale) {
        super(matricule, nom, prenom, nombreHeure, heureSup, avantage, pret, salaire, periodePaie, pays, poste, contrat);
        this.indTransport = indTransport;
        this.indMatrimoniale = indMatrimoniale;
    }

    @Override
    public String toString() {
        return super.toString() +
                "indTransport=" + indTransport +
                ", indMatrimoniale=" + indMatrimoniale +
                '}';
    }
}
