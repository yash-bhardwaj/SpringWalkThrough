package com.yash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(SpringBootAppApplication.class, args);
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		final String line = br.readLine();
		String[] A = line.split(" ");
		int i = Integer.parseInt(br.readLine());
		while(i > 0) {
			--i;
			final String s = br.readLine();
			printOutput(s, A);
		}
	}

	private static void printOutput(final String query, final String[] A) {
		final String[] B = query.split(" ");
		int l = Integer.parseInt(B[0]);
		final int r = Integer.parseInt(B[1]);
		final int X = Integer.parseInt(B[2]);

		int xor;
		final int[] range = new int[r];
		int temp = Integer.MAX_VALUE;
		int Z = 0;
		for (int i = l; i <= r; i++) {
			Z = Integer.parseInt(A[i-1]);
			range[i-1] = Z;
			xor = Z ^ X;
			if (temp > xor) temp = xor;
		}
		int count = 0;
		for (int i=0; i<range.length;i++) {
			if (temp < Z && range[i] == Z) count++;
		}
		System.out.println(Z + " " + count);
	}
}
