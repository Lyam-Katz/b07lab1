import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class Driver {
	public static void main(String [] args) {
		double[] coefficients = {1,1,1};
		int[] powers = {1,2,3};
		Polynomial p = new Polynomial(coefficients, powers);
		System.out.println(p.multiply(p).evaluate(2));
		File input = new File("poly.txt");
		Polynomial p2 = new Polynomial(input);
		System.out.println(p2.multiply(p2).evaluate(2));
	}
}
