public class Polynomial{
	private double[] coefficients;
	private int[] exponents;

	public Polynomial() {
    		coefficients = new double[0];
    		exponents = new int[0];
	}

	public Polynomial(double[] coefficients, int[] exponents) {
    		this.coefficients = coefficients;
    		this.exponents = exponents;
	}

	public Polynomial add(Polynomial poly2) {
    		int totalTerms = this.coefficients.length + poly2.coefficients.length;
    		double[] answerCoefficients = new double[totalTerms];
    		int[] answerExponents = new int[totalTerms];

    		int i = 0;
		int j = 0;
		int k = 0;

    		while (i < this.coefficients.length && j < poly2.coefficients.length) {
        		if (this.exponents[i] < poly2.exponents[j]) {
            			answerCoefficients[k] = this.coefficients[i];
            			answerExponents[k] = this.exponents[i];
            			i++;
        		}
			else if (this.exponents[i] > poly2.exponents[j]) {
            			answerCoefficients[k] = poly2.coefficients[j];
            			answerExponents[k] = poly2.exponents[j];
            			j++;
        		}
			else {
            			answerCoefficients[k] = this.coefficients[i] + poly2.coefficients[j];
            			answerExponents[k] = this.exponents[i];
            			i++;
            			j++;
        		}
        		k++;
    		}

    		while (i < this.coefficients.length) {
        		answerCoefficients[k] = this.coefficients[i];
        		answerExponents[k] = this.exponents[i];
        		i++;
        		k++;
    		}

    		while (j < poly2.coefficients.length) {
        		answerCoefficients[k] = poly2.coefficients[j];
       		 	answerExponents[k] = poly2.exponents[j];
        		j++;
        		k++;
    		}

   		while (k > 0 && answerCoefficients[k - 1] == 0) {
       			k--;
    		}

   		double[] newCoefficients = new double[k];
    		int[] newExponents = new int[k];
    		for (int m = 0; m < k; m++) {
        		newCoefficients[m] = answerCoefficients[m];
        		newExponents[m] = answerExponents[m];
    		}

    		return new Polynomial(newCoefficients, newExponents);
	}

	public double evaluate(double x) {
    		double answer = 0;
    		for (int i = 0; i < coefficients.length; i++) {
        		answer += coefficients[i] * Math.pow(x, exponents[i]);
    		}
    		return answer;
	}

	public boolean hasRoot(double x) {
    		return Math.abs(evaluate(x)) < 0.00000000001;
	}

	public Polynomial multiply(Polynomial poly2) {
    		int totalTerms = this.coefficients.length * poly2.coefficients.length;
    		double[] answerCoefficients = new double[totalTerms];
    		int[] answerExponents = new int[totalTerms];

    		int k = 0;

    		for (int i = 0; i < this.coefficients.length; i++) {
        		for (int j = 0; j < poly2.coefficients.length; j++) {
            			double product = this.coefficients[i] * poly2.coefficients[j];
            			int exponentSum = this.exponents[i] + poly2.exponents[j];

            			boolean found = false;
            			for (int m = 0; m < k; m++) {
                			if (answerExponents[m] == exponentSum) {
                    				answerCoefficients[m] += product;
                    				found = true;
                    				break;
                			}
            			}

            			if (!found) {
                			answerCoefficients[k] = product;
                			answerExponents[k] = exponentSum;
                			k++;
            			}
        		}
    		}

    		for (int i = 0; i < k - 1; i++) {
        		for (int j = 0; j < k - i - 1; j++) {
            			if (answerExponents[j] > answerExponents[j + 1]) {
                			double tempCoeff = answerCoefficients[j];
                			answerCoefficients[j] = answerCoefficients[j + 1];
                			answerCoefficients[j + 1] = tempCoeff;

                			int tempExp = answerExponents[j];
                			answerExponents[j] = answerExponents[j + 1];
                			answerExponents[j + 1] = tempExp;
            			}
        		}
    		}

    		int numTerms = 0;
    		for (int i = 0; i < k; i++) {
        		if (answerCoefficients[i] != 0) {
            			numTerms++;
        		}
    		}

    		double[] newCoefficients = new double[numTerms];
    		int[] newExponents = new int[numTerms];

    		int newIndex = 0;
    		for (int i = 0; i < k; i++) {
        		if (answerCoefficients[i] != 0) {
            			newCoefficients[newIndex] = answerCoefficients[i];
            			newExponents[newIndex] = answerExponents[i];
            			newIndex++;
        		}
    		}

    		return new Polynomial(newCoefficients, newExponents);
	}
}
