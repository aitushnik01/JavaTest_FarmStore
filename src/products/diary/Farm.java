package products.diary;

    public class Farm extends Diary{
    private String city;
    private boolean halal;
    private boolean kz;

    public Farm(String brand, String size, double price, String type, String city, boolean halal, boolean kz) {
        super(brand, size, price, type);
        setCity(city);
        setHalal(halal);
        setKz(kz);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    public void setKz(boolean kz) {
        this.kz = kz;
    }

    public boolean isHalal() {
        return halal;
    }

    public boolean isKz() {
        return kz;
    }
}
