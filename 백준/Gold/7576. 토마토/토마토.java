import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<int[]> q = new ArrayDeque<>();
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int max = 0;
    static int failsTT;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
                if(map[i][j] == 0) {
                    failsTT ++;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] now = q.removeFirst();

            for(int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >= 0 && y >= 0 && x < n && y < m) {
                    if(map[x][y] == 0) {
                        q.add(new int[]{x, y});
                        map[x][y] = map[now[0]][now[1]] + 1;
                        failsTT --;
                        max = map[x][y];
                    }
                }
            }
        }

        if (failsTT != 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(Math.max(max - 1, 0));
        }
    }
}