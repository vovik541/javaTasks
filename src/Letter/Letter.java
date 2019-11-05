package Letter;

import java.util.Scanner;

public class Letter {
    final public static int ASCII_A = (int)'A';
    final public static int ASCII_Z = (int)'Z';

    private static int checkMessageStatus(int huntedLetter, int userLetter){
        if (userLetter < ASCII_A || userLetter > ASCII_Z){
            return 0;
        } else if (huntedLetter > userLetter){
            return 2;
        } else if (huntedLetter < userLetter){
            return 3;
        } else {
            return 4;
        }
    }

    private static void showMessage (int messageStatus, int count){
        switch (messageStatus){
            case 0: System.out.println("Please, check the rules clearly!"); break;
            case 1: System.out.println("Please, try your luck: ..."); break;
            case 2: System.out.println("Too low! Try again:"); break;
            case 3: System.out.println("Too high! Try again:"); break;
            case 4: System.out.println("Congratulations, you WIN!!! The number of your efforts is "+ count + "."); break;
            default: System.out.println("Error!!!");break;
        }
    }

    private static int normilizeToInt(char letter){
        return (int)String.valueOf(letter).toUpperCase().charAt(0);
    }

    private static int getUserInput(){
        Scanner scanner = new Scanner(System.in);
        int userLetter = normilizeToInt(scanner.next().charAt(0));
        return userLetter;
    }

    public static void letter (){
        int huntedLetter = normilizeToInt('C');
        int messageStatus = 1;
        int userLetter;
        int count = 0;

        do{
            showMessage(messageStatus,count);
            userLetter = getUserInput();
            messageStatus = checkMessageStatus(huntedLetter,userLetter);
            count++;
        }while (messageStatus != 4);

        showMessage(messageStatus,count);
    }

    public static void main(String[] args) {
        letter();
    }
}
