package products.diary;

public class Vegetables extends Diary {
    private String freshness;
    private boolean GMO;

    public Vegetables(String brand, String size, double price, String type, String freshness, boolean GMO) {
        super(brand, size, price, type);
        setFreshness(freshness);
        setGMO(GMO);
    }
    public void setFreshness(String freshness) {
        this.freshness = freshness;
    }

    public String getFreshness() {
        return freshness;
    }

    public void setGMO(boolean GMO) {
        this.GMO = GMO;
    }

    public boolean isGMO() {
        return GMO;
    }
}
