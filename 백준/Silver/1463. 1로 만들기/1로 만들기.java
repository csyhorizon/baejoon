import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int min = Integer.MAX_VALUE;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    static int[] d = new int[1000001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        dfs(n);
        System.out.println(d[n]);
    }

    public static void dfs(int sum) {
        for (int i = 2; i <= sum; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
        }
    }
}
