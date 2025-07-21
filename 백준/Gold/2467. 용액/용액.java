import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Long[] M;
    static Long min;
    static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        M = new Long[N];
        min = Long.MAX_VALUE;
        pos = new int[2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            M[i] = Long.parseLong(st.nextToken());
        }

        find(0, N - 1);
        System.out.println(M[pos[0]] + " " + M[pos[1]]);
    }

    static void find(int start, int end) {
        if (end <= start) return;

        long value = M[start] + M[end];
        if (min > Math.abs(value)) {
            min = Math.abs(value);
            pos[0] = start;
            pos[1] = end;
        }
        if (value >= 0) {
            find(start, end - 1);
        }
        else {
            find(start + 1, end);
        }
    }
}