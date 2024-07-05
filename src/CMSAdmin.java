import java.util.HashMap;
import java.util.Scanner;

public class CMSAdmin {
    HashMap<String,String> hashMapArticle = new HashMap<>();
    HashMap<String,String> hashMapName = new HashMap<>();
    HashMap<String,String> hashMapPrice = new HashMap<>();

    void setDataCMS(){
        System.out.println("������� ������� �� 7 ����, ������������ �� 12 ����, ���� ������ �� 6 ����");

        String article = getArticle();

        if(checkArticle(hashMapArticle,article)){
            hashMapArticle.put(article,article);

            String name = getName();
            String price = getPrice();

            hashMapName.put(article,name);
            hashMapPrice.put(article,price);
        } else {
            System.out.println("��������� ������� � ���� ����������, ������� �����");
            setDataCMS();
        }
    }
    boolean checkDataCMS(){
        if(hashMapArticle.isEmpty()){
            System.out.println("���� ��������� ������!");
            return false;
        } else {
            return true;
        }
    }
    void deleteDataCMS(){
        System.out.println("������� ������� �� 7 ����");
        String article = getArticle();
        hashMapArticle.remove(article);
    }
    String getArticle() {
        System.out.println("�������:");
        String article = new Scanner(System.in).nextLine();
        while(article.length()>7){
            System.out.println("����� �������� ������ 7 ���� ��������� ����");
            article = getArticle();
        }
        while(article.equals("")){
            System.out.println("�� ����� ������� ��������� ����");
            article = getArticle();
        }
        return article;
    }
    String getName(){
        System.out.println("������������:");
        String name = new Scanner(System.in).nextLine();
        while(name.length()>12){
            System.out.println("����� ����� ������ 12 ���� ��������� ����");
            name = getName();
        }
        while(name.equals("")){
            System.out.println("�� ����� ����� ��������� ����");
            name = getName();
        }
        return name;
    }
    String getPrice(){
        System.out.println("����:");
        String price = new Scanner(System.in).nextLine();
        while(price.length()>6){
            System.out.println("����� ���� ������ 6 ���� ��������� ����");
            price = getPrice();
        }
        while(price.equals("")){
            System.out.println("�� ����� ���� ��������� ����");
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
