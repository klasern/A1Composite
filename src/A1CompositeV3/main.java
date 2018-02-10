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
public class main {

    public static void main(String[] args) {
        Composite mySuitCase = new Composite("resväska", 5);
        Leaf myPants1 = new Leaf("blåa byxor", 0.6);
        Leaf myPants2 = new Leaf("röda byxor", 0.7);
        Leaf myPants3 = new Leaf("gröna byxor", 0.8);
        Leaf myJumper1 = new Leaf("röd tjocktröja", 0.9);

        Composite myToiletBag = new Composite("necessär", 0.2);
        Leaf mySoap = new Leaf("tvål", 0.2);
        Leaf myShampoo = new Leaf("schampoo", 0.2);

        Composite myBag1 = new Composite("påse", 0.1);
        Leaf myToothBrush = new Leaf("tandborste", 0.02);
        Leaf myToothPaste = new Leaf("tandkräm", 0.05);

        Composite myBag2 = new Composite("påse", 0.1);
        Leaf myBarette1 = new Leaf("rött hårspänne", 0.005);
        Leaf myBarette2 = new Leaf("blått hårspänne", 0.005);

        mySuitCase.add(myPants1);
        mySuitCase.add(myPants2);
        mySuitCase.add(myPants3);
        mySuitCase.add(myJumper1);
        mySuitCase.add(myToiletBag);

        myToiletBag.add(mySoap);
        myToiletBag.add(myShampoo);
        myToiletBag.add(myBag1);
        myToiletBag.add(myBag2);

        myBag1.add(myToothBrush);
        myBag1.add(myToothPaste);
        
        myBag2.add(myBarette1);
        myBag2.add(myBarette2);
        
        System.out.println(mySuitCase);
        //System.out.println(myToiletBag.toString());
      
        Iterator<Component> depthFirst = mySuitCase.iterator();
        while (depthFirst.hasNext()){
            Component component = depthFirst.next();
            System.out.println(component.name);
        }
        
        /*
         System.out.println(mySuitCase.getClass());
         System.out.println((mySuitCase.getClass() == Composite.class));
         System.out.println(myJumper1.getClass());
         */
        System.out.println();
        Iterator<Component> breadthFirst = mySuitCase.breadthIterator();
        while (breadthFirst.hasNext()) {
            Component component = breadthFirst.next();
            System.out.println(component.name);
        }
         
    }
}
