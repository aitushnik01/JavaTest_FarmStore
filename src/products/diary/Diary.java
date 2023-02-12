package products.diary;

import products.Food;
public class Diary extends Food {
    private String type;

    public Diary(String brand, String size, double price, String type) {
        super(brand, size, price);
        setType(type);
    }
    public void setType(String type) { this.type = type;}
    public String getType() {return type;}
}
