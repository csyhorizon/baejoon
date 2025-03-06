import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        bw.write("<");

        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                q.addLast(q.removeFirst());
            }
            if (q.size() == 1) {
                bw.write(q.removeFirst() + ">");
            }
            else {
                bw.write(q.removeFirst() + ", ");
            }
        }
        bw.close();
    }
}