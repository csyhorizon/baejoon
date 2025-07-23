import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static long[] arr;
    static int minSize = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        twoPoint();
        System.out.println(minSize == Integer.MAX_VALUE ? 0 : minSize + 1);
    }

    public static void twoPoint() {
        int left = 1;
        int right = 1;

        while (left <= N) {
            long value = arr[right] - arr[left - 1];
            if (value >= S) {
                minSize = Math.min(minSize, (right - left));
                left ++;
                if (minSize == 0) break;
            }
            else {
                if (right == N) {
                    left ++;
                    continue;
                }
                right ++;
            }
        }
    }
}