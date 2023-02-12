package products;

public abstract class Food implements FoodSpecification {
    private static int idCounter = 0;
    private String brand;
    private String size;
    private double price;
    private int id;

    public Food(String brand, String size, double price) {
        setBrand(brand);
        setSize(size);
        setPrice(price);
        setId(++idCounter);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String model) {
        this.size = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
    protected void setId(int id) {
        this.id = id;
    }
}

