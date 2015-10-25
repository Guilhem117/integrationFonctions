/**
 * Intégration de fonctions - 23/10/2015
 * @author SERENE Guilhem
 */
package integrationFonctions;

/** 
 * Classe implémentant les différentes méthodes integrations
 */
public class MethodesIntegrations {
    
    
    /**
     * Intégration d'une fonction par la méthode des rectangles
     * 				Je prends les rectangles au dessus de f(x)
     * @param xmin - Borne inférieure de l'intervalle 
     * @param xmax - Borne supérieure de l'intervalle
     * @param fx - Images de X
     * @return Résultat de l'intégration de fx entre a et b
     * 		   -1.0 xmin> xmax ou si fx est vide
     */
    public static double integrationRectangleSup(double xmin, double xmax, double[] fx) {
    	
    	//Verifcation des paramètres d'entrées
        if (xmin > xmax || fx.length == 0) {
            return -1.0;
        }
        
        double integral = 0.0;
        double h = (xmax-xmin)/(fx.length);
        for(int i=0; i < fx.length; i++) {
            integral += (h *fx[i]);
        }
                    
        return integral;
        
    }

    /**
     * Intégration d'une fonction par la méthode des rectangles
     * 				Je prends le milieu des rectangles inférieurs et supérieurs
     * @param xmin - Borne inférieure de l'intervalle 
     * @param xmax - Borne supérieure de l'intervalle
     * @param fx - Images de X
     * @return Résultat de l'intégration de fx entre a et b
     * 		   -1.0 xmin> xmax ou si fx est vide
     */
    public static double integrationRectangleAmeliore(double xmin, double xmax, double[] fx) {
    	
    	//Verifcation des paramètres d'entrées
        if (xmin > xmax || fx.length == 0) {
            return -1.0;
        }
        
        double integral = 0.0;
        double h = (xmax-xmin)/(fx.length-1);
        for(int i=0; i < fx.length-1; i++) {
            integral +=  (h *(fx[i] +fx[i+1]))/2.0;
        }
                    
        return integral;
            
    }
    
    /**
     * Intégration d'une fonction par la méthode des trapèzes
     * @param xmin - Borne inférieure de l'intervalle 
     * @param xmax - Borne supérieure de l'intervalle
     * @param fx - Images de X
     * @return Résultat de l'intégration de fx entre a et b
     * 		   -1.0 xmin> xmax ou si fx est vide
     */
    public static double integrationTrapeze(double xmin, double xmax, double[] fx) {  
    	
    	//Verifcation des paramètres d'entrées
        if (xmin > xmax || fx.length == 0) {
            return -1.0;
        }
        
        double h = (xmax-xmin)/(fx.length-1);
        double integral = h*(fx[0] + fx[(fx.length-1)])/2.0;
        for(int i=1; i < fx.length-1; i++) {
                integral += (h *fx[i]);
      }
                    
        return integral;
        
    }
    
    /**
     * Intégration d'une fonction par la méthode de simpson
     * @param xmin - Borne inférieure de l'intervalle 
     * @param xmax - Borne supérieure de l'intervalle
     * @param fx - Images de X
     * @return Résultat de l'intégration de fx entre a et b
     * 		   -1.0 xmin> xmax ou si fx est vide
     */
    public static double integrationSimpson(double xmin, double xmax, double[] fx) {
    	
    	//Verifcation des paramètres d'entrées
        if (xmin > xmax || fx.length == 0) {
            return -1.0;
        }
                            
        return (2*integrationRectangleAmeliore(xmin, xmax, fx) 
        		+ integrationTrapeze(xmin, xmax, fx))/3.0;
        
    }
    
   
}
