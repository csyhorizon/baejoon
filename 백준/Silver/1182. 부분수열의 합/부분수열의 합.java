import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int answer;
    private static int N;
    private static int S;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (S == 0) {
            System.out.println(answer - 1);
        }
        else {
            System.out.println(answer);
        }
    }

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) answer ++;
            return;
        }

        dfs(depth + 1, sum + num[depth]);
        dfs(depth + 1, sum);
    }
}
