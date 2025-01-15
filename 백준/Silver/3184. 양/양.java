import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int R, C;
    static int[][] arr;
    static int sheep = 0;
    static int hunter = 0;

    static ArrayDeque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char a = s.charAt(j);
                // 벽
                if (a == '#') {
                    arr[i][j] = -1;
                }
                // 양
                else if (a == 'o') {
                    arr[i][j] = 0;
                    sheep ++;
                }
                else if (a == '.') {
                    arr[i][j] = 1;
                }
                // 늑대
                else if (a == 'v') {
                    arr[i][j] = 2;
                    hunter ++;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != -1) {
                    q.addLast(new int[]{i, j});
                    dfs();
                }
            }
        }

        System.out.println(sheep + " " + hunter);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 0 양 1 길 2 늑대
    public static void dfs() {
        int thisSheep = 0;
        int thisHunter = 0;

        while(!q.isEmpty()) {
            int[] pos = q.removeFirst();
            int x = pos[0];
            int y = pos[1];
            if (arr[x][y] != -1) {
                if (arr[x][y] == 0) thisSheep ++;
                else if(arr[x][y] == 2) thisHunter ++;

                arr[x][y] = -1;
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if(arr[nx][ny] != -1) {
                            q.addLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        if (thisSheep > thisHunter) {
            hunter -= thisHunter;
        }
        else {
            sheep -= thisSheep;
        }
    }
}
