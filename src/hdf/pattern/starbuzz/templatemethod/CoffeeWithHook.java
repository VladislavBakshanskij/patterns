package hdf.pattern.starbuzz.templatemethod;

import java.util.Scanner;

public class CoffeeWithHook extends BaseDrink {
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

    @Override
    boolean customerAddAddons() {
        return getUserInput().equalsIgnoreCase("y");
    }

    private String getUserInput() {
        System.out.println("Would you like milk and sugar with your coffee (y/n)?");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
//        Можно использовать BufferedReader, который предназначен для работы со строками
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//            answer = bufferedReader.readLine();
//        }
    }
}
