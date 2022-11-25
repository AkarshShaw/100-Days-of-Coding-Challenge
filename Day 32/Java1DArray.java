import java.util.Scanner;
import java.util.Arrays;

public class OneDArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int arr[] = new int[n];
        
        // for reading the array
        for(int i = 0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        
        // for output
        for(int i : arr) {
            System.out.println(i);
        }
    }
}
