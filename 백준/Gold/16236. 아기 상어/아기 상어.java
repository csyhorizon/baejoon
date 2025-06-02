import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x, y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static void bfs(int x, int y) {
        int eating = 0;
        posX = x; posY = y;

        while (true) {
            Queue<Node> q = new LinkedList<>();
            List<Node> preyList = new ArrayList<>();
            check = new boolean[N][N];

            check[posX][posY] = true;
            q.add(new Node(posX, posY, 0));

            while (!q.isEmpty()) {
                Node node = q.poll();
                int nMove = node.dist;

                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
                    if (check[nx][ny]) continue;
                    check[nx][ny] = true;

                    if(map[nx][ny] <= size) {
                        if(map[nx][ny] != 0 && map[nx][ny] < size) {
                            preyList.add(new Node(nx, ny, nMove + 1));
                        }
                        q.add(new Node(nx, ny, nMove + 1));
                    }
                }
            }

            if (preyList.isEmpty()) break;
            else {
                if (preyList.size() > 1) {
                    sorted(preyList);
                }

                Node e = preyList.get(0);
                time += e.dist;
                eating ++;

                map[posX][posY] = 0;
                posX = e.x;
                posY = e.y;
                map[posX][posY] = 9;

                if(size == eating) {
                    size ++;
                    eating = 0;
                }
            }
        }
    }

    static void sorted(List<Node> list) {
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.dist == o2.dist) {
                    if (o1.x == o2.x)
                        return o1.y - o2.y;
                    else
                        return o1.x - o2.x;
                } else
                    return o1.dist - o2.dist;
            }
        });
    }

    static int N, posX, posY, time = 0, size = 2;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;

        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 9) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);
        System.out.println(time);
    }
}