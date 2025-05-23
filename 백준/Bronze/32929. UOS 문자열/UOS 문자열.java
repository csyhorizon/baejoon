import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int value = N % 3;

        if (value == 0) {
            System.out.println("S");
        }
        else if (value == 1) {
            System.out.println("U");
        }
        else {
            System.out.println("O");
        }
    }
}