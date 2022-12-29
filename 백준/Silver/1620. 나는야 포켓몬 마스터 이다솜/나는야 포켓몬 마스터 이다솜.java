import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder output = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			map.put(s, i);
			list.add(s);
		}

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (map.get(s) != null) {
				output.append(map.get(s)).append("\n");
			} else {
				output.append(list.get(Integer.parseInt(s) - 1)).append("\n");
			}
		}
		System.out.println(output);
	}
}
