import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // start coding here
        int num = sc.nextInt();
        int factor = 1;

        while(factor * factor <= num) {
            System.out.println(factor * factor);
            factor++;
        }
    }
}