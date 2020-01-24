package com.yash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(SpringBootAppApplication.class, args);
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final String string = br.readLine();
		int i = 0;
		final int length = string.length();
		System.out.print(getAllEvens(string));
		while(i < length) {
			++i;
			System.out.print(" ");
			System.out.print(getAllEvens(string.substring(i, length)));
		}
	}

	private static long getAllEvens(final String substring) {
		return substring.chars().mapToObj(e -> (char) e).filter(c -> c%2 == 0).count();
	}

}
