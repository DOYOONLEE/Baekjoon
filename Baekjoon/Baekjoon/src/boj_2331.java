import java.util.*;

public class boj_2331 {

	static int check[];

	public static void half(int num, int exp) {
		int size = (int) Math.log10(num) + 1; // 몇자리 수인지 체크
		int temp = 0;
		int sum = 0;

		for (int i = 1; i <= size; i++) {
			sum += Math.pow(num%10, exp);
			num /= 10;
		}
		check[sum]++;
		if (check[sum] > 2)
			return;
		half(sum,exp);
	}

	public static void main(String argc[]) {
		Scanner sc = new Scanner(System.in);
		check = new int[1001];
		int cnt = 0;
		int first = sc.nextInt();
		int exp = sc.nextInt();
		check[first]++;
		half(first, exp);
		for (int i = 1; i < 1001; i++) {
			if (check[i] == 1)
				cnt++;
		}
		System.out.println(cnt);
	}

}
