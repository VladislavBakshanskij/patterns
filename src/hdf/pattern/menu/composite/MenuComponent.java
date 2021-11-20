package hdf.pattern.menu.composite;

import java.util.Iterator;

public abstract class MenuComponent {
    public void add(MenuComponent component) {
        throw new UnsupportedOperationException("Method add not supported");
    }

    public void remove(MenuComponent component) {
        throw new UnsupportedOperationException("Method remove not supported");
    }

    public MenuComponent getChild(int number) {
        throw new UnsupportedOperationException("Method getChild not supported");
    }

    public String getName() {
        throw new UnsupportedOperationException("Method getName not supported");
    }

    public String getDescription() {
        throw new UnsupportedOperationException("Method getDescription not supported");
    }

    public double getPrice() {
        throw new UnsupportedOperationException("Method getPrice not supported");
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException("Method isVegetarian not supported");
    }

    public void print() {
        throw new UnsupportedOperationException("Method print not supported");
    }

    public abstract Iterator<MenuComponent> createIterator();
}
