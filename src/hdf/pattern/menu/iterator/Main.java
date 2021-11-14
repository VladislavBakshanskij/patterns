package hdf.pattern.menu.iterator;

public class Main {
    public static void main(String[] args) {
        final PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        final DinerMenu dinerMenu = new DinerMenu();
        final CafeMenu cafeMenu = new CafeMenu();

        final Alies alies = new Alies(pancakeHouseMenu, dinerMenu, cafeMenu);
        alies.printMenu();
    }
}
