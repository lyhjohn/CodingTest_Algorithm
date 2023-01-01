import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());

		for (int i = 0; i < input; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			int target = 0;

			Queue<Integer> queue = new LinkedList<>();
			List<Integer> list = new ArrayList<>();

			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st2.nextToken());
				queue.offer(n);
				list.add(n);
				if (j == pos) {
					target = n;
				}
			}

			int count = 0;

			total:
			while (!queue.isEmpty()) {
				int poll = queue.poll();
				int num = list.remove(0);
				int size = list.size();

				for (int j = 0; j < size; j++) {
					if (!list.isEmpty()) {
						if (list.get(j) > poll) {
							list.add(size, num);
							queue.offer(poll);
							pos = --pos < 0 ?  size : pos;
							continue total;
						}
					}

					// 중요도 비교

					if (j == size - 1) {
						count++;
					}
				}

				if (queue.isEmpty()) {
					System.out.println(++count);
					break;
				}

				if (poll == target && pos == 0) {
					System.out.println(count == 0 ? 1 : count);
					break;
				}


				pos--;

				if (pos < 0) {
					pos = size;
				}
			}
		}
	}

}
