import java.io.*;
import java.util.HashMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] d = new int[1000001];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for(int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1;
            if(i % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1);
            if(i % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1);
        }
        System.out.println(d[n]);
    }
}