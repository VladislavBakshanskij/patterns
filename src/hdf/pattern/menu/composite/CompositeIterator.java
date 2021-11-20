package hdf.pattern.menu.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {
    private Stack<Iterator<MenuComponent>> iterators = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        this.iterators.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (iterators.isEmpty()) {
            return false;
        }

        final Iterator<MenuComponent> iterator = iterators.peek();
        if (iterator.hasNext()) {
            return true;
        }
        iterators.pop();
        return hasNext();
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            final Iterator<MenuComponent> iterator = iterators.peek();
            final MenuComponent component = iterator.next();
            iterators.push(component.createIterator());
            return component;
        }
        return null;
    }
}
