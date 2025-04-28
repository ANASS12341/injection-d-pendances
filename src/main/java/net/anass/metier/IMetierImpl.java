package net.anass.metier;

import net.anass.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IMetierImpl implements IMetier {
    @Autowired
    private IDao dao;//Couplage faible
    //constructeur avec parametre pour  injecter dans l'attribut dao
    // on préfére faire l'injection via le constructeur
    public IMetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t =dao.getData();
        double res = t * 12 *Math.PI/2*Math.cos(t);
        return res;
    }
    /*pour injecter dans la variable dao
    un objet d'une classe QUI IMPLIMENTE L4INTERFACE IDAO
    apre l'instanciation
     */
    // consructeur sans parametre

    public IMetierImpl() {
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
