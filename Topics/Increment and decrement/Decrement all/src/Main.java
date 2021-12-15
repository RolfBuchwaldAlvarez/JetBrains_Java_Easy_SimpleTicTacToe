import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // put your code here
        String[] numbers = sc.nextLine().split(" ");

        for (String number : numbers) {
            System.out.print(Integer.parseInt(number) - 1 + " ");
        }
    }
}