package angleterre.dao;

import angleterre.model.EmployerAngleterre;
import angleterre.model.InfoPaieAngleterre;
import angleterre.model.InfoProfessionelAngleterre;
import angleterre.model.SalaireAngleterre;
import dao.IDaoFunction;

import java.io.IOException;
import java.util.*;

public class IDaoFunctionImplAngletterre implements IDaoFunction<EmployerAngleterre, InfoProfessionelAngleterre, InfoPaieAngleterre, SalaireAngleterre> {

    private static final String PATH = "E:\\Projets\\java\\classe\\projetIntegrationWithMaven\\src\\main\\resources\\datasources\\angleterre\\";

    public static List<EmployerAngleterre> EMPLOYERS = null;
    public static List<InfoProfessionelAngleterre> INFO_PROFFS = null;
    public static List<InfoPaieAngleterre> INFO_PAIES = null;

    static{
        try {
            EMPLOYERS = DisplayMethode.getEmployees();
            INFO_PAIES = DisplayMethode.getInfoPaies();
            INFO_PROFFS = DisplayMethode.getInfoProffs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double moyenSalaireMounth(String date) throws IOException {
        return (this.getSalairesByMounth(date).stream().mapToDouble(SalaireAngleterre::getSalaire).sum() / this.getSalairesByMounth(date).size());
    }

    @Override
    public int getNombreEmployer() throws IOException {
        return EMPLOYERS.size();
    }

    @Override
    public double getBudgetTotal(String date) throws IOException {
        return Math.round(this.getSalairesByMounth(date).stream().mapToDouble(SalaireAngleterre::getSalaire).sum());
    }

    @Override
    public double pourcentageFeminin() throws IOException {
        int nbFemmes = (int) EMPLOYERS.stream().filter(emp -> "feminin".equals(emp.getSexe())).count();
        return Math.round(((double) (nbFemmes*100)/EMPLOYERS.size()));
    }

    @Override
    public double pourcentageHomme() throws IOException {
        int nbHommes = (int) EMPLOYERS.stream().filter(emp -> "masculin".equals(emp.getSexe())).count();
        return  Math.round(((double)(nbHommes*100)/EMPLOYERS.size()));
    }

    @Override
    public double pourcentageCadres() throws IOException {
        int cadre = (int) INFO_PROFFS.stream().filter(p -> "Cadre".equals(p.getStatut())).count();
        return Math.round((double)((cadre * 100) / INFO_PROFFS.size()));
    }

    @Override
    public double pourcentageOuvriers() throws IOException {
        return Math.round((100-this.pourcentageCadres()));
    }

    @Override
    public SalaireAngleterre minSalaireEmployeByMounth(String date) throws IOException {
        return this.getSalairesByMounth(date).get(0);
    }

    @Override
    public SalaireAngleterre maxSalaireEmployeByMounth(String date) throws IOException {
        return this.getSalairesByMounth(date).get(getSalairesByMounth(date).size()-1);
    }



    @Override
    public List<SalaireAngleterre> getSalairesByMounth(String date) throws IOException {
        List<SalaireAngleterre> salaires = new ArrayList<>();
        EMPLOYERS.forEach(empl->{
            INFO_PROFFS.forEach(prof->{
                try {
                    getInfoPaiesByMounth(date).forEach(paie->{
                        if( (empl.getId()==prof.getEmployeId()) && (prof.getEmployeId() == paie.getEmployeId()))
                        {
                            SalaireAngleterre salaire = new SalaireAngleterre();
                            salaire.setMatricule(prof.getNumMatricule());
                            salaire.setNom(empl.getNom());
                            salaire.setPrenom(empl.getPrenom());
                            salaire.setNombreHeure(paie.getNombreHeure());
                            salaire.setHeureSup(paie.getHeureSup());
                            salaire.setAvantage(paie.getMontantAvantage());
                            salaire.setIndLogement(paie.getIndLogement());
                            salaire.setIndTransport(paie.getIndTransport());
                            salaire.setPret(paie.getMontantPret());
                            salaire.setPays(prof.getPays());
                            salaire.setPoste(prof.getPoste());
                            salaire.setContrat(prof.getContrat());
                            salaire.setSalaire(getSalaire(paie));
                            salaire.setPeriodePaie(paie.getPeriodePaie());

                            salaires.add(salaire);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
        Collections.sort(salaires);

        return salaires;
    }



    @Override
    public List<InfoPaieAngleterre> getInfoPaiesByMounth(String date) throws IOException{
        List<InfoPaieAngleterre> infoPaieList = new ArrayList<>();
        INFO_PAIES.forEach(paie->{
            if (paie.getPeriodePaie().equals(date)){
                infoPaieList.add(paie);
            }});

        return infoPaieList;
    }



    private Double getSalaire(InfoPaieAngleterre paie){
       return ((paie.getNombreHeure() + paie.getHeureSup()) * paie.getTauxHoraire()) + paie.getMontantAvantage() + paie.getIndLogement() + paie.getIndTransport() - paie.getMontantPret();
    }

    private static int getIntValue(String val){
        String value = val.substring(0, val.lastIndexOf("."));
        return Integer.parseInt(value);
    }
}
