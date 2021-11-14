package hdf.pattern.menu.iterator;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator<MenuItem> {
    private final MenuItem[] items;
    private int currentPosition = 0;

    public DinerMenuIterator(final MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return currentPosition <= items.length && items[currentPosition] != null;
    }

    @Override
    public MenuItem next() {
        final MenuItem current = items[currentPosition];
        currentPosition++;
        return current;
    }

    @Override
    public void remove() {
        if (currentPosition >= items.length) {
            throw new IllegalStateException(
                    String.format("current position is greater than or equal length of array: %d, %d",
                            currentPosition, items.length));
        }

        if (items[currentPosition] != null) {
            // or
//            System.arraycopy(items,
//                    currentPosition + 1,
//                    items,
//                    currentPosition,
//                    items.length - 1 - currentPosition);
            for (int position = currentPosition; position < items.length - 1; position++) {
                items[position] = items[position + 1];
            }
            items[items.length - 1] = null;
        }
    }
}
