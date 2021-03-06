package senegal.modele;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.Salaire;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @Data
public class SalaireSenegal extends Salaire {

    private double primeAssidute;
    private double impotRevenue;
    private double primeRestauration;

    public SalaireSenegal(String matricule, String nom, String prenom, Double nombreHeure, int heureSup, double avantage, double pret, double salaire, String periodePaie, String pays, String poste, String contrat, double primeAssidute, double impotRevenue, double primeRestauration) {
        super(matricule, nom, prenom, nombreHeure, heureSup, avantage, pret, salaire, periodePaie, pays, poste, contrat);
        this.primeAssidute = primeAssidute;
        this.impotRevenue = impotRevenue;
        this.primeRestauration = primeRestauration;
    }

    @Override
    public String toString() {
        return super.toString() +
                "primeAssidute=" + primeAssidute +
                ", impotRevenue=" + impotRevenue +
                ", primeRestauration=" + primeRestauration +
                '}';

    }
}
