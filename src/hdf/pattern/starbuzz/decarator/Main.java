package hdf.pattern.starbuzz.decarator;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoad();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }

    public static class CLASS {
        public static void main(String[] args) {
            try (final InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("test.txt")))) {

                int c;
                while ((c = in.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static class LowerCaseInputStream extends FilterInputStream {
            protected LowerCaseInputStream(InputStream in) {
                super(in);
            }

            @Override
            public int read() throws IOException {
                final int c = in.read();
                return c == -1 ? c : Character.toLowerCase((char) c);
            }

            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                final int result = in.read(b, off, len);
                for (int i = off; i < off + result; i++) {
                    b[i] = (byte) Character.toLowerCase((char) b[i]);
                }
                return result;
            }
        }
    }
}
