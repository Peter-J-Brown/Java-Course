package module3;

public class FallingParticle {
	
	public double m;
	public double d;
	public double t;
	public double v;
	public double z;
	public final double g = 9.81;
	public double h;
	//public double h = 5;
	
	
	public FallingParticle (double x, double y, double h) throws Exception {
		m = x; 
		d = y;
		if (x < 0) {
			throw new Exception("You cannot have a negative mass particle");
		}
		if (x == 0) {
			throw new Exception("You cannot have a zero mass particle");
		}
		if( d < 0) {
			throw new Exception("You cannot have give the particle negative drag");
		}
		if (h < 0) {
			throw new Exception("You cannot set a negative particle height, h");
		}
	}
	
	/*
	public final double setH(double h) {
		return h;
	}
	
	public double getZ() {
		return z;
	}
	
	public double setV(double v) {
		this.v = v;
		return v;
	}
	
	public double getV() {
		return v;
	}
	
	public double getT() {
		return t;
	}
	*/
	
	/*
	
	/*
	public void doTimeStep(double deltaT) {
		double a = v*v*d/m-g;
		double dv = a*deltaT;
		double v1 = v+dv;
		double dz = v1*deltaT;
		double z1 = z+dz;
		z=z1;
		v=v1;
		t = t+deltaT;
		System.out.println("The time is: "+ t +"seconds");
		System.out.println("The velocity is: "+ v +"m/s ");		
		System.out.println("z is: "+ z +"m ");	
	}
	*/
	
		
	
	// the drop method executes a while loop that calculates the change in velocity per time step and uses that to
	// update the position and time variables
	public void drop(double deltaT) throws Exception{
		if (deltaT <= 0) {
			throw new Exception("The time step cannot be negative");
		}
		double z = h;
		double v = 0;
		t=0; 
		while (z>=0) {
		double a = (v*v*d/m)-g;
		double dv = a*deltaT;
		double v1 = v+dv;
		double dz = v1*deltaT;
		double z1 = z+dz;
		z=z1;
		v=v1;
		t = t+deltaT;
		}
		System.out.println("The time taken to reach the bottom was: "+ t +" seconds");
		System.out.println("The final velocity was: "+ v +" m/s ");		
	}
	
	public static void main(String[] args) {
		
		// sets the initial values for mass and drag
		
		//double m = 4.3; 
		//double d = 2.4;
		//FallingParticle newparticle = new FallingParticle (m,d);
		
		System.out.println("Testing how particle drop method responds to a negative mass");
		try {
			double m = -2;
			double d = 3;
			double h = 2;
			FallingParticle newparticle = new FallingParticle (m,d, h);
			newparticle.drop(0.001);
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		System.out.println("Testing how particle drop method responds to a negative drag");
		try {
			double m = 2;
			double d = -3;
			double h = 2;
			FallingParticle newparticle = new FallingParticle (m,d, h);
			newparticle.drop(0.001);
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		System.out.println("Testing how particle drop method responds to a negative particle height");
		try {
			double m = 2;
			double d = 3;
			double h = -2;
			FallingParticle newparticle = new FallingParticle (m,d, h);
			newparticle.drop(0.002);
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		
		
		
		
		
		
		/*
		double m = 2;
		double d = 3;
		double h = 2;
		try {
		FallingParticle newparticle = new FallingParticle(m,d,h);
		newparticle.drop(0.5);
		newparticle.drop(0.1);
		newparticle.drop(0.01);
		newparticle.drop(0.001);
		newparticle.drop(0.0001);
		}
		catch(Exception e) {
		;
		}
		
		
		System.out.println("The first run of the simulation with deltaT = 0.5 is inaccurate because of the way dv is calculated");
		System.out.println("We calculate dv as a*deltaT and so this is only accurate when deltaT is infinitesimally small");
		System.out.println("Because acceleration is the change in displacement per second per second, if we only recalculate a every 0.5 seconds this clearly leads to a bad approximation");
		System.out.println("As deltaT gets smaller and tends towards zero, the time taken to reach the bottom of the container and the final velocity reached also tend to a single value");
		System.out.println("Theoretically only deltaT = 0 gives the true final values for velocity and time however as can be seen from the results the difference between deltaT = 0.0001 and deltaT = 0.00001 is less than 0.0001 seconds and so the difference is insignificant"); 
		
		*/
		
	}

}