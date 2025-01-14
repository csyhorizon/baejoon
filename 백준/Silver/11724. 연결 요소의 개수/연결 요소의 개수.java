import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a - 1].add(b - 1);
            arr[b - 1].add(a - 1);
        }

        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            count++;

            q.add(i);
            while(!q.isEmpty()) {
                int cur = q.removeFirst();
                for(int a : arr[cur]) {
                    if(!visited[a]) {
                        visited[a] = true;
                        q.add(a);
                    }
                }
            }
        }

        System.out.println(count);
    }
}
