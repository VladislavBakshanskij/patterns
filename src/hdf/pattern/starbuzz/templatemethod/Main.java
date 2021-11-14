package hdf.pattern.starbuzz.templatemethod;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BaseDrink drink = new Coffee();
        drink.doDrink();

        printDelimiter();

        drink = new Tea();
        drink.doDrink();

        printDelimiter();

        drink = new CoffeeWithHook();
        drink.doDrink();
    }

    private static void printDelimiter() {
        System.out.println("\n<-------------------------------------------------------->\n");
    }

    public static class SortDuck {
        public static void main(String[] args) {
            class Duck implements Comparable<Duck> {
                private final int weight;
                private final String name;

                public Duck(int weight, String name) {
                    this.weight = weight;
                    this.name = name;
                }

                public int getWeight() {
                    return weight;
                }

                public String getName() {
                    return name;
                }

                @Override
                public int compareTo(Duck o) {
                    if (this.weight > o.getWeight()) {
                        return 1;
                    } else if (o.getWeight() > this.weight) {
                        return -1;
                    } else {
                        return 0;
                    }

                    // return o.getWeight() - this.weight // можно еще использовать и такой вариант
                    // либо использовать Integer.compareTo(o.getWeight(), this.weight);
                }

                @Override
                public String toString() {
                    return "Duck{" +
                            "weight=" + weight +
                            ", name='" + name + '\'' +
                            '}';
                }
            }

            List<Duck> ducks = new ArrayList<>();
            ducks.add(new Duck(9, "Super duck 1"));
            ducks.add(new Duck(10, "Super duck 2"));
            ducks.add(new Duck(2, "Super duck 3"));
            ducks.add(new Duck(3, "Super duck 4"));

            final Duck[] duckArray = ducks.toArray(new Duck[0]);
            Arrays.sort(duckArray);// метод sort в классе Arrays является шаблонным,
                                   // так как он реализовал часть алгорима сортировки,
                                   // он только нуждается в методе compareTo интерфейса Comparable
                                   // за счет реализации интфейса Comparable можно сказать каким образом сортировать объекты

            List.of(duckArray).forEach(System.out::println);
        }
    }

    public static class DrawMessage {
        public static void main(String[] args) {
            new CustomJFrame("Super frame");
        }

        public static class CustomJFrame extends JFrame {
            public CustomJFrame(String title) {
                super(title);
                super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                super.setSize(100, 100);
                super.setVisible(true);
            }

            // по умолчанию метод paint является перехватчиком, так как ничего не делает,
            // но при его реализации можно влиять на алгоритм работы JFrame(нарисовать, либо перерисовать что-то)
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawString("Message", 50, 50);
            }
        }
    }

    public static class WithApplets {
        public static class CustomApplet extends Applet {
            @Override
            public void init() {
                String message = "this is init method from applet";
                System.out.println(message);
                repaint();
            }

            @Override
            public void start() {
                String message = "method start is invoke";
                System.out.println(message);
            }
        }
    }
}
