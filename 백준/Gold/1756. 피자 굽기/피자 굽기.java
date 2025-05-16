import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] diff;
    static int pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        diff = new int[N + 1];
        diff[0] = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            diff[i] = Integer.parseInt(st.nextToken());
            diff[i] = Math.min(diff[i - 1], diff[i]);
        }

        st = new StringTokenizer(br.readLine());
        pos = N;

        for (int i = 0; i < M; i++) {
            int size = Integer.parseInt(st.nextToken());
            dropPizza(size);
        }

        System.out.println(pos);
    }

    static void dropPizza(int size) {
        boolean flag = false;

        for (int i = pos; i > 0; i--) {
            if (size <= diff[i]) {
                pos = i;
                diff[i] = 0;
                flag = true;
                break;
            }
        }

        if (!flag) pos = 0;
    }
}