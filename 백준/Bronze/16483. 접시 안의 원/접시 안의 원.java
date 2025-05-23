import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double T = Double.parseDouble(br.readLine());

        System.out.println(Math.round((T / 2) * (T / 2)));
    }
}