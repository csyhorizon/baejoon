import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int size;
    static int[] arr, list;
    static boolean[] visited;

    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        N = Integer.parseInt(s);
        size = s.length();

        arr = new int[size];
        list = new int[size];
        visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(s.charAt(i) + "");
        }
        backTracking(0);

        System.out.println(max == Integer.MAX_VALUE ? 0 : max);
    }

    static void backTracking(int depth) throws IOException {
        if (depth == size) {
            String s = "";
            for (int i : list) {
                s += i;
            }
            int n = Integer.parseInt(s);

            if (N < n) {
                max = Math.min(max, n);
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = arr[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
