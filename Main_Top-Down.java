import java.util.Scanner;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for (int i=0;i<cnt; i++) {
            int x = sc.nextInt();
            memo = new int[x+1];
            memo[0] = 1;
            System.out.println(add123(x));
        }
    }

    public static int add123(int num) {
        // Top-Down 방식
        // A[n] = 정수 n을 1, 2, 3의 합으로 만드는 방법의 수
        // 점화식 : A[n] = A[n-1] + A[n-2] + A[n-3]
        if (num < 3) { // 예외처리
            if (num == 1) {
                memo[1] = 1;
                return memo[1];
            } else if (num == 2) {
                memo[1] = 1;
                memo[2] = 2;
                return memo[2];
            }
        }
        if (memo[num-1] == 0) { // 부분 문제를 푼적이 없다면
            memo[num-1] = add123(num-1);
        }
        if (memo[num-2] == 0) { // 부분 문제를 푼적이 없다면
            memo[num-2] = add123(num-2);
        }
        if (memo[num-3] == 0) { // 부분 문제를 푼적이 없다면
            memo[num-3] = add123(num-3);
        }
        memo[num] = memo[num-1] + memo[num-2] + memo[num-3];
        return memo[num];
    }
}
