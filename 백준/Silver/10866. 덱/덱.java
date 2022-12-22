import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();

			if (cmd.contains("push_back")) {
				list.add(Integer.parseInt(cmd.substring(10)));
				continue;
			} else if (cmd.contains("push_front")) {
				list.add(0, Integer.parseInt(cmd.substring(11)));
				continue;
			} else if (cmd.equals("pop_front")) {
				sb.append(list.isEmpty() ? -1 : list.remove(0));
			} else if (cmd.equals("pop_back")) {
				sb.append(list.isEmpty() ? -1 : list.remove(list.size() - 1));
			} else if (cmd.equals("size")) {
				sb.append(list.size());
			} else if (cmd.equals("empty")) {
				sb.append(list.isEmpty() ? 1 : 0);
			} else if (cmd.equals("front")) {
				sb.append(list.isEmpty() ? -1 : list.get(0));
			} else if (cmd.equals("back")) {
				sb.append(list.isEmpty() ? -1 : list.get(list.size() - 1));
			}

			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
