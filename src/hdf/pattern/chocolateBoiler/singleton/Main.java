package hdf.pattern.chocolateBoiler.singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println(SimpleBoiler.class.getSimpleName());

        final SimpleBoiler simpleBoiler = new SimpleBoiler();
        simpleBoiler.fill();
        simpleBoiler.boil();
        simpleBoiler.drain();

        System.out.println("================================");
        System.out.println();

        System.out.println(SimpleSingletonBoiler.class.getSimpleName());

        final SimpleSingletonBoiler simpleSingletonBoiler = SimpleSingletonBoiler.getInstance();
        simpleSingletonBoiler.fill();
        simpleSingletonBoiler.boil();
        simpleSingletonBoiler.drain();

        System.out.println("================================");
        System.out.println();

        System.out.println(ThreadSafeSingletonBoiler.class.getSimpleName());

        final ThreadSafeSingletonBoiler threadSafeSingletonBoiler = ThreadSafeSingletonBoiler.getInstance();
        threadSafeSingletonBoiler.fill();
        threadSafeSingletonBoiler.boil();
        threadSafeSingletonBoiler.drain();

        System.out.println("================================");
        System.out.println();

        System.out.println(ThreadSafeNotLazySingletonBoiler.class.getSimpleName());

        final ThreadSafeNotLazySingletonBoiler threadSafeNotLazySingletonBoiler = ThreadSafeNotLazySingletonBoiler.getInstance();
        threadSafeNotLazySingletonBoiler.fill();
        threadSafeNotLazySingletonBoiler.boil();
        threadSafeNotLazySingletonBoiler.drain();

        System.out.println("================================");
        System.out.println();

        System.out.println(ThreadSafeLazyInstanceSingletonBoiler.class.getSimpleName());

        final ThreadSafeLazyInstanceSingletonBoiler threadSafeLazyInstanceSingletonBoiler = ThreadSafeLazyInstanceSingletonBoiler.getInstance();
        threadSafeLazyInstanceSingletonBoiler.fill();
        threadSafeLazyInstanceSingletonBoiler.boil();
        threadSafeLazyInstanceSingletonBoiler.drain();

        System.out.println("================================");
        System.out.println();
    }

    public static class SimpleBoiler {
        private boolean empty;
        private boolean boiled;

        public SimpleBoiler() {
            empty = true;
            boiled = false;
        }

        public void fill() {
            if (isEmpty()) {
                empty = false;
                boiled = false;
                // заполняем бойлер
                System.out.println("Boiler is filled");
            }
        }

        public void drain() {
            if (!isEmpty() && isBoiled()) {
                empty = true;
                // сливаем нагретое молоко и шоколад с бойлера
                System.out.println("Boiler is drained");
            }
        }

        public void boil() {
            if (!isEmpty() && !isBoiled()) {
                boiled = true;
                // кипятим бойлер
                System.out.println("Boiler is boiled");
            }
        }

        public boolean isEmpty() {
            return empty;
        }

        public boolean isBoiled() {
            return boiled;
        }
    }

    /**
     * Данный вариант паттерна Одиночки является наиболее распространненым и простым.
     * Но он очень не потокобезопастен. Так как два потока, которые одновременно вызовут метод getInstance
     * получат совершенно разные ссылки на объект.
     */
    public static class SimpleSingletonBoiler {
        private static SimpleSingletonBoiler instance;

        private boolean empty;
        private boolean boiled;

        private SimpleSingletonBoiler() {
            empty = true;
            boiled = false;
        }

        public static SimpleSingletonBoiler getInstance() {
            if (instance == null) {
                instance = new SimpleSingletonBoiler();
            }
            return instance;
        }

        public void fill() {
            if (isEmpty()) {
                empty = false;
                boiled = false;
                // заполняем бойлер
                System.out.println("Boiler is filled");
            }
        }

        public void drain() {
            if (!isEmpty() && isBoiled()) {
                empty = true;
                // сливаем нагретое молоко и шоколад с бойлера
                System.out.println("Boiler is drained");
            }
        }

        public void boil() {
            if (!isEmpty() && !isBoiled()) {
                boiled = true;
                // кипятим бойлер
                System.out.println("Boiler is boiled");
            }
        }

        public boolean isEmpty() {
            return empty;
        }

        public boolean isBoiled() {
            return boiled;
        }
    }

    /**
     * Данный вариант реализации является наиболее потокобезопастным, так как каждый поток, который вызовет
     * метод getInstance будет ждать своей очереди. Но это сильно угрожает производительности, так как метод синхронизирован.
     */
    public static class ThreadSafeSingletonBoiler {
        private static ThreadSafeSingletonBoiler instance;

        private boolean empty;
        private boolean boiled;

        private ThreadSafeSingletonBoiler() {
            empty = true;
            boiled = false;
        }

        public static synchronized ThreadSafeSingletonBoiler getInstance() {
            if (instance == null) {
                instance = new ThreadSafeSingletonBoiler();
            }
            return instance;
        }

        public void fill() {
            if (isEmpty()) {
                empty = false;
                boiled = false;
                // заполняем бойлер
                System.out.println("Boiler is filled");
            }
        }

        public void drain() {
            if (!isEmpty() && isBoiled()) {
                empty = true;
                // сливаем нагретое молоко и шоколад с бойлера
                System.out.println("Boiler is drained");
            }
        }

        public void boil() {
            if (!isEmpty() && !isBoiled()) {
                boiled = true;
                // кипятим бойлер
                System.out.println("Boiler is boiled");
            }
        }

        public boolean isEmpty() {
            return empty;
        }

        public boolean isBoiled() {
            return boiled;
        }
    }

    /**
     * Наиболее простой и потокобезопастный способ создания единственного экземпляра класса.
     */
    public static class ThreadSafeNotLazySingletonBoiler {
        private static final ThreadSafeNotLazySingletonBoiler INSTANCE = new ThreadSafeNotLazySingletonBoiler();

        private boolean empty;
        private boolean boiled;

        private ThreadSafeNotLazySingletonBoiler() {
            empty = true;
            boiled = false;
        }

        public static ThreadSafeNotLazySingletonBoiler getInstance() {
            return INSTANCE;
        }

        public void fill() {
            if (isEmpty()) {
                empty = false;
                boiled = false;
                // заполняем бойлер
                System.out.println("Boiler is filled");
            }
        }

        public void drain() {
            if (!isEmpty() && isBoiled()) {
                empty = true;
                // сливаем нагретое молоко и шоколад с бойлера
                System.out.println("Boiler is drained");
            }
        }

        public void boil() {
            if (!isEmpty() && !isBoiled()) {
                boiled = true;
                // кипятим бойлер
                System.out.println("Boiler is boiled");
            }
        }

        public boolean isEmpty() {
            return empty;
        }

        public boolean isBoiled() {
            return boiled;
        }
    }

    /**
     * Вариант отложенной инициализации, при этом потокобезопастной.
     */
    public static class ThreadSafeLazyInstanceSingletonBoiler {
        private static volatile ThreadSafeLazyInstanceSingletonBoiler instance;

        private boolean empty;
        private boolean boiled;

        private ThreadSafeLazyInstanceSingletonBoiler() {
            empty = true;
            boiled = false;
        }

        public static ThreadSafeLazyInstanceSingletonBoiler getInstance() {
            if (instance == null) {
                synchronized (ThreadSafeLazyInstanceSingletonBoiler.class) {
                    if (instance == null) {
                        instance = new ThreadSafeLazyInstanceSingletonBoiler();
                    }
                }
            }

            return instance;
        }


        public void fill() {
            if (isEmpty()) {
                empty = false;
                boiled = false;
                // заполняем бойлер
                System.out.println("Boiler is filled");
            }
        }

        public void drain() {
            if (!isEmpty() && isBoiled()) {
                empty = true;
                // сливаем нагретое молоко и шоколад с бойлера
                System.out.println("Boiler is drained");
            }
        }

        public void boil() {
            if (!isEmpty() && !isBoiled()) {
                boiled = true;
                // кипятим бойлер
                System.out.println("Boiler is boiled");
            }
        }

        public boolean isEmpty() {
            return empty;
        }

        public boolean isBoiled() {
            return boiled;
        }
    }
}
