package hdf.pattern.ducks.adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        final Duck duck = new MallardDuck();

        final WildTurkey turkey = new WildTurkey();
        final Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("The duck says...");
        duck.quack();
        duck.fly();

        System.out.println();
        System.out.println("The duck says...");
        testDuck(duck);

        System.out.println("The TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

    public static class IteratorAdapterMain {
        public static void main(String[] args) {
        }

        public static class EnumerationIterator<T> implements Iterator<T> {
            private Enumeration<T> enumeration;

            public EnumerationIterator(Enumeration<T> enumeration) {
                this.enumeration = enumeration;
            }

            @Override
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override
            public T next() {
                return enumeration.nextElement();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public static class IteratorEnumeration<T> implements Enumeration<T> {
            private Iterator<T> iterator;

            public IteratorEnumeration(Iterator<T> iterator) {
                this.iterator = iterator;
            }

            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public T nextElement() {
                return iterator.next();
            }
        }
    }
}
