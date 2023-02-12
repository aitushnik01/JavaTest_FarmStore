package products.fastfood;

public class TandyrDoners extends Doners{
    private boolean tandyr;
    public TandyrDoners(String brand, String size, double price, boolean onion, String meat, boolean tandyr) {
        super(brand, size, price, onion, meat);
        setTandyr(tandyr);
    }
    public void setTandyr(boolean tandyr) {this.tandyr = tandyr;}
    public boolean isTandyr() {return tandyr;}

}
