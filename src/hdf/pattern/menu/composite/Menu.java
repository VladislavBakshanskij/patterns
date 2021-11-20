package hdf.pattern.menu.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
    private final String name;
    private final String description;

    private List<MenuComponent> components = new ArrayList<>();
    private Iterator<MenuComponent> iterator = null;

    public Menu(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void add(final MenuComponent component) {
        components.add(component);
    }

    @Override
    public void remove(final MenuComponent component) {
        components.remove(component);
    }

    @Override
    public MenuComponent getChild(final int number) {
        if (components.size() <= number) {
            throw new IllegalArgumentException("Number of menu is greater than size of menu.");
        }
        return components.get(number);
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("------------------------------------------");

        final Iterator<MenuComponent> menuComponentIterator = components.iterator();
        while (menuComponentIterator.hasNext()) {
            final MenuComponent component = menuComponentIterator.next();
            component.print();
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(components.iterator());
        }
        return iterator;
    }
}
