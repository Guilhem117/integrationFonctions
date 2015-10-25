package integrationFonctions;

public class MethodesIntegrations {
    
    
    public static double integrationRectangleSup(double xmin, double xmax, double[] fx) {
        if (xmin > xmax || fx.length == 0) {
            return 0;
        }
        
        double integral = 0.0;
        double h = (xmax-xmin)/(fx.length-1);
            for(int i=0; i < fx.length; i++) {
                integral += (h *fx[i]);
        }
                    
        return integral;
        
    }

    private static double integrationRectangleAmeliore(double xmin, double xmax, double[] fx) {
        
        if (xmin > xmax || fx.length == 0) {
            return 0;
        }
        
        double integral = 0.0;
        double h = (xmax-xmin)/(fx.length-1);
            for(int i=0; i < fx.length-1; i++) {
                integral +=  (h *(fx[i] +fx[i+1]))/2.0;
        }
                    
        return integral;
            
    }
    
    public static double integrationTrapeze(double xmin, double xmax, double[] fx) {
        if (xmin > xmax || fx.length == 0) {
            return 0;
        }
        
        double integral = 0.0;
//        double h = (xmax-xmin)/(fx.length-1);
//            for(int i=0; i < fx.length; i++) {
//                integral += (h *fx[i]);
//        }
        //TODO
                    
        return integral;
        
    }
    public static double integrationSimpson(double xmin, double xmax, double[] fx) {
        if (xmin > xmax || fx.length == 0) {
            return 0;
        }
        
        double integral = 0.0;
//        double h = (xmax-xmin)/(fx.length-1);
//            for(int i=0; i < fx.length; i++) {
//                integral += (h *fx[i]);
//        }
        //TODO
                    
        return integral;
        
    }
    
    public static void main(String[] args) {
        
        //TEST de performance, précision TODO
        int nbPas;
        double a,b;
        double fx[];
        
        nbPas = 100;
        a = 0.0;
        b = 1.0;
        
        //Génération des fx pour la fonction f(x)=x
        fx = new double[nbPas+1];
        for(int i=0; i < (nbPas+1); i++) {
            fx[i] = a + ((double) i) /nbPas;  
        }
        
        
        System.out.println("Intégration de f(x) = x de " + a + " à " + b + " par la méthode du ");
        System.out.println("Rectangle : " + integrationRectangleSup(a, b, fx));
        System.out.println("Rectangle amélioré : " + integrationRectangleAmeliore(a, b, fx));
        
        
        
        //Génération des fx pour la fonction f(x)=x
        fx = new double[nbPas+1];
        for(int i=0; i < (nbPas+1); i++) {
            fx[i] = Math.cos(a + ((double) i) /nbPas);  
        }
        System.out.println("\nIntégration de f(x) = cos(x) de " + a + " à " + b + " par la méthode du ");
        System.out.println("Rectangle : " + integrationRectangleSup(a, b, fx));
        System.out.println("Rectangle amélioré : " + integrationRectangleAmeliore(a, b, fx));
        
        
        
    }
}
