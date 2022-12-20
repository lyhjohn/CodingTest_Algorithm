import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		int sign = 1;

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while (queue.size() > 1) {
			Integer poll = queue.poll();

			if (sign == -1) {
				queue.offer(poll);
			}

			sign *= -1;
		}

		System.out.println(queue.poll());
	}

}
