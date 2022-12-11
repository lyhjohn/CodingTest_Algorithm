import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		if (T % 10 != 0) {
			bw.write("-1");
		} else {
			bw.write(T / 300 + " ");
			T %= 300;

			bw.write(T / 60 + " ");
			T %= 60;

			bw.write(T / 10 + "");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
