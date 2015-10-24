package integrationFonctions;

public class MethodesIntegrations {
	
	
	public static double integrationRectangleCos(double a, double b, int nbPas, 
													boolean amelioration, ) {
		function integrate (int xmin,intxmax,int pas ,int[] fx)
		if (a > b || nbPas <=0) {
			return 0;
		}
		
		double integral = 0.0;
		
		for(int i=0; i < nbPas; i++) {
			if (amelioration) {
			integral += rectangleAmeliore(Math.cos(a+( (double) i/nbPas)), 
										  Math.cos(a+( (double) (i+1)/nbPas)), 
										  (b-a)/nbPas ); 
			} else {
				integral += rectangle(Math.cos(a+( (double) i/nbPas)),
						  			  (b-a)/nbPas ); 
			}
		}
					
		return integral;
		
	}
	
	private static double rectangle(double fx, double h) {
		
		if (h<=0.0) {
			return -1.0;
		}
			
		return (h *fx);
	}
	
	private static double rectangleAmeliore(double fx, double fx1, double h) {
	
		if (h<=0.0) {
			return -1.0;
		}
			
		return (h *(fx +fx1))/2.0;
	}
	
	public static double integrationTrapeze(double a, double b, int nbPas) {
		
		if (a > b || nbPas <=0) {
			return 0;
		}
		
		double integral = 0.0;
		
		for(int i=0; i < nbPas; i++) {
			//TODO
		}
					
		return integral;
	}
	
	public static double integrationSimpson(double a, double b, int nbPas) {
		
		if (a > b || nbPas <=0) {
			return 0;
		}
		
		double integral = 0.0;
		
		for(int i=0; i < nbPas; i++) {
			//TODO
		}
					
		return integral;
	}
	
	
	public static void main(String[] args) {
		int nbPas;
		double a,b;
		
		
		nbPas = 100;
		a = 0.0;
		b = 1.0;
		
		
		System.out.println("COSINUS par la méthode du ");
		System.out.println("Rectangle : " + integrationRectangleCos(a, b, nbPas, false));
		System.out.println("Rectangle amélioré : " + integrationRectangleCos(a, b, nbPas, true));
		
	}
}
