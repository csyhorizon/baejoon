import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        long a = 0;
        long b = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= N; i++) {
            long ck = a + b;
            a = b;
            b = ck;
        }

        System.out.println(b);
    }
}