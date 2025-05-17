import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    static class Node implements Comparable<Node> {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value == o.value) {
                return Integer.compare(this.index, o.index);
            }
            return Integer.compare(o.value, this.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> a = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            a.add(new Node(v, i));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Node> b = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(st.nextToken());
            b.add(new Node(v, i));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(a);
        Collections.sort(b);

        int idxa = 0, idxb = 0, limita = 0, limitb = 0;
        while (idxa < n && idxb < m) {
            if (a.get(idxa).value == b.get(idxb).value) {
                if (limita > a.get(idxa).index) idxa++;
                else if (limitb > b.get(idxb).index) idxb++;
                else {
                    limita = a.get(idxa).index;
                    limitb = b.get(idxb).index;
                    ans.add(a.get(idxa).value);
                    idxa++;
                    idxb++;
                }
            }
            else if (a.get(idxa).value > b.get(idxb).value) idxa++;
            else idxb++;
        }

        bw.write(ans.size() + "\n");
        for (int x : ans) {
            bw.write(x + " ");
        }
        bw.close();
    }
}