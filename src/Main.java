import products.*;
import java.util.Scanner;
import java.util.ArrayList;
///SE-2224 Teacher: Almas B.
///SE-2224 Ussenov Bekzat
///SE-2224 Amina Zholturganova
///SE-2224 Temen Arnur
public class Main {
    public static ArrayList<String> foods = new ArrayList<>();
    public static ArrayList<String> categories = new ArrayList<>();
    public static ArrayList<Integer> productNums = new ArrayList<>();
    public static ArrayList<Double> prices = new ArrayList<>();

    public static void main(String[] args) {
        Market market = new Market();
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println();
        System.out.println("      ВЕЛУОМ ДИАР КЛИЕНТ");
        System.out.println();
        System.out.println("******************************");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        login();
    }


    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println();
        System.out.println("         Кто ты Воин?");
        System.out.println();
        System.out.println("[1] Простолюдин       [2] Повар");
        System.out.println("******************************");
        System.out.println();
        int choice = scanner.nextInt();
        if (choice == 1) {
            buyerPart();
        } else if (choice == 2) {
            sellerPart();
        } else {
            System.out.println("Кто я? Найди свой жизненный путь");
            login();
        }
    }
    public static void newSeller(){
        Market market = new Market();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи свое имя: ");
        String login = scanner.nextLine();
        System.out.println("Введи свое секретное слово: ");
        String password = scanner.nextLine();
        market.createSeller(login, password);
        sellerPart();
    }
    public static void getIn(){
        Scanner scanner = new Scanner(System.in);
        Market market = new Market();
        System.out.println("Введи свое имя: ");
        String login = scanner.nextLine();
        System.out.println("Введи свое секретное слово: ");
        String password = scanner.nextLine();
        if (market.checkPassword(login, password)) {
            System.out.println("Ты принят в царство");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        } else {
            System.out.println("Доступ отклонен, пади ниц! и вернись туда откуда прибыл");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            sellerPart();
        }
        sellOperate(login);
    }
    public static void sellerPart() {
        Scanner scanner = new Scanner(System.in);
        Market market = new Market();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("****** Список создателей продуктов ******");
        market.showSellers();
        System.out.println("[1]----> Родить нового создателя ");
        System.out.println("[2]----> Войти как бывший создатель");
        System.out.println("[0]----> Вернуться откуда начал ");
        int dilemma = scanner.nextInt();
        if(dilemma==0){
            login();
        }
        else if(dilemma==1){
            newSeller();
        }
        else if(dilemma==2){
            getIn();
        }
        else{
            System.out.println("Кажется я слепой");
            sellerPart();
        }

    }
    public static void sellOperate(String login){
        Market market = new Market();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("****** Что будем делать ******");
        System.out.println();
        while (true) {
            System.out.println("[1]----> То что я создавал ");
            System.out.println("[2]----> Изменить то что я создал ");
            System.out.println("[3]----> Создать новые блага ");
            System.out.println("[4]----> Забрать блага ");
            System.out.println("[0]----> Вернуться откуда начал ");
            int des = scanner.nextInt();
            if (des == 0) {
                sellerPart();
            }
            else if (des == 1) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("****** Что хотите увидеть ******");
                System.out.println("[1]---->Овощи");
                System.out.println("[2]---->Фермерские продукты");
                System.out.println("[3]---->Бургеры");
                System.out.println("[4]---->Донеры");
                int choice = scanner.nextInt();
                String category = "";
                switch (choice) {
                    case 1:
                        category = "Vegetables";
                        market.readFoodByLogin(category,login);
                        break;
                    case 2:
                        category = "Farm";
                        market.readFoodByLogin(category,login);
                        break;
                    case 3:
                        category = "CheeseBurgers";
                        market.readFoodByLogin(category,login);
                        break;
                    case 4:
                        category = "TandyrDoners";
                        market.readFoodByLogin(category,login);
                        break;
                    default:
                        System.out.println("Слепащара");
                        sellOperate(login);
                }
            }
            else if(des == 2){
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("****** Что хотите обновить ******");
                System.out.println("[1]---->Овощи");
                System.out.println("[2]---->Фермерские продукты");
                System.out.println("[3]---->Бургеры");
                System.out.println("[4]---->Донеры");
                int choice = scanner.nextInt();
                int id;
                String category = "";
                switch (choice) {
                    case 1:
                        category = "Vegetables";
                        market.readFoodByLogin(category,login);
                        System.out.println("Type ID: ");
                        id = scanner.nextInt();
                        market.updateProduct(id,category);
                        break;
                    case 2:
                        category = "Farm";
                        market.readFoodByLogin(category,login);
                        System.out.println("Type ID: ");
                        id = scanner.nextInt();
                        market.updateProduct(id,category);
                        break;
                    case 3:
                        category = "ChesseBurgers";
                        market.readFoodByLogin(category,login);
                        System.out.println("Type ID: ");
                        id = scanner.nextInt();
                        market.updateProduct(id,category);
                        break;
                    case 4:
                        category = "TandyrDoners";
                        market.readFoodByLogin(category,login);
                        System.out.println("Type ID: ");
                        id = scanner.nextInt();
                        market.updateProduct(id,category);
                        break;
                    default:
                        System.out.println("Я великий слепой");
                        sellOperate(login);
                }
            }
            else if(des == 3) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("****** Какие блага хотите создать ******");
                System.out.println("[1]---->Овощи");
                System.out.println("[2]---->Фермерские продукты");
                System.out.println("[3]---->Бургеры");
                System.out.println("[4]---->Донеры");
                int choice = scanner.nextInt();
                int id;
                switch (choice) {
                    case 1:
                        market.initVegetables(login);
                        break;
                    case 2:
                        market.initFarm(login);
                        break;
                    case 3:
                        market.initCheeseBurgers(login);
                        break;
                    case 4:
                        market.initTandyrDoners(login);
                        break;
                    default:
                        System.out.println("Я великий слепой");
                        sellOperate(login);
                }
            }
            else if(des==4) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Что хотите удалить ");
                System.out.println("[1]---->Овощи");
                System.out.println("[2]---->Фермерские продукты");
                System.out.println("[3]---->Бургеры");
                System.out.println("[4]---->Донеры");
                int choice = scanner.nextInt();
                int id;
                String category = "";
                switch (choice) {
                    case 1:
                        category = "Vegetables";
                        market.readFoodByLogin(category, login);
                        System.out.println("Type ID: ");
                        id = scanner.nextInt();
                        market.deleteFood(category,id);
                        break;
                    case 2:
                        category = "Farm";
                        market.readFoodByLogin(category, login);
                        System.out.println("Type ID: ");
                        id = scanner.nextInt();
                        market.deleteFood(category,id);
                        break;
                    case 3:
                        category = "CheeseBurgers";
                        market.readFoodByLogin(category, login);
                        System.out.println("Type ID: ");
                        id = scanner.nextInt();
                        market.deleteFood(category,id);
                        break;
                    case 4:
                        category = "TandyrDoners";
                        market.readFoodByLogin(category, login);
                        System.out.println("Type ID: ");
                        id = scanner.nextInt();
                        market.deleteFood(category,id);
                        break;
                    default:
                        System.out.println("Я великий слепой");
                        sellOperate(login);
                }
            }
        }
    }
    public static void buyerPart() {
        Market market = new Market();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("****** Привет Простолюдин ******");
        while (true) {
            System.out.println("Какие блага хочешь увидеть");
            System.out.println("[1]---->Овощи");
            System.out.println("[2]---->Фермерские продукты");
            System.out.println("[3]---->Бургеры");
            System.out.println("[4]---->Донеры");
            System.out.println("[5]---->ЧЕЕЕЕЕЕЕЕЕЕККККК ПЛИИИИИИИЗ");
            System.out.println("[0]---->Ливнуть");
            System.out.println("Писать сюда: ");
            int choice = scanner.nextInt();
            String category = scanner.nextLine();
            switch (choice) {
                case 0:
                    login();
                case 1:
                    category = "Vegetables";
                    break;
                case 2:
                    category = "Farm";
                    break;
                case 3:
                    category = "CheeseBurgers";
                    break;
                case 4:
                    category = "TandyrDoners";
                    break;
                case 5:
                    printBasket();
                default:
                    System.out.println("Я великий слепой");
                    buyerPart();
            }
            System.out.println("Вот что ты можешь выбрать: ");
            market.readFood(category);
            System.out.println("Пиши АЙДИ блага чтобы увидеть больше, либо ливни нажав [0]");
            int productNum = scanner.nextInt();
            if (productNum == 0) {
                buyerPart();
            } else {
                market.readFoodByID(category, productNum);
            }
            System.out.println("[1]----> Купить");
            System.out.println("[0]---->Ливнуть ");
            int dilemma = scanner.nextInt();
            if(dilemma==1){
                categories.add(category);
                foods.add(market.returnSize(category,productNum));
                productNums.add(productNum);
                prices.add(market.returnPrice(category,productNum));
                System.out.println("Круто, блага добавлены в вашу корзину приколов");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                buyerPart();
            }
            else{
                buyerPart();
            }
        }
    }
    public static void removeFood(int productNum){
        int index = productNums.indexOf(productNum);
        if(index != -1){
            foods.remove(index);
            productNums.remove(index);
            prices.remove(index);
        }
    }
    public static void confirm() {
        Market market = new Market();
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        for (Double price : prices) {
            total += price;
        }
        System.out.println("Сумма: " + total);
        System.out.println("Точно купить? (Да/Нет) : ");
        String confirm = scanner.nextLine();
        if (confirm.equals("Да")) {
            System.out.println("Куплено!");
            try {
                for (int i = 0; i < foods.size(); i++) {
                    String category = categories.get(i);
                    int id = productNums.get(i);
                    market.deleteFood(category, id);
                }
                foods.clear();
                categories.clear();
                productNums.clear();
                prices.clear();
            } catch (IndexOutOfBoundsException e) {
                buyerPart();
            }
        } else {
            printBasket();
        }
    }
    public static void remove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой ID? ");
        int id = scanner.nextInt();
        removeFood(id);
        System.out.println("Уничтожено, и стерто до молекул");
        printBasket();
    }
    public static void printBasket(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("****** Ваша корзина(ne dorabatano) ******");
        System.out.println("******        Milestone2           ******");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < foods.size(); i++) {
            System.out.println("No_ "+ (i+1));
            System.out.println("ID "+productNums.get(i));
            System.out.println("Ценник "+prices.get(i));
            System.out.println("************************");
            System.out.println();
        }
        System.out.println("[1]---> Купить");
        System.out.println("[2]---> Уничтожить");
        System.out.println("[0]---> Вернуться ");
        System.out.println();
        System.out.println();
        int des = scanner.nextInt();
        if(des==1){
            confirm();
        }
        else if(des==2){
            remove();
        }
    }
}