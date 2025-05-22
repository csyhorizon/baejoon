import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, start, end;
    static int[] dist;
    static int[] route;
    static boolean[] visited;
    static ArrayList<Node>[] list;

    static class Node implements Comparable<Node> {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        dist[start] = 0;
        route[start] = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (!visited[current.e]) {
                visited[current.e] = true;

                for (int i = 0; i < list[current.e].size(); i++) {
                    Node next = list[current.e].get(i);
                    if (dist[next.e] > dist[current.e] + next.cost) {
                        dist[next.e] = dist[current.e] + next.cost;
                        q.offer(new Node(next.e, dist[next.e]));
                        route[next.e] = current.e;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        route = new int[N + 1];

        Arrays.fill(dist, 100_000_000);
        visited = new boolean[N + 1];
        dijkstra();

        System.out.println(dist[end]);

        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while (current != 0) {
            routes.add(current);
            current = route[current];
        }
        System.out.println(routes.size());

        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }
}