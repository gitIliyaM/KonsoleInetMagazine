import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Catalog {
    // ����� hashMapGoods - ������ ��� ������� - shopCart.getHashMapAddedGoods()
    // getTableGoods(hashMapArticle, hashMapName, hashMapPrice, shopCart.getHashMapAddedGoods())

    //HashMap<String,String> hashMapGoods = new HashMap<>();

    /*Catalog(){
        MainInterface.mainMenu();
    }*/
    void setCatalogMenu(){
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,55 : System.out.print("|");break;
                case 25   : System.out.print("������� �������");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        setSubCatalogMenu();
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    void setSubCatalogMenu(){
        for(int i=0; i<70; i++){
            switch (i){
                case 0,32 : System.out.print("|");break;
                case 5   : System.out.print("�������");break;
                case 13   : System.out.print("������������");break;
                case 21   : System.out.print("����");break;
                case 28   : System.out.print("�������� � �������");break;
                default   : System.out.print(" ");
            }
        }
    }
    void setCatalogGoods(CMSAdmin cmsAdmin, ShopCart shopCart){
        HashMap<String,String> hashMapArticle = cmsAdmin.getMapArticle();
        HashMap<String,String> hashMapName = cmsAdmin.getMapName();
        HashMap<String,String> hashMapPrice = cmsAdmin.getMapPrice();


        System.out.println();
        if(hashMapArticle.isEmpty()){
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
        } else if (shopCart.getHashMapAddedGoods().isEmpty()) {
            for (String keys : cmsAdmin.getMapArticle().keySet()) {
                String valueKey = cmsAdmin.getMapArticle().get(keys);
                shopCart.hashMapBasket.put(valueKey, "����� �� ��������!");
            }
            getTableGoods(hashMapArticle, hashMapName, hashMapPrice, shopCart.getHashMapAddedGoods());
            shopCart.setGoodsBasket(cmsAdmin);
        } else{
            getTableGoods(hashMapArticle, hashMapName, hashMapPrice, shopCart.getHashMapAddedGoods());
            shopCart.setGoodsBasket(cmsAdmin);
            shopCart.setBasketGoods(cmsAdmin);
        }
    }
    void getTableGoods(HashMap<String,String> hashMapArticle,HashMap<String,String> hashMapName, HashMap<String,String> hashMapPrice, HashMap<String,String> hashMapAddGoods){

        // � ����� for-each � ��������� () ��������� ��� ���� Set - for (Map.Entry<String,String> setMapArticleName: hashMapArticleName.entrySet())
        // ��� ����� for-each ��������� ��� Set - Set<Map.Entry<String,String>> setMapArticleName =  hashMapArticleName.entrySet();

        // � ����� for-each � ��������� () ��������� ��� ���� Set - for (String key = hashMapArticleName.keySet())
        // ���������� ��� �������� ������ - Set<String> key = hashMapArticleName.keySet();

        /* Set<Map.Entry<String,String>> setMapArticleName =  hashMapArticleName.entrySet();
           Set<Map.Entry<String,Integer>> sethMapArticlePrice =  hashMapArticlePrice.entrySet(); */
        String article = "",
               name = "",
               price = "";



        ArrayList<String> arrayArticles = new ArrayList<>();
        ArrayList<String> arrayNames = new ArrayList<>();
        ArrayList<String> arrayPrices = new ArrayList<>();
        ArrayList<String> arrayAddedGoods = new ArrayList<>();

        for(String articles: hashMapArticle.keySet()) {
            article = hashMapArticle.get(articles);
            arrayArticles.add(article);
            }
        for(String names: hashMapName.keySet()){
            name = hashMapName.get(names);
            arrayNames.add(name);
            }
        for(String prices: hashMapPrice.keySet()){
            price = hashMapPrice.get(prices);
            arrayPrices.add(price);
            }
        for(String addedGoods: hashMapAddGoods.keySet()){
            addedGoods = hashMapAddGoods.get(addedGoods);
            arrayAddedGoods.add(addedGoods);
        }

        int length = arrayArticles.size();
        int lItems;
        for(int j=0; j<length; j++){
            // ������ ��� ��� ����� for �� ���������� � 0, ����� �� ���� ����� � �������� if
            int counterName = -1,
                counterPrice = -1,
                counterBasket = -1,
                counterEnd = -1;
            //System.out.println();
            for(int i=0; i<70; i++){
                if(i==0){
                    System.out.print("|");
                } else if(i==5){ // ���������� ������ ���� ����, ����� ��� ����� �������� � ���� ������������ ����� ����� ��� �����,
                    // �� �������� ���������� �������� if � if � ��� �����, ��������� �� ����� ������ ������
                    System.out.print("");
                } else {
                    System.out.print(" ");
                }
                if(i==5){
                    lItems = arrayArticles.get(j).length();
                    lItems = 7-lItems;    // ������� ����� = ������ ���� (�������) ��� ����� � ��������� �����
                    counterName = lItems+i+7; // �������� ������(����������) ����� - � ���� ������������.
                    // ����� � ���� ������� ������ �� 5 �������,
                    // ���� ������� ������ = 7, ������� ����� ���� ������� � ������ ���� ��� ������ ������ � �� �����������
                    // �� ����� ���� � ���� �������, �������� �������� ��� ������� = ������ ���� ������� - ������ ����� � ���� ����
                    // � ������� ������ ����� ��� = 5, ���� ������� ������ �� ���� ������� �� ���� ������������ = 7
                    // ���������� ��� ��� �������� = ���������� �������� � ���� ������������. ��� ��������� ���� ����������� �������.
                    System.out.print(arrayArticles.get(j));
                }
                if(counterName==i){
                    System.out.print(arrayNames.get(j));
                    lItems = arrayNames.get(j).length();
                    lItems = 12-lItems;
                    counterPrice = lItems+counterName+7;
                }
                if(counterPrice==i){
                    System.out.print(arrayPrices.get(j));
                    lItems = arrayPrices.get(j).length();
                    lItems = 6-lItems;
                    counterBasket = lItems+counterPrice+4;
                }
                if(counterBasket==i) {

                    String value = arrayArticles.get(j);
                    // ������ �������
                    if(hashMapAddGoods.size()!=0){
                        for(Map.Entry<String,String> entry: hashMapAddGoods.entrySet()){
                            String key = entry.getKey();
                            String added = entry.getValue();
                            if(value.equals(key)){
                                System.out.print(added);
                                break;
                            }
                        }
                    }
                    /*if(!hashMapAddGoods.isEmpty()){
                        if(hashMapAddGoods.containsKey(value)){
                            System.out.print(hashMapAddGoods.get(value));
                        } else {
                            System.out.print("����� �� ��������!");
                        }
                    } else {
                        System.out.print("����� �� ��������!");
                    }*/

                    /*if(hashMapAddGoods.containsKey(value)){
                        System.out.print("����� ��������!   ");
                    } else {
                        System.out.print("����� �� ��������!");
                    }*/
                    // ������ �������
                    counterEnd = counterBasket + 3;
                }
                if(counterEnd==i){

                    System.out.print("|");
                    break;
                }
            } System.out.println();
        }
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
}
