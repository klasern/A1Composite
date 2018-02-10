/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A1CompositeV3;

import java.util.*;

/**
 *
 * @author Klas
 */
public abstract class Component {
    String name;
    double weight;

    public Component(String nameIn, double weightIn) {
        name = nameIn;
        weight = weightIn;
    }

    public abstract void add(Component C);

    public abstract void remove(Component C);

    @Override
    public abstract String toString();

    public abstract double getWeight();
 
    
}
