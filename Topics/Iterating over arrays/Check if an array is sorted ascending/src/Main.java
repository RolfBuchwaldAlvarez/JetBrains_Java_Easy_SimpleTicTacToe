import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int[] nums = new int[arraySize];
        boolean ascending = true;

        for (int i = 0; i < arraySize; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < arraySize - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                continue;
            } else {
                ascending = false;
            }
        }
        System.out.println(ascending);
    }
}