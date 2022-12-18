import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		Queue<Integer> queue = new LinkedList<>();
		int index = 0;

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			count++;
			if (count == K) {
				sb.append(poll).append(", ");
				count = 0;
			} else {
				queue.add(poll);
			}
		}

		sb.replace(sb.length() - 2, sb.length(), "");
		sb.append(">");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
