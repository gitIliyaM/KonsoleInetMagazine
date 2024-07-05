import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopCart {
    //boolean setGoodsToTable = false;
    HashMap<String, String> hashMapBasket = new HashMap<>();
    HashMap<String, String> hashMapAddress = new HashMap<>();
    HashMap<String, String> hashMapNumberOrder = new HashMap<>();
    HashMap<String, String> hashMapPhones = new HashMap<>();
    ArrayList<String> arrayListOrders = new ArrayList<>();

    String addGoodsToBasket() {
        System.out.println();
        System.out.println("Напишите артикул товар добавится или удалится");
        System.out.println("или напишите: нет");
        Scanner scanner = new Scanner(System.in);
        String goods = scanner.nextLine();
        return goods;
    }

    void setGoodsBasket(CMSAdmin cmsAdmin/*, HashMap<String,String> hashMapAddToBasket*/) { // убрал hashMapGoods из Catalog - hashMapAddToBasket не нужна
        String enterArticle = addGoodsToBasket(); // "Напишите артикул товар добавится в корзину" "или напишите: Нет"//

        while (getYerOrNot(enterArticle)) { // проверяем ввод - Если не написано "Нет" или "нет" - цикл открывается, иначе выходим из цикла !

            if(!getUserChoice(cmsAdmin, enterArticle)){
                break;
            } else {
                enterArticle = addGoodsToBasket();
            }
        }
/*
            if (!hashMapBasket.isEmpty()) {
                    String NotAdded = hashMapBasket.get(enterArticle);
                    if (NotAdded.equals("Товар не добавлен!")) {
                        hashMapBasket.put(enterArticle, "Товар добавлен!   ");
                    }
                } else {
                    for (String keys : cmsAdmin.getMapArticle().keySet()) {
                        String valueKey = cmsAdmin.getMapArticle().get(keys);
                        if (valueKey.equals(enterArticle)) {
                            hashMapBasket.put(valueKey, "Товар добавлен!   ");
                        } else {
                            hashMapBasket.put(valueKey, "Товар не добавлен!");
                        }
                    }
                }

*/


            /*for(String keyMapArticle: cmsAdmin.getMapArticle().keySet()){
                String valueMapArticle = cmsAdmin.getMapArticle().get(keyMapArticle);

                if(enterArticle.equals(valueMapArticle)){*/
            /*if(cmsAdmin.getMapArticle().containsKey(enterArticle)){
                    // первый вариант
                    hashMapAddToBasket*/
            //hashMapBasket.put(enterArticle, "Товар добавлен!   ");
            //hashMapBasket = hashMapAddToBasket;*/

            // второй вариант
                   /*if(!hashMapAddToBasket.isEmpty()){
                        String NotAdded = hashMapAddToBasket.get(valueMapArticle);
                        if(NotAdded.equals("Товар не добавлен!")){
                                hashMapAddToBasket.put(valueMapArticle, "Товар добавлен!   ");
                        }
                    } else {
                        for (String keys: cmsAdmin.getMapArticle().keySet()) {
                            String valueKey = cmsAdmin.getMapArticle().get(keys);
                            if (valueKey.equals(enterArticle)) {
                                hashMapAddToBasket.put(valueKey, "Товар добавлен!   ");
                            } else {
                                hashMapAddToBasket.put(valueKey, "Товар не добавлен!");
                            }
                        }
                    }
                } *//*else {
                    /*if(counter==lengthCMS){
                        System.out.print("Товары не добавлены в корзину, артикул отсутствует в базе, повторите ввод");
                    } else {
                        counter++;
                    }
                }
            }*/
        /*while(!enterArticle.equals("Нет") && !enterArticle.equals("нет")){
            if (!hashMapArticleBasket.containsKey(enterArticle)) {
                System.out.println("Такого артикула нет для товара повторите ввод");
                setGoodsBasket(cmsAdmin);
            } else {
                return setGoodsToTable = true;
            }
        } return setGoodsToTable = false;*/
        /*if (!enterArticle.equals("Нет") && !enterArticle.equals("нет")) {
            if (!hashMapArticle.containsKey(enterArticle)) {
                System.out.println("Такого артикула нет для товара повторите ввод");
                setGoodsBasket(hashMapArticle);
            } else {
                return true;
            }
        } return false;
    }*/
        }
    HashMap<String, String> getHashMapAddedGoods() {
        return hashMapBasket;
    }
    HashMap<String, String> getHashMapAddress() {
        return hashMapAddress;
    }
    HashMap<String, String> getHashMapNumberOrder() {
        return hashMapNumberOrder;
    }
    ArrayList <String> getArrayListOrders(){ return arrayListOrders; }
    HashMap <String,String> getHashMapPhone(){ return hashMapPhones; }
    boolean getYerOrNot(String enterArticle){
        if(!enterArticle.equals("Нет") && !enterArticle.equals("нет")){
            return true;
        } else {
            return false;
        }
    }
    boolean orAddGoods(String userChoice){
        if(userChoice.equals("Добавить") || userChoice.equals("добавить")){
            return true;
        } else {
            return false;
        }
    }
    boolean orDeleteGoods(String userChoice){
        if(userChoice.equals("Удалить") || userChoice.equals("удалить")){
            return true;
        } else {
            return false;
        }
    }
    boolean orExitGoods(String userChoice){
        if(userChoice.equals("Выйти") || userChoice.equals("выйти")){
            return true;
        } else {
            return false;
        }
    }
    boolean orChange(String userChoice){
        if(userChoice.equals("Изменить") || userChoice.equals("изменить")){
            return true;
        } else {
            return false;
        }
    }
    boolean getUserChoice(CMSAdmin cmsAdmin, String enterArticle){
        System.out.println("Напишите: \"добавить\" или \"удалить\" или \"выйти\"" );
        String userChoice = new Scanner(System.in).nextLine();

        if(orAddGoods(userChoice)){
            if(cmsAdmin.getMapArticle().containsKey(enterArticle)){
                hashMapBasket.put(enterArticle, "Товар добавлен!   ");;
            } else {
                doNotExistArticle();
            }
        } else if(orDeleteGoods(userChoice)){
            if(cmsAdmin.getMapArticle().containsKey(enterArticle)){
                hashMapBasket.put(enterArticle, "Товар не добавлен!");
            } else {
                doNotExistArticle();
            }
        } else if(orExitGoods(userChoice)){
            return false;
        } else {
            System.out.println("Не правильно указали действие повторите еще раз!");
            getUserChoice(cmsAdmin, enterArticle);
        }
        return true;
    }
    void doNotExistArticle(){
        System.out.println("Такого артикула нет в базе данных, повторите ввод! ");
    }
    void setBasketMenu(){
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,55 : System.out.print("|");break;
                case 25   : System.out.print("Оформить заказ ");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        setBasketSubMenu();
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    void setBasketSubMenu(){
        for(int i=0; i<70; i++){
            switch (i){
                case 0,27 : System.out.print("|");break;
                case 5   : System.out.print("Заказ  ");break;
                case 12   : System.out.print("Кол-во");break;
                case 17   : System.out.print("Цена  ");break;
                case 19   : System.out.print("Сумма ");break;
                case 23   : System.out.print("Адрес доставки,телефон");break;
                default   : System.out.print(" ");
            }
        }
    }
    // Начало - Оформление заказа
    void setBasketGoods(CMSAdmin cmsAdmin){
        System.out.println();
        System.out.println("Оформить заказа: Да или Нет");
        String orYesNotOrder = new Scanner(System.in).nextLine();

        if(getHashMapAddedGoods().isEmpty()){
            System.out.println();
            notAddedToBasket(); // Вывод текста - товары не добавлены в корзину
        } else if(!getHashMapAddedGoods().isEmpty() && !getHashMapAddedGoods().containsValue("Товар добавлен!   ")){
            System.out.println();
            notAddedToBasket(); // Вывод текста - товары не добавлены в корзину
        } else if(getYerOrNot(orYesNotOrder) && !orChange(orYesNotOrder)){// можно доделать добавить способ "Изменить" заказ - не стал делать думаю этого хватит на данный момент
            setUserBasket(cmsAdmin); // Продолжение - Оформление заказа
        } else {
            System.out.println("Оформление заказа было отменено!");
        }
    }
    // Вывод текста - товары не добавлены в корзину
    void notAddedToBasket(){
        for(int i=0; i<70; i++){
            if(i==0 || i==41){
                System.out.print("|");
            }
            else if(i==20){
                System.out.print("товары не добавлены в корзину");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    // Продолжение - Оформление заказа
    void setUserBasket(CMSAdmin cmsAdmin){
        HashMap<String,String> hashMapName = cmsAdmin.getMapName();
        HashMap<String,String> hashMapPrice = cmsAdmin.getMapPrice();
        HashMap<String,String> hashMapAddedGoods = getHashMapAddedGoods();

        //System.out.println();
        System.out.println("Напишите адрес доставки - 25 букв");
        String userAddress = new Scanner(System.in).nextLine();
        System.out.println("Напишите количество товаров - 5 цифр");
        String numberOrder = new Scanner(System.in).nextLine();
        System.out.println("Напишите номер телефона");
        String phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("Напишите артикул товара");
        String article = new Scanner(System.in).nextLine();

        for(Map.Entry<String,String> entry: hashMapAddedGoods.entrySet()){ // артикул - "Товар добавлен!   "
            String key = entry.getKey();
            String value = entry.getValue();
            if(value.equals("Товар добавлен!   ") && key.equals(article)){
                for(Map.Entry<String,String> entryName: hashMapName.entrySet()){ // артикул - название товара
                    String keyName = entryName.getKey();
                    String valueName = entryName.getValue();
                    if(key.equals(keyName)){
                        for(Map.Entry<String,String> entryPrice: hashMapPrice.entrySet()){ // артикул - цена
                            String keyPrice = entryPrice.getKey();
                            String valuePrice = entryPrice.getValue();
                            if(key.equals(keyPrice)){
                                hashMapAddress.put(key,userAddress);     // артикул - адрес
                                hashMapNumberOrder.put(key,numberOrder); // артикул - кол-во товаров
                                hashMapPhones.put(key,phoneNumber);      // артикул - телефон
                                setTableBasket(key,valueName,numberOrder,valuePrice,userAddress,phoneNumber); // Таблица сформированного заказа
                            }
                        }
                    }
                }
            }
        }
    }
    // шапка таблицы заказа
    void setOrder(){
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,55 : System.out.print("|");break;
                case 25   : System.out.print("Заказ оформлен ");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,27 : System.out.print("|");break;
                case 5   : System.out.print("Заказ  ");break;
                case 12   : System.out.print("Кол-во");break;
                case 17   : System.out.print("Цена  ");break;
                case 19   : System.out.print("Сумма ");break;
                case 23   : System.out.print("Адрес доставки,телефон");break;
                default   : System.out.print(" ");
            }
        }
    }
    // Таблица сформированного заказа
    void setTableBasket(String key, String valueName, String numberOrder, String valuePrice, String userAddress, String phoneNumber){
        int lItems;
        int counterNumber = -1,
            counterPrice = -1,
            counterSum = -1,
            counterAddress = -1,
            counterEnd = -1;
        String sum="";

        // шапка таблицы заказа - Начало
        setOrder();
        // - Конец

        // Вывод заказа на просмотр
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i=0; i<70; i++){
            if(i==0){
                System.out.print("|");
            } else if(i==5){
                System.out.print("");
            } else {
                System.out.print(" ");
            }
            if(i==5){
                System.out.print(valueName);
                lItems = valueName.length();
                lItems = 12-lItems;
                counterNumber = lItems+i+1;
            }
            if(counterNumber==i){
                System.out.print(numberOrder);
                lItems = numberOrder.length();
                lItems = 9-lItems;
                counterPrice = lItems+counterNumber+1;
            }
            if(counterPrice==i){
                System.out.print(valuePrice);
                lItems = valuePrice.length();
                lItems = 6-lItems;
                counterSum = lItems+counterPrice+1;
            }
            if(counterSum==i) {
                int amount = Integer.parseInt(numberOrder)*Integer.parseInt(valuePrice);
                sum = String.valueOf(amount);
                System.out.print(sum);
                lItems = sum.length();
                lItems = 8-lItems;
                counterAddress = lItems+counterSum+1;
            }
            if(counterAddress==i){
                System.out.print(userAddress);
                lItems = userAddress.length();
                lItems = 25-lItems;
                counterEnd = lItems+counterAddress;

            }
            if(counterEnd==i){
                System.out.print("|");
            }
            arrayListOrders.add(phoneNumber+";артикул"+key+";заказ- "+valueName+";Кол-во-"+numberOrder+";цена-  "+valuePrice+";сумма- "+sum+";адрес- "+userAddress);
        }
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    // Корзина - показ всех заказов
    void setMainTableBasket(CMSAdmin cmsAdmin){
        HashMap<String,String> hashMapName = cmsAdmin.getMapName();
        HashMap<String,String> hashMapPrice = cmsAdmin.getMapPrice();
        HashMap<String,String> hashMapAddedGoods = getHashMapAddedGoods();

        System.out.println();
        System.out.println("Напишите номер телефона для просмотра вашего заказа");
        String userPhone = new Scanner(System.in).nextLine();

        if(getHashMapPhone().containsValue(userPhone)){
            System.out.println();
            for(Map.Entry<String, String> entryPhone: getHashMapPhone().entrySet()){ // артикул - телефон
                String key = entryPhone.getKey();
                String phoneNumber = entryPhone.getValue();
                if(userPhone.equals(phoneNumber)){
                    for(Map.Entry<String, String> entryName: hashMapName.entrySet()) { // артикул - название товара
                        String keyName = entryName.getKey();
                        String valueName = entryName.getValue();
                        if (key.equals(keyName)) {
                            for(Map.Entry<String, String> entryOrder: getHashMapNumberOrder().entrySet()) { // артикул - кол-во заказа
                                String keyOrder = entryOrder.getKey();
                                String numberOrder = entryOrder.getValue();
                                if(key.equals(keyOrder)){
                                    for(Map.Entry<String, String> entryPrice: hashMapPrice.entrySet()){ // артикул - цена
                                        String keyPrice = entryPrice.getKey();
                                        String valuePrice = entryPrice.getValue();
                                        if(key.equals(keyPrice)){
                                            for(Map.Entry<String, String> entryAddress: getHashMapAddress().entrySet()){ // артикул - адрес
                                                String keyAddress = entryAddress.getKey();
                                                String userAddress = entryAddress.getValue();
                                                if(key.equals(keyAddress)){
                                                    setTableBasket(key, valueName, numberOrder, valuePrice, userAddress, phoneNumber); // Таблица сформированного заказа
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if(getHashMapAddedGoods().containsValue("Товар добавлен!   ")){
            System.out.println();
            notAddedToBasket();
            String numberOrder = "0";
            String userAddress = "Нет";
            String phoneNumber = "Нет";
            for(Map.Entry<String,String> entry: hashMapAddedGoods.entrySet()){ // артикул - "Товар добавлен!   "
                String key = entry.getKey();
                String value = entry.getValue();
                if(value.equals("Товар добавлен!   ")){
                    for(Map.Entry<String,String> entryName: hashMapName.entrySet()){ // артикул - название товара
                        String keyName = entryName.getKey();
                        String valueName = entryName.getValue();
                        if(key.equals(keyName)){
                            for(Map.Entry<String,String> entryPrice: hashMapPrice.entrySet()){ // артикул - цена
                                String keyPrice = entryPrice.getKey();
                                String valuePrice = entryPrice.getValue();
                                if(key.equals(keyPrice)){
                                    setTableBasket(key,valueName,numberOrder,valuePrice,userAddress,phoneNumber); // Таблица сформированного заказа
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("Не заполнили Кол-во, Адрес и номер телефона");
            System.out.println("Заказа не оформлен!");
        } else {
            System.out.println("Товары не добавлены в корзину");
        }
    }
}

