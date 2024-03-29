package module6;


public class QuadraticTheory implements Theory {
	
	double aa;
	double bb;
	double cc;
	
	public QuadraticTheory (double a, double b, double c) {
		aa = a; 
		bb = b; 
		cc = c;
	}
	
	// calculates the theoretical Y value for the Quadratic theory
	public double y(double x) {
		double y = (aa*x)*(aa*x)+bb*x+cc;
		return y;
	}

	// returns the name of the theory along with the equation used
	public String Name() {
		String theoryName = "QuadraticTheory : ";
		String a = Double.toString(aa);
		String b = Double.toString(bb);
		String c = Double.toString(cc);
		String fullLabel = theoryName+"y = "+a+"x^2 + "+b+"x + "+c;
		return fullLabel;
	}

}