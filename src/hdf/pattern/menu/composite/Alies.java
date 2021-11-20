package hdf.pattern.menu.composite;

import java.util.Iterator;

public class Alies {
    private final MenuComponent allMenus;

    public Alies(final MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarianMenu() {
        System.out.println("\nVEGETARIAN MENU\n");
        final Iterator<MenuComponent> menuComponentIterator = allMenus.createIterator();
        while (menuComponentIterator.hasNext()) {
            try {
                final MenuComponent menuComponent = menuComponentIterator.next();
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException ignored) {
            }
        }
    }
}
