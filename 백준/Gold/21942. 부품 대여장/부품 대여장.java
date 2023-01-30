

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 입력된 정보 개수
		String L = st.nextToken(); // 대여기간

		int LDay = Integer.parseInt(L.substring(0, 3)); // 대여 일수
		int LHour = Integer.parseInt(L.substring(4, 6)); // 대여 시간
		int LMinutes = Integer.parseInt(L.substring(7)); // 대여 분

		int F = Integer.parseInt(st.nextToken()); // 벌금

		int limitTIme = LDay * 24 * 60 + LHour * 60 + LMinutes;

		Map<String, String> rentalMap = new HashMap<>();
		Map<String, Long> resultMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 입력된 정보
			String date = st.nextToken(); // 날짜
			String time = st.nextToken(); // 시간
			String part = st.nextToken(); // 사람, 부품
			String customer = st.nextToken();
			String id = part + "_" + customer;

			if (rentalMap.containsKey(id)) {
				String rtStartDt = rentalMap.get(id);
				String rtEndDt = date + " " + time;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				long startDt = format.parse(rtStartDt).getTime();
				long endDt = format.parse(rtEndDt).getTime();

				long difTime = (endDt - startDt) / (1000 * 60); // 분 단위의 시간차이

				if (difTime > limitTIme) {
					resultMap.put(customer, resultMap.getOrDefault(customer, 0L) + (difTime - limitTIme) * F);
				}
				rentalMap.remove(id);
			} else {
				rentalMap.put(id, date + " " + time);
			}
		}

		if (resultMap.isEmpty()) {
			System.out.println(-1);
			return;
		}

		List<String> list = new ArrayList<>(resultMap.keySet());
		list.sort(String::compareTo);

		for (String key : list) {
			sb.append(key).append(" ").append(resultMap.get(key)).append("\n");
		}

		System.out.println(sb.toString());
	}
}
