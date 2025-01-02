import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;
    public static int nowSize = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
//        1 .. N
        for (int i = 0; i < N; i++) {
            nowSize = Integer.parseInt(br.readLine());
            Vector<String> vec = new Vector<>();
            vec.add("1");
            dfs(vec, 2);
            bw.write("\n");
        }

        bw.close();
    }

    public static void dfs(Vector<String> vec, int position) throws IOException {
        if (position == nowSize + 1) {
            print(vec);
        }
        else {
            vec.add(" ");
            vec.add(position + "");
            dfs(vec, position + 1);
            vec.remove(vec.size() - 1);
            vec.remove(vec.size() - 1);

            vec.add("+");
            vec.add(position + "");
            dfs(vec, position + 1);
            vec.remove(vec.size() - 1);
            vec.remove(vec.size() - 1);

            vec.add("-");
            vec.add(position + "");
            dfs(vec, position + 1);
            vec.remove(vec.size() - 1);
            vec.remove(vec.size() - 1);
        }
    }

    public static void print(Vector<String> vec) throws IOException {
        int result = 0;
        String lastInput = "";
        int select = 0;

        for(String s : vec) {
            if (s.equals("+")) {
                if (select == 0) {
                    result += Integer.parseInt(lastInput);
                }
                else {
                    result -= Integer.parseInt(lastInput);
                }
                lastInput = "";
                select = 0;
            }
            else if (s.equals("-")) {
                if (select == 0) {
                    result += Integer.parseInt(lastInput);
                }
                else {
                    result -= Integer.parseInt(lastInput);
                }
                lastInput = "";
                select = 1;
            }
            else if (s.equals(" ")) {}
            else {
                lastInput += s;
            }
        }

        if (select == 0) {
            result += Integer.parseInt(lastInput);
        }
        else {
            result -= Integer.parseInt(lastInput);
        }

        if (result == 0) {
            for(String s : vec) {
                bw.write(s);
            }
            bw.write("\n");
        }
    }
}
