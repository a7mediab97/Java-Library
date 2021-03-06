package UVA;

import java.io.*;
import java.util.*;

public class UVA_539_THE_SETTLERS_OF_CATAN {
	
	static int  n ; 
	static boolean [][] adjMat  ; 
	static int max ;
	static int  dfs(int u) {
		
		
		int max = 0;
		for(int i = 0 ; i < n ; i++)
		{
			if(adjMat[u][i]) {
		
				adjMat[i][u]=adjMat[u][i] = false;
				
				max = Math.max(dfs(i)+1, max);

				adjMat[i][u]=adjMat[u][i] = true;
						
			}
		
		}
		return max ;
		
		
	}
	
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		while(true)
		{
			
			n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0 )break;
			
			adjMat = new boolean [n][n];
			
			while(m-->0)
			{
				int u = sc.nextInt();
				int v = sc.nextInt();
				adjMat[u][v] = adjMat[v][u]  = true ;  
			}
		
			max = Integer.MIN_VALUE;
			
			for(int i = 0 ; i < n ; i++)
				max = Math.max(max, dfs(i));
			out.println(max);
			
		}
		
		out.flush();
		out.close();
		
		

	}

	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}



}
