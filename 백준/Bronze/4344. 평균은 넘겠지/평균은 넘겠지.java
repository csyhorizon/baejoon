import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int[] arr = new int[A];
            double result = 0;
            for (int j = 0; j < A; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                result += arr[j];
            }
            result /= A;
            double ck = 0;
            for (int j = 0; j < A; j++) {
                if (result < arr[j]) ck ++;
            }

            String value = String.format("%.3f", ck / A * 100) + "%\n";
            bw.write(value);
        }
        bw.close();
    }
}