package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10055_HASHMAT_THE_BRAVE_WARRIOR {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer( br.readLine());
			long r = Long.parseLong(st.nextToken());
			long n = Long.parseLong(st.nextToken());
			out.println(Math.abs(r-n));
			
			
		}
		out.flush();
		out.close();
	
		

	}

}
