package UVA;

import java.io.*;
import java.util.*;

public class UVA_11078_OPEN_CREDIT_SYSTEM {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt(); 
		while(tests -->0)
		{
			
			int n = sc.nextInt();
			
			int [] a = new int [n];
			
			for(int i = 0 ; i< n ; i++)
				a[i] = sc.nextInt();
			
			int max = Integer.MIN_VALUE;
			
			int curr = a[0];
			for(int i = 1 ; i < n ; i++) {
				
				max = Math.max(max, curr - a[i]);
				curr = Math.max(curr, a[i]);	
			}
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
