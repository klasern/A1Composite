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
public class Composite extends Component implements Iterable {

    private List<Component> children;

    public Composite(String inName, double inWeight) {
        super(inName, inWeight);
        children = new ArrayList<Component>();
    }

    @Override
    public void add(Component componentIn) {
        children.add(componentIn);
    }

    @Override
    public void remove(Component componentIn) {
        children.remove(componentIn);
    }

    @Override
    public String toString() {
        String ret = "en " + this.name + " som innehåller ";
        for (Component component : children) {
            ret = ret + component.toString();
        }
        return ret;
    }

    @Override
    public double getWeight() {
        double ret = this.weight;
        for (Component component : children) {
            ret = ret + component.getWeight();
        }
        return ret;
    }

    @Override
    public Iterator<Component> iterator() {
        return new DepthFirstIterator();
    }

    class DepthFirstIterator implements Iterator<Component> {

        int current = 0;
        List<Component> allComponents;

        private DepthFirstIterator() {
            allComponents = new ArrayList<>();
            for (Component currentComponent : children) {
                allComponents.add(currentComponent);

                if (currentComponent instanceof Composite) {
                    Iterator<Component> compositeIterator
                            = ((Composite) currentComponent).iterator();
                    while (compositeIterator.hasNext()) {
                        allComponents.add(compositeIterator.next());
                    }
                }

            }
        }

        @Override
        public boolean hasNext() {
            if (current >= allComponents.size()) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Component next() {
            return allComponents.get(current++);
        }

        @Override
        public void remove() {
            children.remove(--current);
        }

    }

    public Iterator<Component> breadthIterator() {
        return new BreadthFirstIterator();
    }

    class BreadthFirstIterator implements Iterator<Component> {

        int current = 0;
        List<Component> allComponents;

        private BreadthFirstIterator() {
            allComponents = new ArrayList<>();
            for (Component currentComponent : children) {
                allComponents.add(currentComponent);
            }
        }

        @Override
        public boolean hasNext() {
            if (current >= allComponents.size()) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Component next() {
            Component currentComponent = allComponents.get(current++);
            if(currentComponent instanceof Composite){
                Iterator<Component> currentIterator = 
                        ((Composite) currentComponent).breadthIterator();
                while(currentIterator.hasNext()){
                    allComponents.add(currentIterator.next());
                }
            }            
            return currentComponent;
        }

        @Override
        public void remove() {
            children.remove(--current);
        }

    }

}
