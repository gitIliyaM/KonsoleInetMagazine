import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PersonalAccount {
    HashMap<String, String> hashMapPhonesPasswords = new HashMap<>();
    ArrayList<String> arrayListAllData = new ArrayList<>();
    void setUserEntry() { // ����� ������ �� - �������������
        System.out.println();
        System.out.println("�����������/����������� ������� ��������");
        System.out.println("�������� ����� ��������");
        String userPhoneNumber = new Scanner(System.in).next();
        System.out.println("....� ������");
        String userPass = new Scanner(System.in).next();
        System.out.println("����������? �������� - ��, ��� ���");
        String userExit = new Scanner(System.in).next();

        if(!getYesOrNot(userExit)){ // ���������� �����������
            System.out.println("����� �� ��");
        } else if(!hashMapPhonesPasswords.containsKey(userPhoneNumber) && !hashMapPhonesPasswords.containsValue(userPass)){ // ����������� ������ ��
            hashMapPhonesPasswords.put(userPhoneNumber, userPass);
            setUserInfo(userPhoneNumber, userPass);
            System.out.println();
            System.out.println("�� ����������������!");
        } else {
            for(String arrayKey: arrayListAllData){ // ���� � �� ����� ���������� ������������
                if(arrayKey.contains(userPhoneNumber) && arrayKey.contains(userPass)){
                    setAndPrintUserInfo(getEmail(arrayKey),userPass,getName(arrayKey),getSecName(arrayKey),userPhoneNumber);
                    break;
                }
            }
        }
    }
    // setAndPrintUserInfo(String emailUser, String userPass, String nameUser, String secondNameUser, String userPhoneNumber)

    // ("�������- "+userPhoneNumber+" email-  "+emailUser+" ������- "+userPass+" ���-    "+nameUser+" �������-"+secondNameUser)
    String getSecName(String arrayKey){
        int indexSecNameStart = arrayKey.indexOf(" �������-")+" �������-".length();
        String secNameUser = arrayKey.substring(indexSecNameStart);
        return secNameUser;
    }
    String getName(String arrayKey){
        int indexNameSart = arrayKey.indexOf(" ���-    ")+" ���-    ".length();
        int indexNameEnd = arrayKey.indexOf(" �������-");
        String nameUser = arrayKey.substring(indexNameSart,indexNameEnd);
        return nameUser;
    }
    String getEmail(String arrayKey){
        int indexEmailSart = arrayKey.indexOf(" email-  ")+" email-  ".length();
        int indexEmailEnd = arrayKey.indexOf(" ������- ");
        String emailUser = arrayKey.substring(indexEmailSart,indexEmailEnd);
        return emailUser;
    }
    boolean checkUserPhone(String userPhoneNumber){
        if(hashMapPhonesPasswords.containsKey(userPhoneNumber)){
            return true;
        } else {
            return false;
        }
    }
    boolean checkUserPass(String userPass){
        if(hashMapPhonesPasswords.containsValue(userPass)){
            return true;
        } else {
            return false;
        }
    }
    boolean getYesOrNot(String userExit){
        if(userExit.equals("���") || userExit.equals("���")){
            return true;
        } else {
            return false;
        }
    }
    void setUserLKMenu(){ // ����� - ������ �������
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,56 : System.out.print("|");break;
                case 25   : System.out.print("������ �������");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        setLKSubMenu();
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    void setLKSubMenu(){ // ����� � �����������
        for(int i=0; i<70; i++){
            switch (i){
                case 0,45 : System.out.print("|");break;
                case 5   : System.out.print("E-mail");break;
                case 13   : System.out.print("������");break;
                case 21   : System.out.print("���");break;
                case 28   : System.out.print("�������");break;
                case 36   : System.out.print("�������");break;
                default   : System.out.print(" ");
            }
        }
    }
    void setUserInfo(String userPhoneNumber, String userPass){
        System.out.println();
        System.out.println("�������� ���� ��.����� - 12 ����");
        String emailUser = new Scanner(System.in).nextLine();
        System.out.println();
        System.out.println("�������� ���� ��� - 12 ����");
        String nameUser = new Scanner(System.in).nextLine();
        System.out.println();
        System.out.println("�������� ���� ������� - 8 ����");
        String secondNameUser = new Scanner(System.in).nextLine();

        arrayListAllData.add("�������- "+userPhoneNumber+" email-  "+emailUser+" ������- "+userPass+" ���-    "+nameUser+" �������-"+secondNameUser);

        setAndPrintUserInfo(emailUser,userPass,nameUser,secondNameUser,userPhoneNumber);
    }
    void setAndPrintUserInfo(String emailUser, String userPass, String nameUser, String secondNameUser, String userPhoneNumber){
        int lItems;
        int counterEmail = -1,
            counterPass = -1,
            counterName = -1,
            countersSecondName = -1,
            counterPhone = -1;

        MainInterface.mainMenu();
        setUserLKMenu();
            // ����� �� ��������
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
                System.out.print(emailUser);
                lItems = emailUser.length();
                lItems = 12-lItems;
                counterEmail = lItems+i+1;
            }
            if(counterEmail==i){
                System.out.print(userPass);
                lItems = userPass.length();
                lItems = 12-lItems;
                counterPass = lItems+counterEmail+1;
            }
            if(counterPass==i){
                System.out.print(nameUser);
                lItems = nameUser.length();
                lItems = 8-lItems;
                counterName = lItems+counterPass+1;
            }
            if(counterName==i) {
                System.out.print(secondNameUser);
                lItems = secondNameUser.length();
                lItems = 13-lItems;
                countersSecondName = lItems+counterName+1;
            }
            if(countersSecondName==i){
                System.out.print(userPhoneNumber);
                lItems = userPhoneNumber.length();
                lItems = 14-lItems;
                counterPhone = lItems+countersSecondName+1;
            }
            if(counterPhone==i){
                System.out.print("|");
            }
        }
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
}
