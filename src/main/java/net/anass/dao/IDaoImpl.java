package net.anass.dao;

import org.springframework.stereotype.Component;

@Component
public class IDaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version base de données");
        double t = 34;
        return t;
    }
}
