
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();



		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			List<Integer> list = new ArrayList<>();
			int M = Integer.parseInt(br.readLine());
			sb.append((M / 2) + 1).append("\n");

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (j != 0 && j % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
				list.add(Integer.parseInt(st.nextToken()));
				if (j % 2 == 0) {
					list.sort(Comparator.comparing(x -> x));
					sb.append(list.get(list.size() / 2)).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
