import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PersonalAccount {
    HashMap<String, String> hashMapPhonesPasswords = new HashMap<>();
    ArrayList<String> arrayListAllData = new ArrayList<>();
    void setUserEntry() { // Вывод талицы ЛК - инициализация
        System.out.println();
        System.out.println("Регистрация/Авторизация личного кабинета");
        System.out.println("Напишите номер телефона");
        String userPhoneNumber = new Scanner(System.in).next();
        System.out.println("....и пароль");
        String userPass = new Scanner(System.in).next();
        System.out.println("Передумали? напишите - Да, или Нет");
        String userExit = new Scanner(System.in).next();

        if(!getYesOrNot(userExit)){ // прерывание регистрации
            System.out.println("Вышли из ЛК");
        } else if(!hashMapPhonesPasswords.containsKey(userPhoneNumber) && !hashMapPhonesPasswords.containsValue(userPass)){ // регистрация нового ЛК
            hashMapPhonesPasswords.put(userPhoneNumber, userPass);
            setUserInfo(userPhoneNumber, userPass);
            System.out.println();
            System.out.println("Вы зарегистрированы!");
        } else {
            for(String arrayKey: arrayListAllData){ // вход в ЛК ранее созданного пользователя
                if(arrayKey.contains(userPhoneNumber) && arrayKey.contains(userPass)){
                    setAndPrintUserInfo(getEmail(arrayKey),userPass,getName(arrayKey),getSecName(arrayKey),userPhoneNumber);
                    break;
                }
            }
        }
    }
    // setAndPrintUserInfo(String emailUser, String userPass, String nameUser, String secondNameUser, String userPhoneNumber)

    // ("телефон- "+userPhoneNumber+" email-  "+emailUser+" пароль- "+userPass+" имя-    "+nameUser+" фамилия-"+secondNameUser)
    String getSecName(String arrayKey){
        int indexSecNameStart = arrayKey.indexOf(" фамилия-")+" фамилия-".length();
        String secNameUser = arrayKey.substring(indexSecNameStart);
        return secNameUser;
    }
    String getName(String arrayKey){
        int indexNameSart = arrayKey.indexOf(" имя-    ")+" имя-    ".length();
        int indexNameEnd = arrayKey.indexOf(" фамилия-");
        String nameUser = arrayKey.substring(indexNameSart,indexNameEnd);
        return nameUser;
    }
    String getEmail(String arrayKey){
        int indexEmailSart = arrayKey.indexOf(" email-  ")+" email-  ".length();
        int indexEmailEnd = arrayKey.indexOf(" пароль- ");
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
        if(userExit.equals("Нет") || userExit.equals("нет")){
            return true;
        } else {
            return false;
        }
    }
    void setUserLKMenu(){ // Текст - Личный кабинет
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,56 : System.out.print("|");break;
                case 25   : System.out.print("Личный кабинет");break;
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
    void setLKSubMenu(){ // Текст с информацией
        for(int i=0; i<70; i++){
            switch (i){
                case 0,45 : System.out.print("|");break;
                case 5   : System.out.print("E-mail");break;
                case 13   : System.out.print("Пароль");break;
                case 21   : System.out.print("Имя");break;
                case 28   : System.out.print("Фамилия");break;
                case 36   : System.out.print("Телефон");break;
                default   : System.out.print(" ");
            }
        }
    }
    void setUserInfo(String userPhoneNumber, String userPass){
        System.out.println();
        System.out.println("Напишите вашу эл.почту - 12 букв");
        String emailUser = new Scanner(System.in).nextLine();
        System.out.println();
        System.out.println("Напишите ваше Имя - 12 букв");
        String nameUser = new Scanner(System.in).nextLine();
        System.out.println();
        System.out.println("Напишите вашу Фамилию - 8 букв");
        String secondNameUser = new Scanner(System.in).nextLine();

        arrayListAllData.add("телефон- "+userPhoneNumber+" email-  "+emailUser+" пароль- "+userPass+" имя-    "+nameUser+" фамилия-"+secondNameUser);

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
            // Вывод на просмотр
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
