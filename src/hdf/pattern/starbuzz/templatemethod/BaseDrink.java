package hdf.pattern.starbuzz.templatemethod;

public abstract class BaseDrink {
    public final void doDrink() {
        prepare();
        brew();
        poulnCup();
        if (customerAddAddons()) {
            addAddons();
        }
    }

    void prepare() {
        System.out.println("Prepare water for " + getClass().getSimpleName());
    }

    protected abstract void brew();

    void poulnCup() {
        System.out.println("Pull in cup " + getClass().getSimpleName());
    }

    protected abstract void addAddons();

    // можно переопределить, чтобы изменить работу шаблонного метода
    boolean customerAddAddons() {
        return true;
    }
}
