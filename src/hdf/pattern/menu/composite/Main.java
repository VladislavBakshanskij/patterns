package hdf.pattern.menu.composite;

public class Main {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinnerMenu = new Menu("DINNER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menu combined!");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinnerMenu);
        allMenus.add(cafeMenu);

        // <editor-fold defaultstate="collapsed" desc="Dinner menu">
        dinnerMenu.add(
                new MenuItem(
                        "Vegetarian BLT",
                        " (Fakin’)Bacon with lettuce & tomato on whole wheat",
                        true, 2.99
                )
        );
        dinnerMenu.add(
                new MenuItem(
                        "BLT", "Bacon with lettuce & tomato on whole wheat",
                        false, 2.99
                )
        );
        dinnerMenu.add(
                new MenuItem(
                        "Soup of the day", "Soup of the day, with a side of potato salad",
                        false, 3.29
                )
        );
        dinnerMenu.add(
                new MenuItem(
                        "Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese",
                        false, 3.05
                )
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cafe menu">
        cafeMenu.add(
                new MenuItem(
                        "Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                        true, 3.99
                )
        );
        cafeMenu.add(
                new MenuItem(
                        "Soup of the day", "A cup of the soup of the day, with a side salad",
                        false, 3.69
                )
        );
        cafeMenu.add(
                new MenuItem(
                        "Burrito", "A large burrito, with whole pinto beans, salsa, guacamole",
                        true, 4.29
                )
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pancake menu">
        pancakeHouseMenu.add(
                new MenuItem(
                        "K&B’s Pancake Breakfast",
                        "Pancakes with scrambled eggs, and toast",
                        true, 2.99
                )
        );
        pancakeHouseMenu.add(
                new MenuItem(
                        "Regular Pancake Breakfast",
                        "Pancakes with fried eggs, sausage",
                        false, 2.99
                )
        );
        pancakeHouseMenu.add(
                new MenuItem(
                        "Blueberry Pancakes",
                        "Pancakes made with fresh blueberries",
                        true, 3.49
                )
        );
        pancakeHouseMenu.add(
                new MenuItem(
                        "Waffles",
                        "Waffles, with your choice of blueberries or strawberries",
                        true, 3.59
                )
        );
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dessert menu">
        dessertMenu.add(
                new MenuItem(
                        "Apple cake",
                        "Cake with apple",
                        true, 5.5
                )
        );
        dessertMenu.add(
                new MenuItem(
                        "Croissant with meat",
                        "Simple croissant with meat",
                        false, 11.5
                )
        );
        dinnerMenu.add(dessertMenu);
        // </editor-fold>

        final Alies alies = new Alies(allMenus);
        alies.printMenu();
        System.out.println("\n\n-------------------------------------------------------\n\n");
        alies.printVegetarianMenu();
    }
}
