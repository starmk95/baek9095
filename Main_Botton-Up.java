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
            memo[1] = 1;
            System.out.println(add123(x));
        }
    }

    public static int add123(int num) {
        // Bottom-Up 방식
        // A[n] = 정수 n을 1, 2, 3의 합으로 만드는 방법의 수
        // 점화식 : A[n] = A[n-1] + A[n-2] + A[n-3]
        if (num > 1) { // 예외처리
            memo[2] = memo[0] + memo[1];
        }
        for (int i = 3; i < num + 1; i++) {
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        return memo[num];
    }
}
