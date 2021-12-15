import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] splitted = sc.nextLine().split(" ");
        boolean alphabeticalOrder = true;
        
        for (int i = 0; i < splitted.length - 1; i++) {
            String a = splitted[i];
            String b = splitted[i + 1];

            if (a.compareTo(b) > 0) {
                alphabeticalOrder = false;
                break;
            }
        }
        System.out.println(alphabeticalOrder);
    }
}