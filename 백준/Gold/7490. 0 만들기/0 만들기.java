import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            sol(1, 1, 1, 0, "1");
            bw.write("\n");
        }
        bw.close();
    }

    public static void sol(int d, int stack, int def_sign, int sum, String str) throws IOException {
        if (d == n) {
            sum += (stack * def_sign);
            if (sum == 0) {
                bw.write(str + "\n");
            }
            return;
        }
        sol(d + 1, stack * 10 + d + 1, def_sign, sum, str + " " + (d + 1));
        sol(d + 1, d + 1, 1, sum + ((stack) * def_sign), str + "+" + (d + 1));
        sol(d + 1, d + 1, -1, sum + ((stack) * def_sign), str + "-" + (d + 1));
    }
}
