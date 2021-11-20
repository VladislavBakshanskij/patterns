package hdf.pattern.menu.composite;

import java.util.Iterator;

public class MenuItem extends MenuComponent {
    private final String name;
    private final double price;
    private final String description;
    private final boolean vegetarian;

    public MenuItem(final String name, final String description,
                    final boolean vegetarian, final double price) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.vegetarian = vegetarian;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.print(", " + getPrice());
        System.out.println(" -- " + getPrice());
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }
}
