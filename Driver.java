import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class Driver {
	public static void main(String [] args) {
		Polynomial p0 = new Polynomial();
		System.out.println(p0.convertToString());
		p0.saveToFile("0.txt");
		File input0 = new File("0.txt");
		Polynomial p0prime = new Polynomial(input0);
		System.out.println(p0prime.convertToString());
		System.out.println(p0prime.add(p0).convertToString());
		double[] coefficients = {1,1,1};
		int[] powers = {1,2,3};
		Polynomial p = new Polynomial(coefficients, powers);
		System.out.println(p.multiply(p).add(p0).evaluate(2));
		System.out.println(p.multiply(p0).evaluate(7864.432));
		File input = new File("poly.txt");
		Polynomial p2 = new Polynomial(input);
		System.out.println(p2.convertToString());
		System.out.println(p2.multiply(p2).evaluate(2));
		p.multiply(p).saveToFile("poly2.txt");
		File input2 = new File("poly2.txt");
		Polynomial p3 = new Polynomial(input2);
		System.out.println(p3.convertToString());
		System.out.println(p3.evaluate(2));
		System.out.println(p3.add(p3).convertToString());
		System.out.println(p2.convertToString());
		System.out.println(p2.add(p3).convertToString());
		System.out.println(p.hasRoot(0));
		System.out.println(p.hasRoot(0.0001));

	}
}
