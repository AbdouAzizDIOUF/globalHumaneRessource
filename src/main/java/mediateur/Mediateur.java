package mediateur;

import angleterre.dao.IDaoFunctionImplAngletterre;
import chine.dao.IDaoFunctionImplChine;
import com.graphbuilder.math.func.EFunction;
import france.dao.IDaoFunctionImplFrance;
import model.Salaire;
import senegal.dao.IDaoFunctionImplSenegal;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mediateur {

    private IDaoFunctionImplFrance france;
    private IDaoFunctionImplAngletterre angleterre;
    private IDaoFunctionImplSenegal senegal;
    private IDaoFunctionImplChine chine;


    public Mediateur(){
        this.france = new IDaoFunctionImplFrance();
        this.angleterre = new IDaoFunctionImplAngletterre();
        this.senegal = new IDaoFunctionImplSenegal();
        this.chine = new IDaoFunctionImplChine();
    }


    /**
     * Retourne le nombre total d'eployes
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int getNombreEmployes() throws IOException, SQLException, ClassNotFoundException {
        return this.angleterre.getNombreEmployer()+this.france.getNombreEmployer()+this.senegal.getNombreEmployer()+this.chine.getNombreEmployer();
    }

    /**
     * Retoune le pourcentage de Femme total
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public double getPourcentageFemme() throws IOException, SQLException, ClassNotFoundException {
        double result = this.angleterre.pourcentageFeminin()+this.france.pourcentageFeminin()+this.senegal.pourcentageFeminin()+this.chine.pourcentageFeminin();
        double result2 = this.angleterre.pourcentageHomme()+this.france.pourcentageHomme()+this.senegal.pourcentageHomme()+this.chine.pourcentageHomme();

        return (result*100)/(result+result2);
    }

    /**
     * Retoune le pourcentage de d'homme total
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public double getPourcentageHomme() throws IOException, SQLException, ClassNotFoundException {
        return (100-this.getPourcentageFemme());
    }

    /**
     * Retoune le pourcentage de Cadre
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public double getPourcentageCadres() throws IOException, SQLException, ClassNotFoundException {
        return (100 - this.getPourcentageOuvrier());
    }

    /**
     * Retoune le pourcentage de d'employes non cadre
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public double getPourcentageOuvrier() throws IOException, SQLException, ClassNotFoundException {
        double result = this.angleterre.pourcentageOuvriers()+this.france.pourcentageOuvriers()+this.senegal.pourcentageOuvriers()+this.chine.pourcentageOuvriers();
        double result1 = this.angleterre.pourcentageCadres()+this.france.pourcentageCadres()+this.senegal.pourcentageCadres()+this.chine.pourcentageCadres();

        return (result*100)/(result+result1);
    }

    /**
     * retourne le budget total
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public double getBudgetTotal(String date) throws IOException, SQLException, ClassNotFoundException {
        return this.angleterre.getBudgetTotal(date)+this.france.getBudgetTotal(date)+this.senegal.getBudgetTotal(date)+ chine.getBudgetTotal(date);
    }

    /**
     * Les employes avec la plus grosse salaire dans chaque pays
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Salaire> getEmployesMaxSalaires(String date) throws IOException, SQLException, ClassNotFoundException {
        List<Salaire> salairies = new ArrayList<>();
        salairies.add(this.angleterre.maxSalaireEmployeByMounth(date));
        salairies.add(this.france.maxSalaireEmployeByMounth(date));
        salairies.add(this.senegal.maxSalaireEmployeByMounth(date));
        salairies.add(this.chine.maxSalaireEmployeByMounth(date));

        return salairies;
    }

    /**
     * Les employes avec la plus petite salaire dans chaque pays
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Salaire> getEmployesMinSalaires(String date) throws IOException, SQLException, ClassNotFoundException {
        List<Salaire> salairies = new ArrayList<>();
        salairies.add(this.angleterre.minSalaireEmployeByMounth(date));
        salairies.add(this.france.minSalaireEmployeByMounth(date));
        salairies.add(this.senegal.minSalaireEmployeByMounth(date));
        salairies.add(this.chine.minSalaireEmployeByMounth(date));

        return salairies;
    }

    /**
     * La liste des salaires
     *
     * @param pays
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Salaire> getSalairesEmployes(String pays, String date) throws IOException, SQLException, ClassNotFoundException {
        List<Salaire> salairies = new ArrayList<>();
        switch (pays){
            case "Angleterre" -> {
                salairies.addAll(angleterre.getSalairesByMounth(date));
            }
            case "France" -> {
                salairies.addAll(france.getSalairesByMounth(date));
            }
            case "Chine" -> {
                salairies.addAll(chine.getSalairesByMounth(date));
            }
            case "Senegal" -> {
                salairies.addAll(senegal.getSalairesByMounth(date));
            }
            case "Max Salaire" -> {
                salairies.addAll(this.getEmployesMaxSalaires(date));
            }
            default -> {
                salairies.addAll(this.getEmployesMinSalaires(date));
            }
        };

        return salairies;
    }

    public IDaoFunctionImplFrance getFrance() {
        return france;
    }

    public IDaoFunctionImplAngletterre getAngleterre() {
        return angleterre;
    }

    public IDaoFunctionImplSenegal getSenegal() {
        return senegal;
    }

    public IDaoFunctionImplChine getChine() {
        return chine;
    }
}
