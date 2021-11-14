package hdf.pattern.starbuzz.templatemethod;

public class Tea extends BaseDrink {
    private final String[] addons = {
            "Lemon"
    };

    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
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
