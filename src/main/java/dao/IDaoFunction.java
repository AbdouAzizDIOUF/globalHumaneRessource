package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @param <Emp> Employe[Pays]
 * @param <Prof> InfoProfessionelle[pays]
 * @param <Paie> InfoPaie[Pays]
 * @param <Sal>
 */
public interface IDaoFunction <Emp, Prof, Paie, Sal> {

    /**
     * Retourne le nombre d'employe d'un pour un pays
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    int getNombreEmployer() throws IOException, SQLException, ClassNotFoundException;

    /**
     * Retourne les info paie des selons une date donnees
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<Paie> getInfoPaiesByMounth(String date) throws IOException, SQLException, ClassNotFoundException;

    /**
     * Obtenir la liste des salaire calcules
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<Sal> getSalairesByMounth(String date) throws IOException, SQLException, ClassNotFoundException;

    /**
     * L'employe qui a le salaire min
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    Sal minSalaireEmployeByMounth(String date) throws IOException, SQLException, ClassNotFoundException;

    /**
     * L'employe qui a le salaire max
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    Sal maxSalaireEmployeByMounth(String date) throws IOException, SQLException, ClassNotFoundException;

    /**
     * La moyenne des salaires
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    double moyenSalaireMounth(String date) throws IOException, SQLException, ClassNotFoundException;

    /**
     * Le budget Salariale
     *
     * @param date
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    double getBudgetTotal(String date) throws IOException, SQLException, ClassNotFoundException;

    /**
     * Le pourcentage D'Homme
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    double pourcentageHomme() throws IOException, SQLException, ClassNotFoundException;

    /**
     * Le pourcentage de Femmes
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    double pourcentageFeminin() throws IOException, SQLException, ClassNotFoundException;

    /**
     * Le pourcentage D'Ouvrirers
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    double pourcentageOuvriers() throws IOException, SQLException, ClassNotFoundException;

    /**
     * Le pourcentage de Cadres
     *
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    double pourcentageCadres() throws IOException, SQLException, ClassNotFoundException;
}
