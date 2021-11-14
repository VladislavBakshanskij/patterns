package hdf.pattern.menu.iterator;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseIterator implements Iterator<MenuItem> {
    private final List<MenuItem> items;
    private int currentPosition = 0;

    public PancakeHouseIterator(final List<MenuItem> menuItems) {
        this.items = menuItems;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < items.size();
    }

    @Override
    public MenuItem next() {
        final MenuItem current = items.get(currentPosition);
        currentPosition++;
        return current;
    }
}
