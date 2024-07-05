import java.util.HashMap;
import java.util.Scanner;

public class CMSAdmin {
    HashMap<String,String> hashMapArticle = new HashMap<>();
    HashMap<String,String> hashMapName = new HashMap<>();
    HashMap<String,String> hashMapPrice = new HashMap<>();

    void setDataCMS(){
        System.out.println("Введите артикул из 7 букв, наименование из 12 букв, цену товара из 6 букв");

        String article = getArticle();

        if(checkArticle(hashMapArticle,article)){
            hashMapArticle.put(article,article);

            String name = getName();
            String price = getPrice();

            hashMapName.put(article,name);
            hashMapPrice.put(article,price);
        } else {
            System.out.println("Введенный артикул в базе существует, введите новый");
            setDataCMS();
        }
    }
    boolean checkDataCMS(){
        if(hashMapArticle.isEmpty()){
            System.out.println("База артикулов пустая!");
            return false;
        } else {
            return true;
        }
    }
    void deleteDataCMS(){
        System.out.println("Введите артикул из 7 букв");
        String article = getArticle();
        hashMapArticle.remove(article);
    }
    String getArticle() {
        System.out.println("Артикул:");
        String article = new Scanner(System.in).nextLine();
        while(article.length()>7){
            System.out.println("Длина артикула больше 7 букв повторите ввод");
            article = getArticle();
        }
        while(article.equals("")){
            System.out.println("Не ввели артикул повторите ввод");
            article = getArticle();
        }
        return article;
    }
    String getName(){
        System.out.println("Наименование:");
        String name = new Scanner(System.in).nextLine();
        while(name.length()>12){
            System.out.println("Длина слова больше 12 букв повторите ввод");
            name = getName();
        }
        while(name.equals("")){
            System.out.println("Не ввели слово повторите ввод");
            name = getName();
        }
        return name;
    }
    String getPrice(){
        System.out.println("Цена:");
        String price = new Scanner(System.in).nextLine();
        while(price.length()>6){
            System.out.println("Длина цены больше 6 цифр повторите ввод");
            price = getPrice();
        }
        while(price.equals("")){
            System.out.println("Не ввели цену повторите ввод");
            price = getPrice();
        }
        return price;
    }
    boolean checkArticle(HashMap<String,String> hashMapArticle, String article){
        if(hashMapArticle.containsKey(article)){
            return false;
        }
        /*if(!hashMapArticle.isEmpty()){
            for(String key: hashMapArticle.keySet()){
                String value = hashMapArticle.get(key);
                if(hashMapArticle.containsKey(article)){
                    return false;
                }
                if(value.equals(article)){
                    return false;
                }
            } return true;
        }*/ else {
            return true;
        }
    }
    HashMap<String, String> getMapArticle(){
        return hashMapArticle;
    }
    HashMap<String, String> getMapName(){
        return hashMapName;
    }
    HashMap<String, String> getMapPrice(){
        return hashMapPrice;
    }
}
