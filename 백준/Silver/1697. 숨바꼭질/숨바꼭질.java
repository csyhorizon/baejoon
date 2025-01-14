import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> q = new ArrayDeque<>();
    static StringTokenizer st;
    static int result = -1;
    static boolean returns;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[100001];

        q.add(n);

        if (n == target) returns = true;

        while(!q.isEmpty() && !returns) {
            int now = q.removeFirst();

            int a = now - 1;
            int b = now + 1;
            int c = now * 2;

            if (a == target || b == target || c == target) {
                result = arr[now] + 1;
                break;
            }

            if (0 <= a && a <= 100000 && arr[a] == 0) {
                q.add(a);
                arr[a] = arr[now] + 1;
            }
            if (0 <= b && b <= 100000 && arr[b] == 0) {
                q.add(b);
                arr[b] = arr[now] + 1;
            }
            if (0 <= c && c <= 100000 && arr[c] == 0) {
                q.add(c);
                arr[c] = arr[now] + 1;
            }
        }

        System.out.println(returns ? 0 : result);
    }
}