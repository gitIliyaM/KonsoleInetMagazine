import java.util.Scanner;

public class MainInterface {
    public static void main(String[] args) {
        mainMenu();
        Catalog catalog = new Catalog();
        PersonalAccount personalAccount = new PersonalAccount();
        ShopCart shopCart = new ShopCart();
        CMSAdmin cmsAdmin = new CMSAdmin();
        for(String scan=scanner(); !scan.equals("X")&&!scan.equals("�"); scan = scanner()){

            switch (scan){
                case "�������","�������"                :
                    mainMenu();
                    break;
                case "�������", "�������"               :
                    mainMenu();
                    catalog.setCatalogMenu();
                    catalog.setCatalogGoods(cmsAdmin,shopCart);
                    break;
                case "������ �������", "������ �������" :
                    mainMenu();
                    personalAccount.setUserLKMenu();
                    personalAccount.setUserEntry();
                    break;
                case "�������", "�������"               :
                    mainMenu();
                    shopCart.setBasketMenu();
                    shopCart.setMainTableBasket(cmsAdmin);
                    break;
                case "�����"                            :
                    setDataCMS(cmsAdmin);
                    mainMenu();
            }
        }
    }
    static String scanner(){
        System.out.println();
        System.out.println("�������� � �������� ������ �� ����!");
        System.out.println("��� �������� ������� - ������� � ������ ����");
        System.out.println("���������� ������� - ������ ����� - X");
        System.out.println("���� � cms - �����: �����");
        String scanner = new Scanner(System.in).nextLine();
        return scanner;
    }
    static void mainMenu(){
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,44 : System.out.print("|");break;
                case 10   : System.out.print("�������");break;
                case 20   : System.out.print("������ �������");break;
                case 30   : System.out.print("�������");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    static void setDataCMS(CMSAdmin cmsAdmin){
        System.out.println("���� � CMS ����� (������: �����)");
        System.out.println("������� ������ ��� �������� - ���");
        String orPasswordStop = new Scanner(System.in).nextLine();
        if(orPasswordStop.equals("�����")){
            do {
                System.out.println("���������� ���� ������ - �� ��� ���");
                orPasswordStop = new Scanner(System.in).nextLine();

                switch (orPasswordStop){
                    case "��","��","��" : cmsAdmin.setDataCMS();
                }

                switch (orPasswordStop){
                    case "���","���","���" :
                        String deleteYesOrNo = scannerYesOrNo(); // "������� ������ �� ���� ������ - �� ��� ���?"
                        while(yesYep(deleteYesOrNo)){
                            if(!cmsAdmin.checkDataCMS()){
                                break;
                            } else {
                                cmsAdmin.deleteDataCMS();
                            }
                        }
                }
            } while (noNot(orPasswordStop)); // !orPasswordStop.equals("���")
        } else if(noNot(orPasswordStop)){
                System.out.println("����� �� ���������� ������, ��������� ���� ������!");
                setDataCMS(cmsAdmin);
        }
    }
    static boolean yesYep(String deleteYesOrNo){
        if(deleteYesOrNo.equals("��") || deleteYesOrNo.equals("��") || deleteYesOrNo.equals("��")){
            return true;
        } else {
            return false;
        }
    }
    static boolean noNot(String orPasswordStop){
        if(!orPasswordStop.equals("���") && !orPasswordStop.equals("���") && !orPasswordStop.equals("���")){
            return true;
        } else {
            return false;
        }
    }
    static String scannerYesOrNo(){
        System.out.println("������� ������ �� ���� ������ - �� ��� ���?");
        Scanner scanner = new Scanner(System.in);
        String deleteYesOrNo = scanner.nextLine();
        return deleteYesOrNo;
    }
}
