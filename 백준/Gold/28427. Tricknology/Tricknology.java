import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        int[] max = new int[N];

        int M = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
            max[i] = Math.max(A[i][0], A[i][1]);
            M = Math.max(M, max[i]);
        }

        // 에라체 : 소수개수 누적합
        int[] prime_cnt = new int[2 * M + 1];
        int[] num = new int[2 * M + 1];
        num[0] = num[1] = 1;

        for (int i = 2; i < 2 * M + 1; i++) {
            if (num[i] == 0) {
                // 이전 배열 + 1
                prime_cnt[i] = prime_cnt[i - 1] + 1;

                for (int j = 2 * i; j < 2 * M + 1; j+= i) {
                    num[j] = 1;
                }
            }
            else {
                // 이전 배열 그대로
                prime_cnt[i] = prime_cnt[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = prime_cnt[2 * A[i][1] - 1] - prime_cnt[2 * A[i][0]];
            bw.write(cnt + "\n");
        }

        bw.close();
    }
}