package products.fastfood;

public class CheeseBurgers extends Burgers{
    private boolean cheese;
    public CheeseBurgers(String brand, String size, double price, boolean onion, String meat, boolean cheese) {
        super(brand, size, price, onion, meat);
        setCheese(cheese);
    }
    public void setCheese(boolean cheese) {this.cheese = cheese;}
    public boolean isCheese() {return cheese;}

}
