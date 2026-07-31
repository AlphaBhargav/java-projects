import java.util.Scanner;
import java.util.Random;

public class Bhargav {
    public static void main(String[] args) {
        String upper,lower,digits,Symbols;
        String Password = "";

        upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lower = "abcdefghijklmnopqrstuvwxyz";
        digits = "0123456789";
        Symbols = "!@#$%^&*";
        int t1,t2,t3,t4;

        System.out.print("Enter the number of uppercase: ");
        Scanner b = new Scanner(System.in);
        t1 = b.nextInt();
        System.out.print("Enter the number of lowercase: ");
        t2 = b.nextInt();

        System.out.print("Enter the number of digits: ");
        t3 = b.nextInt();

        System.out.print("Enter the number of Symbols: ");
        t4 = b.nextInt();

        Random thanuja = new Random();

        for (int i = 0; i < t1; i++) {
            int index = thanuja.nextInt(upper.length());
            Password = Password + upper.charAt(index);
        }
         for (int i = 0; i < t2; i++) {
            int index = thanuja.nextInt(lower.length());
            Password = Password + lower.charAt(index);
        }
         for (int i = 0; i < t3; i++) {
            int index = thanuja.nextInt(digits.length());
            Password = Password + digits.charAt(index);
        }
         for (int i = 0; i < t4; i++) {
            int index = thanuja.nextInt(Symbols.length());
            Password = Password + Symbols.charAt(index);
        }

        System.out.println("Your password is: " + Password);
        b.close();
    }

}
