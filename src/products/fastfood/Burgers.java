package products.fastfood;
import products.Food;

public class Burgers extends Food {
    private boolean onion;
    private String meat;

    public Burgers(String brand, String size, double price, boolean onion, String meat) {
        super(brand, size, price);
        setOnion(onion);
        setMeat(meat);
    }
    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getMeat() {
        return meat;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public boolean isOnion() {
        return onion;
    }
}
