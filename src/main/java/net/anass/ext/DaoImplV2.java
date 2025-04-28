package net.anass.ext;

import net.anass.dao.IDao;

public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version capteur DaoImplV2 getData");
        double t = 12;
        return t;
    }



}
