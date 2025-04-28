package net.anass.pres;

import net.anass.dao.IDao;
import net.anass.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Scanner;

public class Presen2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("config.txt"));//Lecture du fichier config.txt
//ce bloc sert à crée un objet Dao
        String daoClassName = sc.nextLine();// Lecture du nom de la classe c-à-d le nom
        //la classe dans la premier ligne du fichier config.txt
        Class cDao = Class.forName(daoClassName);//si la classe existe il va la charger en memoire
        //sinon il va generer une exception(classe not found exception)
        IDao dao = (IDao) cDao.newInstance();//c_à_d qu'on utilise le constructeur sans parametre
        // *******cDao.getConstructor(IDao.class).newInstance() pour utiliser un constructeur avec paramètre
        // j'ai crée un objet idao(Interfce) car je connais pas quel classe
        System.out.println(dao.getData());
        //la classe afficher depend de la premiere  classe
        // cité dans la premiere ligne du fichier config.txt
// celui-ci sert à crée un objet metier
        String metierClassName = sc.nextLine();
        Class cMetier =Class.forName(metierClassName);

        IMetier metier = (IMetier) cDao.getConstructor(IDao.class).newInstance(dao);
        System.out.println(metier.calcul());

    }
}
