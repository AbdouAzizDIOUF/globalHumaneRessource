package france;

import france.dao.IDaoFunctionImplFrance;

import java.io.IOException;

public class Teste {
    public static void main (String[] args) throws IOException {
        IDaoFunctionImplFrance ido = new IDaoFunctionImplFrance();

        //ido.getSalairesByMounth("01/02/2021-28/02/2021").forEach(e-> System.out.println(e.toString()));

    }
}
