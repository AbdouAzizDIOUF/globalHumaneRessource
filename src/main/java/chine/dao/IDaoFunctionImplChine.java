package chine.dao;

import chine.model.EmployerChine;
import chine.model.InfoPaieChine;
import chine.model.InfoProfessionelChine;
import chine.model.SalaireChine;
import dao.IDaoFunction;
import chine.database.DbConnexion;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class IDaoFunctionImplChine implements IDaoFunction<EmployerChine, InfoProfessionelChine, InfoPaieChine, SalaireChine> {

    public ResultSet resultSet = null;
    private PreparedStatement preparedStatement;

    public static List<EmployerChine> EMPLOYERS = null;
    public static List<InfoProfessionelChine> INFO_PROFFS = null;
    public static List<InfoPaieChine> INFO_PAIES = null;

    {
        try {
            EMPLOYERS = getEmployees();
            INFO_PAIES = getInfoPaies();
            INFO_PROFFS = getInfoProffs();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public List<EmployerChine> getEmployees() throws SQLException, ClassNotFoundException {
        List<EmployerChine> employerChineList = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM EmployerChine");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            EmployerChine employe = new EmployerChine();
            employe.setId(resultSet.getInt("id"));
            employe.setNom(resultSet.getString("nom"));
            employe.setPrenom(resultSet.getString("prenom"));
            employe.setAge(resultSet.getInt("age"));
            employe.setSexe(resultSet.getString("sexe"));
            employe.setTelephone(resultSet.getString("telephone"));
            employe.setEmail(resultSet.getString("email"));
            employe.setAdresse(resultSet.getString("adresse"));

            employerChineList.add(employe);
        }

        return employerChineList;
    }


    public List<InfoProfessionelChine> getInfoProffs() throws IOException, SQLException, ClassNotFoundException {
        List<InfoProfessionelChine> infoProfessionelChineList = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM InfoProfessionnelleChine");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            InfoProfessionelChine info = new InfoProfessionelChine();
            info.setNumMatricule(resultSet.getString("numMatricule"));
            info.setEmployeId(resultSet.getInt("employeId"));
            info.setStatut(resultSet.getString("statut"));
            info.setPoste(resultSet.getString("poste"));
            info.setVille(resultSet.getString("ville"));
            info.setContrat(resultSet.getString("contrat"));
            info.setDateDebutContrat(resultSet.getString("dateDebutContrat"));
            info.setDateFinContrat(resultSet.getString("dateFinContrat"));
            info.setDepartement(resultSet.getString("departement"));
            info.setSalaireDeBase(resultSet.getDouble("salairedebase"));
            info.setPays(resultSet.getString("pays"));

            infoProfessionelChineList.add(info);
        }

        return infoProfessionelChineList;
    }

    @Override
    public int getNombreEmployer() throws IOException, SQLException, ClassNotFoundException {
        return EMPLOYERS.size();
    }

    @Override
    public List<InfoPaieChine> getInfoPaiesByMounth(String date) throws SQLException, ClassNotFoundException {
        List<InfoPaieChine> infoPaies = new ArrayList<>();
        INFO_PAIES.forEach(paie->{
            if (paie.getPeriodePaie().equals(date)){
                infoPaies.add(paie);
            }});
        return infoPaies;
    }

    public List<InfoPaieChine> getInfoPaies() throws SQLException, ClassNotFoundException {
        List<InfoPaieChine> infoPaies = new ArrayList<>();
        preparedStatement = DbConnexion.getPreparedStatement("SELECT * FROM InfoPaieChine");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            InfoPaieChine paie = new InfoPaieChine();
            paie.setId(resultSet.getInt("id"));
            paie.setEmployeId(resultSet.getInt("employerId"));
            paie.setNombreHeure(resultSet.getDouble("nombreHeure"));
            paie.setTauxHoraire(resultSet.getDouble("tauxHoraire"));
            paie.setMontantAvantage(resultSet.getDouble("montantAvantage"));
            paie.setHeureSup(resultSet.getInt("heureSup"));
            paie.setMontantPret(resultSet.getDouble("montantPret"));
            paie.setPrimeRisque(resultSet.getDouble("primeRisque"));
            paie.setPrimeAnciennete(resultSet.getDouble("primeAnciennete"));
            paie.setPeriodePaie(resultSet.getString("periodePaie"));

            infoPaies.add(paie);
        }
        return infoPaies;
    }


    @Override
    public List<SalaireChine> getSalairesByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        List<SalaireChine> salaires = new ArrayList<>();
        EMPLOYERS.forEach(empl->{
            INFO_PROFFS.forEach(prof->
            {
                try {
                    getInfoPaiesByMounth(date).forEach(paie->{
                        if( (empl.getId()==prof.getEmployeId()) && (prof.getEmployeId() == paie.getEmployeId()))
                        {
                            SalaireChine salaire = new SalaireChine();
                            salaire.setMatricule(prof.getNumMatricule());
                            salaire.setNom(empl.getNom());
                            salaire.setPrenom(empl.getPrenom());
                            salaire.setNombreHeure(paie.getNombreHeure());
                            salaire.setHeureSup(paie.getHeureSup());
                            salaire.setAvantage(paie.getMontantAvantage());
                            salaire.setPrimeRisque(paie.getPrimeRisque());
                            salaire.setPrimeAncienete(paie.getPrimeAnciennete());
                            salaire.setPret(paie.getMontantPret());
                            salaire.setPays(prof.getPays());
                            salaire.setPoste(prof.getPoste());
                            salaire.setContrat(prof.getContrat());
                            salaire.setSalaire(getSalaire(paie));
                            salaire.setPeriodePaie(paie.getPeriodePaie());

                            salaires.add(salaire);
                        }
                    });
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });

        });
        Collections.sort(salaires);

        return salaires;
    }

    @Override
    public SalaireChine minSalaireEmployeByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return this.getSalairesByMounth(date).get(0);
    }

    @Override
    public SalaireChine maxSalaireEmployeByMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return this.getSalairesByMounth(date).get(getSalairesByMounth(date).size()-1);
    }

    @Override
    public double moyenSalaireMounth(String date) throws SQLException, IOException, ClassNotFoundException {
        return (this.getSalairesByMounth(date).stream().mapToDouble(SalaireChine::getSalaire).sum() / this.getSalairesByMounth(date).size());
    }

    @Override
    public double getBudgetTotal(String date) throws SQLException, IOException, ClassNotFoundException {
        return Math.round(this.getSalairesByMounth(date).stream().mapToDouble(SalaireChine::getSalaire).sum());
    }

    @Override
    public double pourcentageHomme() throws SQLException, IOException, ClassNotFoundException {
        return Math.round(100-this.pourcentageFeminin());
    }

    @Override
    public double pourcentageFeminin() {
        int nbFemmes = (int) EMPLOYERS.stream().filter(emp -> "feminin".equals(emp.getSexe())).count();
        return Math.round(((double) (nbFemmes*100)/EMPLOYERS.size()));
    }

    @Override
    public double pourcentageOuvriers() throws SQLException, IOException, ClassNotFoundException {
        return Math.round((100-this.pourcentageCadres()));
    }

    @Override
    public double pourcentageCadres() throws SQLException, IOException, ClassNotFoundException {
        int cadre = (int) INFO_PROFFS.stream().filter(p -> "Cadre".equals(p.getStatut())).count();
        return Math.round((double)((cadre * 100) / INFO_PROFFS.size()));
    }

    private Double getSalaire(InfoPaieChine paie){
        return ((paie.getNombreHeure() + paie.getHeureSup()) * paie.getTauxHoraire()) + paie.getMontantAvantage() + paie.getPrimeAnciennete() + paie.getPrimeRisque() - paie.getMontantPret();
    }
}
