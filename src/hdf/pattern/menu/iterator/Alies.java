package hdf.pattern.menu.iterator;

import java.util.Iterator;

public class Alies {
    private final Menu pancakeHouseMenu;
    private final Menu dinerMenu;
    private final Menu cafeMenu;

    public Alies(final Menu pancakeHouseMenu, final Menu dinerMenu, final Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu() {
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeHouseMenu.createIterator());
        System.out.println("\nLUNCH");
        printMenu(dinerMenu.createIterator());
        System.out.println("\nDINNER");
        printMenu(cafeMenu.createIterator());
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
