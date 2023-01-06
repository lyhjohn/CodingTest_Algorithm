import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Deque<int[]> deque = new ArrayDeque<>();
		int curNum = Integer.parseInt(st.nextToken());
		sb.append("1").append(" ");

		for (int i = 2; i <= N; i++) {
			deque.add(new int[]{i, Integer.parseInt(st.nextToken())});
		}

		while (!deque.isEmpty()) {
			if (curNum > 0) {
				for (int i = 1; i < curNum; i++) {
					deque.addLast(deque.pollFirst());
				}
				int[] curPosAndNum = deque.pollFirst();
				curNum = curPosAndNum[1];
				sb.append(curPosAndNum[0]).append(" ");
			} else {
				for (int i = 1; i < -curNum; i++) {
					deque.addFirst(deque.pollLast());
				}
				int[] curPosAndNum = deque.pollLast();
				curNum = curPosAndNum[1];
				sb.append(curPosAndNum[0]).append(" ");
			}
		}

		System.out.println(sb);
	}
}
