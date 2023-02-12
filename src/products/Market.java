package products;
import java.util.Scanner;
import java.sql.*;
import products.diary.*;
import products.fastfood.*;

public class Market {
    public void initCheeseBurgers(String login) {
        Scanner scanner = new Scanner(System.in);
        Market market = new Market();
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter size: ");
        String size = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter Onion (true/false): ");
        boolean onion = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter meat: ");
        String meat = scanner.nextLine();
        System.out.println("Enter Cheese (true/false): ");
        boolean cheese = Boolean.parseBoolean(scanner.nextLine());
        CheeseBurgers cheeseburgers = new CheeseBurgers(brand, size, price, onion, meat, cheese);
        market.createCheeseBurgers(login, cheeseburgers);
    }

    public void initVegetables(String login) {
        Market market = new Market();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter size: ");
        String size = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter type: ");
        String type = scanner.nextLine();
        System.out.println("Enter freshness");
        String freshness = scanner.nextLine();
        System.out.println("Enter GMO (true/false): ");
        boolean GMO = Boolean.parseBoolean(scanner.nextLine());
        Vegetables vegetables = new Vegetables(brand, size, price, type, freshness, GMO);
        market.createVegetables(login, vegetables);
    }

    public void initFarm(String login) {
        Market market = new Market();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter size: ");
        String size = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter type: ");
        String type = scanner.nextLine();
        System.out.println("Enter city exporter: ");
        String city = scanner.nextLine();
        System.out.println("Enter is it Halal (true/false): ");
        boolean halal = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter is it produced in KZ (true/false): ");
        boolean kz = Boolean.parseBoolean(scanner.nextLine());
        Farm farm = new Farm(brand, size, price, type, city, halal, kz);
        market.createFarm(login, farm);
    }

    public void initTandyrDoners(String login) {
        Scanner scanner = new Scanner(System.in);
        Market market = new Market();
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter size: ");
        String size = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter Onion (true/false): ");
        boolean onion = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter meat: ");
        String meat = scanner.nextLine();
        System.out.println("Enter cook in tandyr? (true/false): ");
        boolean tandyr = Boolean.parseBoolean(scanner.nextLine());
        TandyrDoners tandyrdoners = new TandyrDoners(brand, size, price, onion, meat, tandyr);
        market.createTandyrDoners(login, tandyrdoners);
    }

    public void showSellers() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sellers");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("login"));
                System.out.println("****************");
                System.out.println();
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public void createSeller(String name, String password) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO sellers(login, password) VALUES ('" + name + "', '" + password + "')");
            System.out.println("Творец создан!");
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public boolean checkPassword(String login, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            PreparedStatement st = con.prepareStatement("SELECT * FROM sellers WHERE login=?");
            st.setString(1, login);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    con.close();
                    return true;
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
        return false;
    }
    public void readFood(String tableName) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName + ";");
            while (rs.next()) {
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Название: "+rs.getString("brand"));
                System.out.println("*********************");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public double returnPrice(String tableName, int ID) {
        int price = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT price FROM " + tableName + " WHERE id = "+ID);
            while (rs.next()) {
                price = rs.getInt("price");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
        return price;
    }
    public String returnSize(String tableName, int ID) {
        String size = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT size FROM" + tableName + " WHERE id = "+ID);
            while (rs.next()) {
                size = rs.getString("size");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
        return size;
    }
    public void readFoodByID(String tableName, int ID) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName + " WHERE id = " +ID);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (metaData.getColumnType(i) == Types.BOOLEAN) {
                        boolean columnValue = rs.getBoolean(i);
                        System.out.println(columnValue ? "true" : "false");
                    } else {
                        System.out.println(metaData.getColumnName(i) + ": " +rs.getObject(i));
                    }
                }
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public void readFoodByLogin(String tableName, String login) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName + " WHERE seller = '" + login + "'");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (metaData.getColumnType(i) == Types.BOOLEAN) {
                        boolean columnValue = rs.getBoolean(i);
                        System.out.println(columnValue ? "true" : "false");
                    } else {
                        System.out.println(metaData.getColumnName(i) + ": " +rs.getObject(i));
                    }
                }
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public void deleteFood(String category, int id) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            PreparedStatement st = con.prepareStatement("DELETE FROM "+category+" WHERE id = ?");
            st.setInt(1, id);
            int result = st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }

    public void createCheeseBurgers(String login, CheeseBurgers cheeseburgers){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            String sql = "INSERT INTO CheeseBurgers (brand, size, price, onion, meat, cheese, seller) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cheeseburgers.getBrand());
            st.setString(2, cheeseburgers.getSize());
            st.setDouble(3, cheeseburgers.getPrice());
            st.setBoolean(4, cheeseburgers.isOnion());
            st.setString(5, cheeseburgers.getMeat());
            st.setBoolean(6, cheeseburgers.isCheese());
            st.setString(7, login);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public void createTandyrDoners(String login, TandyrDoners tandyrdoners){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            String sql = "INSERT INTO TandyrDoners (brand, size, price, onion, meat, tandyr, seller) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tandyrdoners.getBrand());
            st.setString(2, tandyrdoners.getSize());
            st.setDouble(3, tandyrdoners.getPrice());
            st.setBoolean(4, tandyrdoners.isOnion());
            st.setString(5, tandyrdoners.getMeat());
            st.setBoolean(6, tandyrdoners.isTandyr());
            st.setString(7, login);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public void createFarm(String login, Farm farm){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            String sql = "INSERT INTO Farm (brand, size, price, type, city, halal, kz, seller) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, farm.getBrand());
            st.setString(2, farm.getSize());
            st.setDouble(3, farm.getPrice());
            st.setString(4, farm.getType());
            st.setString(5, farm.getCity());
            st.setBoolean(6, farm.isHalal());
            st.setBoolean(7, farm.isKz());
            st.setString(8, login);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public void createVegetables(String login, Vegetables vegetables){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            String sql = "INSERT INTO Vegetables (brand, size, price, type, freshness, GMO, seller) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, vegetables.getBrand());
            st.setString(2, vegetables.getSize());
            st.setDouble(3, vegetables.getPrice());
            st.setString(4, vegetables.getType());
            st.setString(5, vegetables.getFreshness());
            st.setBoolean(6, vegetables.isGMO());
            st.setString(7, login);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
    public void updateProduct(int id, String category) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gg", "postgres", "Qqwerty1!");
            PreparedStatement pstmt = null;
            switch (category) {
                case "Vegetables": {
                    System.out.println("Enter the new brand: ");
                    String newBrand = scanner.nextLine();
                    System.out.println("Enter the new size: ");
                    String newSize = scanner.nextLine();
                    System.out.println("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // consume the line separator
                    System.out.println("Enter the new type: ");
                    String type = scanner.nextLine();
                    System.out.println("Enter new freshness: ");
                    String newfreshness = scanner.nextLine();
                    System.out.println("Enter new GMO (true/false): ");
                    boolean newGMO = scanner.nextBoolean();
                    pstmt = con.prepareStatement("UPDATE Vegetables SET brand = ?, size = ?, price = ?, type = ?, freshness = ?, GMO = ? WHERE id = ?");
                    pstmt.setString(1, newBrand);
                    pstmt.setString(2, newSize);
                    pstmt.setDouble(3, newPrice);
                    pstmt.setString(4, type);
                    pstmt.setString(5, newfreshness);
                    pstmt.setBoolean(6, newGMO);
                    pstmt.setInt(7, id);
                    break;
                }
                case "products.diary.Farm": {
                    System.out.println("Enter the new brand: ");
                    String newBrand = scanner.nextLine();
                    System.out.println("Enter the new size: ");
                    String newSize = scanner.nextLine();
                    System.out.println("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // consume the line separator
                    System.out.println("Enter the new type: ");
                    String type = scanner.nextLine();
                    System.out.println("Enter the new city: ");
                    String newCity = scanner.nextLine();
                    System.out.println("Enter the new halal (true/false): ");
                    boolean newHalal = scanner.nextBoolean();
                    System.out.println("Enter the new kz (true/false): ");
                    boolean newKz = scanner.nextBoolean();
                    pstmt = con.prepareStatement("UPDATE Farm SET brand = ?, size = ?, price = ?, type = ?, city = ?, halal = ?, kz = ? WHERE id = ?");
                    pstmt.setString(1, newBrand);
                    pstmt.setString(2, newSize);
                    pstmt.setDouble(3, newPrice);
                    pstmt.setString(4, type);
                    pstmt.setString(5, newCity);
                    pstmt.setBoolean(6, newHalal);
                    pstmt.setBoolean(7, newKz);
                    pstmt.setInt(8, id);
                    break;
                }
                case "Cheeseburgers": {
                    System.out.println("Enter the new brand: ");
                    String newBrand = scanner.nextLine();
                    System.out.println("Enter the new size: ");
                    String newSize = scanner.nextLine();
                    System.out.println("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.println("Enter the new onion (true/false): ");
                    boolean newOnion = scanner.nextBoolean();
                    System.out.println("Enter the new meat: ");
                    String newMeat = scanner.nextLine();
                    System.out.println("Enter the new cheese (true/false): ");
                    boolean newCheese = scanner.nextBoolean();
                    pstmt = con.prepareStatement("UPDATE CheeseBurgers SET brand = ?, size = ?, price = ?, onion = ?, meat = ?, cheese = ? WHERE id = ?");
                    pstmt.setString(1, newBrand);
                    pstmt.setString(2, newSize);
                    pstmt.setDouble(3, newPrice);
                    pstmt.setBoolean(4, newOnion);
                    pstmt.setString(5, newMeat);
                    pstmt.setBoolean(6, newCheese);
                    pstmt.setInt(7, id);
                    break;
                }
                case "TandyrDoners": {
                    System.out.println("Enter the new brand: ");
                    String newBrand = scanner.nextLine();
                    System.out.println("Enter the new size: ");
                    String newSize = scanner.nextLine();
                    System.out.println("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter the new Onion (true/false): ");
                    boolean newOnion = scanner.nextBoolean();
                    System.out.println("Enter the new meat: ");
                    String newMeat = scanner.nextLine();
                    System.out.println("Enter the new Tandyr (true/false): ");
                    boolean newTandyr = scanner.nextBoolean();
                    pstmt = con.prepareStatement("UPDATE TandyrDoners SET brand = ?, size = ?, price = ?, onion = ?, meat = ?, tandyr = ? WHERE id = ?");
                    pstmt.setString(1, newBrand);
                    pstmt.setString(2, newSize);
                    pstmt.setDouble(3, newPrice);
                    pstmt.setString(4, newMeat);
                    pstmt.setBoolean(5, newOnion);
                    pstmt.setBoolean(6, newTandyr);
                    pstmt.setInt(7, id);
                    break;
                }
                default:
                    System.out.println("Invalid category");
                    return;
            }
            int i = pstmt.executeUpdate();
            System.out.println(i + " records updated");
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}

