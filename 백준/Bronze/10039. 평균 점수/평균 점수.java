import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(br.readLine());
            a += Math.max(b, 40);
        }

        System.out.println(a / 5);
    }
}