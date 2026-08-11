import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

public class Solution {

    public static PerformOperation isOdd() {
        return new PerformOperation() {
            public boolean check(int a) {
                return a % 2 != 0;
            }
        };
    }

    public static PerformOperation isPrime() {
        return new PerformOperation() {
            public boolean check(int a) {
                if (a < 2) {
                    return false;
                }

                for (int i = 2; i * i <= a; i++) {
                    if (a % i == 0) {
                        return false;
                    }
                }

                return true;
            }
        };
    }

    public static PerformOperation isPalindrome() {
        return new PerformOperation() {
            public boolean check(int a) {
                int original = a;
                int reverse = 0;

                while (a > 0) {
                    reverse = reverse * 10 + a % 10;
                    a = a / 10;
                }

                return original == reverse;
            }
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int condition = sc.nextInt();
            int number = sc.nextInt();

            PerformOperation op;

            if (condition == 1) {
                op = isOdd();
                System.out.println(op.check(number) ? "ODD" : "EVEN");
            } 
            else if (condition == 2) {
                op = isPrime();
                System.out.println(op.check(number) ? "PRIME" : "COMPOSITE");
            } 
            else {
                op = isPalindrome();
                System.out.println(op.check(number) ? "PALINDROME" : "NOT PALINDROME");
            }
        }

        sc.close();
    }
