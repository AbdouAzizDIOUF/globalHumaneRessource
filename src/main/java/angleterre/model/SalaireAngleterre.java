package angleterre.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.Salaire;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor @Data
public class SalaireAngleterre extends Salaire{


    private Double indTransport;
    private Double indLogement;

    public SalaireAngleterre(String matricule, String nom, String prenom, Double nombreHeure, int heureSup, double avantage, double pret, double salaire, String periodePaie, String pays, String poste, String contrat, Double indTransport, Double indLogement) {
        super(matricule, nom, prenom, nombreHeure, heureSup, avantage, pret, salaire, periodePaie, pays, poste, contrat);
        this.indTransport = indTransport;
        this.indLogement = indLogement;
    }

    @Override
    public String toString() {
        return super.toString()+
                "indTransport=" + indTransport +
                ", indLogement=" + indLogement +
                '}';
    }
}
