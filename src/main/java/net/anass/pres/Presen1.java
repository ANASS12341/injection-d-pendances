package net.anass.pres;

import net.anass.dao.IDaoImpl;
import net.anass.metier.IMetierImpl;
import net.anass.ext.DaoImplV2;

public class Presen1 {
    public static void main(String[] args) {
        DaoImplV2 dao = new DaoImplV2();// Present1 ==>> IDAOImpl
//        IMetierImpl metier = new IMetierImpl();//Present1 ==>> IMetierImpl //injection via setters
//        metier.setDao(dao);//injection via le setter  IMetierImpl ==>>IDAOImpl //injection via setters
        // injection via constrructeur
        IMetierImpl metier = new IMetierImpl(dao);
        System.out.println("RES = "+metier.calcul());
    }
}
/*
 j'ai modifier le code source pour injecter l'extension
ce qui est mal exploiter donc la solution est de créer une
nouvelle classe presentation Pres2
pour qu'elle soit fermé à lamodification et ouverte à la
 */
