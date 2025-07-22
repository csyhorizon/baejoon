import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int C, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // C = 목표값, N = 테스트 개수
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] dp = new int[1100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int custom = Integer.parseInt(st.nextToken());

            for (int j = custom; j < 1100; j++) {
                if (dp[j - custom] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], cost + dp[j - custom]);
                }
            }
        }

            int answer = Integer.MAX_VALUE;
            for (int i = C; i < 1100; i++) {
                answer = Math.min(answer, dp[i]);
            }
        System.out.println(answer);
    }
}