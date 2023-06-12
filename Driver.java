public class Driver {
	public static void main(String [] args) {
		double[] coefficients = {1,2,3};
		int[] powers = {1,2,3};
		Polynomial p = new Polynomial(coefficients, powers);
		for(int i = 0; i<5; i++){
			System.out.println(p.multiply(p).coefficients[i]);

		}
		for(int i = 0; i<5; i++){
                        System.out.println(p.multiply(p).exponents[i]);

                }
		System.out.println(p.multiply(p).exponents.length);
	}
}
