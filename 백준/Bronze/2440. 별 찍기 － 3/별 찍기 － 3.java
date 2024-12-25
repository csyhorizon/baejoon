import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        star3(Integer.parseInt(br.readLine()));
        bw.flush();
    }

    public static void star3(int n) throws IOException {
        if (n == 0) return;
        for(int i = 0; i < n; i++) {
            bw.write("*");
        }
        bw.write("\n");
        star3(n - 1);
    }
}
