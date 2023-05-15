public class Polynomial {
	private double[] coefficients;

        public Polynomial() {
        	coefficients = new double[1];
		coefficients[0] = 0;
    	}

        public Polynomial(double[] coefficients) {
        	this.coefficients = coefficients;
    	}

        public Polynomial add(Polynomial poly2) {
        	int degree = Math.max(this.coefficients.length, poly2.coefficients.length);
        	double[] answer = new double[degree];
        for (int i = 0; i < degree; i++) {
            	if (i < this.coefficients.length && i < poly2.coefficients.length) {
                answer[i] = this.coefficients[i] + poly2.coefficients[i];
            }
	        else if (i < this.coefficients.length) {
                answer[i] = this.coefficients[i];
            } 
		else{
                answer[i] = poly2.coefficients[i];
            }
        }
        return new Polynomial(answer);
    }

    public double evaluate(double x) {
        double answer = 0;
        for (int i = 0; i < coefficients.length; i++) {
            answer += coefficients[i] * Math.pow(x, i);
        }
        return answer;
    }

    public boolean hasRoot(double x) {
        return Math.abs(evaluate(x)) < 0.00000000001;
    }
}
