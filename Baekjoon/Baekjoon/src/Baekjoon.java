// boj.kr/10451

import java.util.*;

public class Baekjoon {

	static int arr[];
	static boolean visited[];
	static int num,cnt;
	
	static void dfs(int cur) {
		if(visited[cur]) {
			cnt++;
			return;
		}
		visited[cur]=true;
		dfs(arr[cur]);
	}
	public static void main(String argc[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<= T;tc++) {
			cnt=0;
			num = sc.nextInt();
			arr = new int[num+1];
			visited = new boolean[num+1];
			
			for(int i=1;i<=num;i++)
				arr[i] = sc.nextInt();
			
			for(int i=1;i<=num;i++) {
				if(!visited[i]) 
					dfs(i);
			}
			System.out.println(cnt);
		}
	}
}
