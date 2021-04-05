package angleterre;

import angleterre.dao.IDaoFunctionImplAngletterre;

import java.io.IOException;

public class Teste {

    public static void main(String[] args) throws IOException {
        IDaoFunctionImplAngletterre idao = new IDaoFunctionImplAngletterre();

        /*IDaoFunctionImplAngletterre.EMPLOYERS.forEach(e-> System.out.println(e.toString()));
        IDaoFunctionImplAngletterre.INFO_PAIES.forEach(e-> System.out.println(e.toString()));
        IDaoFunctionImplAngletterre.INFO_PROFFS.forEach(e-> System.out.println(e.toString()));*/
        idao.getSalairesByMounth("01/03/2021-31/03/2021").forEach(e-> System.out.println(e.toString()));

        //idao.listeSalairesByMounth("01/02/2021-28/02/2021").forEach(s-> System.out.println(s.toString()));
        //System.out.println(idao.maxSalaireEmployeByMounth("01/02/2021-28/02/2021").toString());
        //System.out.println(idao.minSalaireEmployeByMounth("01/02/2021-28/02/2021").toString());
        //idao.listeSalaires().forEach(salaire-> System.out.println(salaire.toString()));
        //System.out.println(idao.pourcentageHomme()+" %");
        //System.out.println(idao.pourcentageFeminin()+" %");
        //System.out.println(idao.moyenSalaireMounth("01/02/2021-28/02/2021"));
        //System.out.println(idao.pourcentageFeminin());
        //System.out.println(idao.pourcentageHomme());
        //System.out.println(idao.pourcentageOuvriers());
        //idao.getInfoProffs().forEach(p-> System.out.println(p.toString()));
    }
}
