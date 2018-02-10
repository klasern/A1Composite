/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A1CompositeV3;


/**
 *
 * @author Klas
 */
public class Leaf extends Component {
    
    public Leaf(String inName, double inWeight){
        super(inName, inWeight);
    }
    
    public String toString(){
        String ret = this.name + ", ";
        return ret;
    }
    
    @Override
    public void add(Component componentIn) {
        System.out.println("Kan inte lägga in saker i detta objekt");
    }

    @Override
    public void remove(Component componentIn) {
        System.out.println("Kan inte lägga ta bort saker från detta objekt");
    }
    
    @Override
    public double getWeight(){
        return this.weight;
    }
}
