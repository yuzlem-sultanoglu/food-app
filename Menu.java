package food.app;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Food> foods = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Desert> deserts = new ArrayList<>();
    private List<Categories> allItems = new ArrayList<>();
    public void addFood(Food food) {
        foods.add(food);
        allItems.add(food);

    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
        allItems.add(drink);

    }

    public void addDesert(Desert desert) {
        deserts.add(desert);
        allItems.add(desert);

    }

    public void printMenu() {
    	for (int i = 0; i < allItems.size(); i++) {
            Categories item = allItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
        }
        
        
    }

    public Categories findItemByName(String name) {
        for (Food f : foods)
            if (f.getName().equalsIgnoreCase(name)) return f;
        for (Drink d : drinks)
            if (d.getName().equalsIgnoreCase(name)) return d;
        for (Desert ds : deserts)
            if (ds.getName().equalsIgnoreCase(name)) return ds;
        return null;
    }

	public Categories getItemByNumber(int productNumber) {
		int index = productNumber - 1;
		 if (index >= 0 && index < allItems.size()) {
		        return allItems.get(index);
		    }
		return null;
	}
}
