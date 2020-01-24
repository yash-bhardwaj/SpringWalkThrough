package com.yash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(SpringBootAppApplication.class, args);
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		while(i > 0) {
			--i;
			final String line = br.readLine();
			System.out.println(countNoVowelChars(line) + "/" + line.length());
		}
	}

	private static long countNoVowelChars(final String line) {
		return line
				.replace("www.", "")
				.replace("a", "")
				.replace("e", "")
				.replace("i", "")
				.replace("o", "")
				.replace("u", "").length() + 1;
	}

}
