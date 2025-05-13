import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 10) {
            N *= 10;
        }
        int now = N;
        int cycle = 1;

        if (N == 0) {
            System.out.println(cycle);
        } else {
            now = (now % 10) * 10 + ((now / 10) + (now % 10)) % 10;
            while (N != now) {
                now = (now % 10) * 10 + ((now / 10) + (now % 10)) % 10;
                cycle ++;
                if (N == now) {
                    break;
                }
            }
            System.out.println(cycle);
        }
    }
}