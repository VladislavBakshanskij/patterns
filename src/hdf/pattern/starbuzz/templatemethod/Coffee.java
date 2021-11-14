package hdf.pattern.starbuzz.templatemethod;

public class Coffee extends BaseDrink {
    private final String[] addons = {
            "Sugar", "Milk"
    };

    @Override
    protected void brew() {
        System.out.println("Brew the " + getClass().getSimpleName());
    }

    @Override
    protected void addAddons() {
        final String drinkName = getClass().getSimpleName();
        System.out.println("Start add addons for " + drinkName);
        for (String addon : addons) {
            System.out.println(" -> add " + addon);
        }
        System.out.println("End add addons for " + drinkName);
    }
}
