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
        System.out.println("�������� ������� ����� ��������� ��� ��������");
        System.out.println("��� ��������: ���");
        Scanner scanner = new Scanner(System.in);
        String goods = scanner.nextLine();
        return goods;
    }

    void setGoodsBasket(CMSAdmin cmsAdmin/*, HashMap<String,String> hashMapAddToBasket*/) { // ����� hashMapGoods �� Catalog - hashMapAddToBasket �� �����
        String enterArticle = addGoodsToBasket(); // "�������� ������� ����� ��������� � �������" "��� ��������: ���"//

        while (getYerOrNot(enterArticle)) { // ��������� ���� - ���� �� �������� "���" ��� "���" - ���� �����������, ����� ������� �� ����� !

            if(!getUserChoice(cmsAdmin, enterArticle)){
                break;
            } else {
                enterArticle = addGoodsToBasket();
            }
        }
/*
            if (!hashMapBasket.isEmpty()) {
                    String NotAdded = hashMapBasket.get(enterArticle);
                    if (NotAdded.equals("����� �� ��������!")) {
                        hashMapBasket.put(enterArticle, "����� ��������!   ");
                    }
                } else {
                    for (String keys : cmsAdmin.getMapArticle().keySet()) {
                        String valueKey = cmsAdmin.getMapArticle().get(keys);
                        if (valueKey.equals(enterArticle)) {
                            hashMapBasket.put(valueKey, "����� ��������!   ");
                        } else {
                            hashMapBasket.put(valueKey, "����� �� ��������!");
                        }
                    }
                }

*/


            /*for(String keyMapArticle: cmsAdmin.getMapArticle().keySet()){
                String valueMapArticle = cmsAdmin.getMapArticle().get(keyMapArticle);

                if(enterArticle.equals(valueMapArticle)){*/
            /*if(cmsAdmin.getMapArticle().containsKey(enterArticle)){
                    // ������ �������
                    hashMapAddToBasket*/
            //hashMapBasket.put(enterArticle, "����� ��������!   ");
            //hashMapBasket = hashMapAddToBasket;*/

            // ������ �������
                   /*if(!hashMapAddToBasket.isEmpty()){
                        String NotAdded = hashMapAddToBasket.get(valueMapArticle);
                        if(NotAdded.equals("����� �� ��������!")){
                                hashMapAddToBasket.put(valueMapArticle, "����� ��������!   ");
                        }
                    } else {
                        for (String keys: cmsAdmin.getMapArticle().keySet()) {
                            String valueKey = cmsAdmin.getMapArticle().get(keys);
                            if (valueKey.equals(enterArticle)) {
                                hashMapAddToBasket.put(valueKey, "����� ��������!   ");
                            } else {
                                hashMapAddToBasket.put(valueKey, "����� �� ��������!");
                            }
                        }
                    }
                } *//*else {
                    /*if(counter==lengthCMS){
                        System.out.print("������ �� ��������� � �������, ������� ����������� � ����, ��������� ����");
                    } else {
                        counter++;
                    }
                }
            }*/
        /*while(!enterArticle.equals("���") && !enterArticle.equals("���")){
            if (!hashMapArticleBasket.containsKey(enterArticle)) {
                System.out.println("������ �������� ��� ��� ������ ��������� ����");
                setGoodsBasket(cmsAdmin);
            } else {
                return setGoodsToTable = true;
            }
        } return setGoodsToTable = false;*/
        /*if (!enterArticle.equals("���") && !enterArticle.equals("���")) {
            if (!hashMapArticle.containsKey(enterArticle)) {
                System.out.println("������ �������� ��� ��� ������ ��������� ����");
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
        if(!enterArticle.equals("���") && !enterArticle.equals("���")){
            return true;
        } else {
            return false;
        }
    }
    boolean orAddGoods(String userChoice){
        if(userChoice.equals("��������") || userChoice.equals("��������")){
            return true;
        } else {
            return false;
        }
    }
    boolean orDeleteGoods(String userChoice){
        if(userChoice.equals("�������") || userChoice.equals("�������")){
            return true;
        } else {
            return false;
        }
    }
    boolean orExitGoods(String userChoice){
        if(userChoice.equals("�����") || userChoice.equals("�����")){
            return true;
        } else {
            return false;
        }
    }
    boolean orChange(String userChoice){
        if(userChoice.equals("��������") || userChoice.equals("��������")){
            return true;
        } else {
            return false;
        }
    }
    boolean getUserChoice(CMSAdmin cmsAdmin, String enterArticle){
        System.out.println("��������: \"��������\" ��� \"�������\" ��� \"�����\"" );
        String userChoice = new Scanner(System.in).nextLine();

        if(orAddGoods(userChoice)){
            if(cmsAdmin.getMapArticle().containsKey(enterArticle)){
                hashMapBasket.put(enterArticle, "����� ��������!   ");;
            } else {
                doNotExistArticle();
            }
        } else if(orDeleteGoods(userChoice)){
            if(cmsAdmin.getMapArticle().containsKey(enterArticle)){
                hashMapBasket.put(enterArticle, "����� �� ��������!");
            } else {
                doNotExistArticle();
            }
        } else if(orExitGoods(userChoice)){
            return false;
        } else {
            System.out.println("�� ��������� ������� �������� ��������� ��� ���!");
            getUserChoice(cmsAdmin, enterArticle);
        }
        return true;
    }
    void doNotExistArticle(){
        System.out.println("������ �������� ��� � ���� ������, ��������� ����! ");
    }
    void setBasketMenu(){
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,55 : System.out.print("|");break;
                case 25   : System.out.print("�������� ����� ");break;
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
                case 5   : System.out.print("�����  ");break;
                case 12   : System.out.print("���-��");break;
                case 17   : System.out.print("����  ");break;
                case 19   : System.out.print("����� ");break;
                case 23   : System.out.print("����� ��������,�������");break;
                default   : System.out.print(" ");
            }
        }
    }
    // ������ - ���������� ������
    void setBasketGoods(CMSAdmin cmsAdmin){
        System.out.println();
        System.out.println("�������� ������: �� ��� ���");
        String orYesNotOrder = new Scanner(System.in).nextLine();

        if(getHashMapAddedGoods().isEmpty()){
            System.out.println();
            notAddedToBasket(); // ����� ������ - ������ �� ��������� � �������
        } else if(!getHashMapAddedGoods().isEmpty() && !getHashMapAddedGoods().containsValue("����� ��������!   ")){
            System.out.println();
            notAddedToBasket(); // ����� ������ - ������ �� ��������� � �������
        } else if(getYerOrNot(orYesNotOrder) && !orChange(orYesNotOrder)){// ����� �������� �������� ������ "��������" ����� - �� ���� ������ ����� ����� ������ �� ������ ������
            setUserBasket(cmsAdmin); // ����������� - ���������� ������
        } else {
            System.out.println("���������� ������ ���� ��������!");
        }
    }
    // ����� ������ - ������ �� ��������� � �������
    void notAddedToBasket(){
        for(int i=0; i<70; i++){
            if(i==0 || i==41){
                System.out.print("|");
            }
            else if(i==20){
                System.out.print("������ �� ��������� � �������");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    // ����������� - ���������� ������
    void setUserBasket(CMSAdmin cmsAdmin){
        HashMap<String,String> hashMapName = cmsAdmin.getMapName();
        HashMap<String,String> hashMapPrice = cmsAdmin.getMapPrice();
        HashMap<String,String> hashMapAddedGoods = getHashMapAddedGoods();

        //System.out.println();
        System.out.println("�������� ����� �������� - 25 ����");
        String userAddress = new Scanner(System.in).nextLine();
        System.out.println("�������� ���������� ������� - 5 ����");
        String numberOrder = new Scanner(System.in).nextLine();
        System.out.println("�������� ����� ��������");
        String phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("�������� ������� ������");
        String article = new Scanner(System.in).nextLine();

        for(Map.Entry<String,String> entry: hashMapAddedGoods.entrySet()){ // ������� - "����� ��������!   "
            String key = entry.getKey();
            String value = entry.getValue();
            if(value.equals("����� ��������!   ") && key.equals(article)){
                for(Map.Entry<String,String> entryName: hashMapName.entrySet()){ // ������� - �������� ������
                    String keyName = entryName.getKey();
                    String valueName = entryName.getValue();
                    if(key.equals(keyName)){
                        for(Map.Entry<String,String> entryPrice: hashMapPrice.entrySet()){ // ������� - ����
                            String keyPrice = entryPrice.getKey();
                            String valuePrice = entryPrice.getValue();
                            if(key.equals(keyPrice)){
                                hashMapAddress.put(key,userAddress);     // ������� - �����
                                hashMapNumberOrder.put(key,numberOrder); // ������� - ���-�� �������
                                hashMapPhones.put(key,phoneNumber);      // ������� - �������
                                setTableBasket(key,valueName,numberOrder,valuePrice,userAddress,phoneNumber); // ������� ��������������� ������
                            }
                        }
                    }
                }
            }
        }
    }
    // ����� ������� ������
    void setOrder(){
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,55 : System.out.print("|");break;
                case 25   : System.out.print("����� �������� ");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,27 : System.out.print("|");break;
                case 5   : System.out.print("�����  ");break;
                case 12   : System.out.print("���-��");break;
                case 17   : System.out.print("����  ");break;
                case 19   : System.out.print("����� ");break;
                case 23   : System.out.print("����� ��������,�������");break;
                default   : System.out.print(" ");
            }
        }
    }
    // ������� ��������������� ������
    void setTableBasket(String key, String valueName, String numberOrder, String valuePrice, String userAddress, String phoneNumber){
        int lItems;
        int counterNumber = -1,
            counterPrice = -1,
            counterSum = -1,
            counterAddress = -1,
            counterEnd = -1;
        String sum="";

        // ����� ������� ������ - ������
        setOrder();
        // - �����

        // ����� ������ �� ��������
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
            arrayListOrders.add(phoneNumber+";�������"+key+";�����- "+valueName+";���-��-"+numberOrder+";����-  "+valuePrice+";�����- "+sum+";�����- "+userAddress);
        }
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    // ������� - ����� ���� �������
    void setMainTableBasket(CMSAdmin cmsAdmin){
        HashMap<String,String> hashMapName = cmsAdmin.getMapName();
        HashMap<String,String> hashMapPrice = cmsAdmin.getMapPrice();
        HashMap<String,String> hashMapAddedGoods = getHashMapAddedGoods();

        System.out.println();
        System.out.println("�������� ����� �������� ��� ��������� ������ ������");
        String userPhone = new Scanner(System.in).nextLine();

        if(getHashMapPhone().containsValue(userPhone)){
            System.out.println();
            for(Map.Entry<String, String> entryPhone: getHashMapPhone().entrySet()){ // ������� - �������
                String key = entryPhone.getKey();
                String phoneNumber = entryPhone.getValue();
                if(userPhone.equals(phoneNumber)){
                    for(Map.Entry<String, String> entryName: hashMapName.entrySet()) { // ������� - �������� ������
                        String keyName = entryName.getKey();
                        String valueName = entryName.getValue();
                        if (key.equals(keyName)) {
                            for(Map.Entry<String, String> entryOrder: getHashMapNumberOrder().entrySet()) { // ������� - ���-�� ������
                                String keyOrder = entryOrder.getKey();
                                String numberOrder = entryOrder.getValue();
                                if(key.equals(keyOrder)){
                                    for(Map.Entry<String, String> entryPrice: hashMapPrice.entrySet()){ // ������� - ����
                                        String keyPrice = entryPrice.getKey();
                                        String valuePrice = entryPrice.getValue();
                                        if(key.equals(keyPrice)){
                                            for(Map.Entry<String, String> entryAddress: getHashMapAddress().entrySet()){ // ������� - �����
                                                String keyAddress = entryAddress.getKey();
                                                String userAddress = entryAddress.getValue();
                                                if(key.equals(keyAddress)){
                                                    setTableBasket(key, valueName, numberOrder, valuePrice, userAddress, phoneNumber); // ������� ��������������� ������
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
        } else if(getHashMapAddedGoods().containsValue("����� ��������!   ")){
            System.out.println();
            notAddedToBasket();
            String numberOrder = "0";
            String userAddress = "���";
            String phoneNumber = "���";
            for(Map.Entry<String,String> entry: hashMapAddedGoods.entrySet()){ // ������� - "����� ��������!   "
                String key = entry.getKey();
                String value = entry.getValue();
                if(value.equals("����� ��������!   ")){
                    for(Map.Entry<String,String> entryName: hashMapName.entrySet()){ // ������� - �������� ������
                        String keyName = entryName.getKey();
                        String valueName = entryName.getValue();
                        if(key.equals(keyName)){
                            for(Map.Entry<String,String> entryPrice: hashMapPrice.entrySet()){ // ������� - ����
                                String keyPrice = entryPrice.getKey();
                                String valuePrice = entryPrice.getValue();
                                if(key.equals(keyPrice)){
                                    setTableBasket(key,valueName,numberOrder,valuePrice,userAddress,phoneNumber); // ������� ��������������� ������
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("�� ��������� ���-��, ����� � ����� ��������");
            System.out.println("������ �� ��������!");
        } else {
            System.out.println("������ �� ��������� � �������");
        }
    }
}

