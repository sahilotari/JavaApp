package example.controller;

import java.io.FileWriter;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/sayHello")
	public String sayHello() {

		double x = 1d;
		for (int i = 0; i < 1000000; i++) {
			// some logic to consume more cpu
			x += Math.sqrt(x);
		}
		int max = 5;
		int min = 1;
		int range = max - min + 1;

		Scanner sc = new Scanner(System.in);
		// long start = System.currentTimeMillis();
		// long end = start + 180 * 1000;

		try (FileWriter file = new FileWriter("/home/logfile.logs", true);) {
			// while (System.currentTimeMillis() < end) {
			while (true) {
				String s;
				int rand = (int) (Math.random() * range) + min;
				if (rand == 3) {
					s = "ERROR: Input 3 not expected..\n";
					System.out.println(s);
				} else {
					s = "Program runnning OK...\n";
					System.out.println(s);
				}
				file.write(s);
				file.flush();
				Thread.sleep(2000);
				// }
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		sc.close();
		return "Hello!";
	}

}
