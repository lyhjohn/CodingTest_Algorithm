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
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();

			if (cmd.contains("push_back")) {
				int num = Integer.parseInt(cmd.substring(10));
				list.add(num);
				continue;
			}

			if (cmd.contains("push_front")) {
				int num = Integer.parseInt(cmd.substring(11));
				list.add(0, num);
				continue;
			}

			if (cmd.equals("pop_front")) {
				if (list.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(list.remove(0));
				continue;
			}

			if (cmd.equals("pop_back")) {
				if (list.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(list.remove(list.size() - 1));
				continue;
			}

			if (cmd.equals("size")) {
				System.out.println(list.size());
				continue;
			}

			if (cmd.equals("empty")) {
				System.out.println(list.isEmpty() ? 1 : 0);
				continue;
			}

			if (cmd.equals("front")) {
				if (list.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(list.get(0));
				continue;
			}

			if (cmd.equals("back")) {
				if (list.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(list.get(list.size() - 1));
			}
		}


	}
}
