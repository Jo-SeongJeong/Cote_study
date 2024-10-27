package Jo_Seongjeong.Study_설특집;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 1309 동물원
 *
 * 조건
 * 우리 n * 2 : 1 ~ 100000
 * 사자 가두기 조건
 * 가로, 세로로 붙어있을 수 없음
 * 사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수
 *
 * 문제에서 구하고자 하는 것
 * 사자 배치 경우의 수 % 9901
 *
 * 문제 해결 프로세스
 * dp
 * dp[0] = 1
 * dp[1] = 3
 * dp[2] = 7 = dp[1] + 4 = 3 + 3 + 1
 * dp[3] = 17 = dp[2] + 10 = 7 + 7 + 3
 * dp[4] = 41 = dp[3] + 24 = 17 + 17 + 7
 * dp[i] = dp[i-1] * 2 + dp[i-2]
 *
 * 고려한 시간 복잡도
 * 100000
 * */

public class BJ1309 { // 메모리 : 11916kb, 시간 : 72ms
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i < n+1; i++) {
            if(i == 1) dp[1] = 3;
            else {
                dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
            }
        }

        System.out.println(dp[n]);

    }
}
