/**
 * Fonctions de densité de probabilité
 * Loi normal 
 * Loi normal centrée réduite (loi de gausse)
 * Loi du khi deux
 * Loi gamma
 * @author colin peremarty
 *
 */
 
package integrationFonctions;
 
public class FonctionsProbabilites {
	
	/**
	* Densité de probabilité de la loi normal centrée réduite
	* @in valeur_X valeur de la variable aléatoire centrée réduite entre -1 et 1
	*
	* @out y double probabilité que X prenne la valeur valeur_X
	*/
	public static  double loi_de_gauss(double x)
	{
		//y = (1 / sqrt(2*PI()))*exp(-(1/2)*x^2)
		return (double) (double) (1.0 / Math.sqrt(2.0*Math.PI))*Math.exp(-(1.0/2.0)*Math.pow(x,2.0));
		//return (double) Math.exp((-1.0/2.0)*Math.pow(x,2.0));
		
	}
	
	/**
	* Densité de la loi normal 
	* @in moyenne l'espérance (moyenne) de la loi
	* @in phi l’écart type 
	* @in echantillonage echantillonage de la fonction
	* @in x_min limite inférieur de la fonction (ex - l'infini = -10^10)
	* @in x_max limite supérieur de la fonction (ex + l'infini = 10^10)
	*
	* @out f_de_x[][] tableau de double densité de la loi normal
	*/
	public static double[] loi_normal(double moyenne, double phi, double echantillonage, double x_min, double x_max )
	{
		//f_de_x est un tableau de 2 dimensions, contenant la valeur de x en premiere case et la valeur de y en deuxieme case
		//f_de_x est un tableau représentant la fonction de répartition de la variable x
		//taille = (x_max - x_min)/echantillonage +1
		int taille = (int) (((x_max - x_min)/echantillonage) +1.0);
		double f_de_x[]  = new double[taille];
		double valeur;
		double x;
		//Pour valeur allant de x_min a x_max par pas de echantillonage
		for (int i= 0 ; i < taille ; i ++){
			//valeur = i*echantillonage + x_min;
			valeur = (i*echantillonage) + x_min;
			//X = ( valeur - moyenne ) / phi ;
			x = ( valeur - moyenne ) / phi ;
			
			//f_de_x[i] = loi_de_gausse(X)
			f_de_x[i] = loi_de_gauss(x);
		}
		//Fin pour
		//retourne f_de_x
		return f_de_x;
	}

	/**
	* Densité de la loi normal 
	* @in k int le degrée de liberté et le nombre de variables aléatoires indépendentes suivant N(0,1) de la loi du khi-deux
	* @in echantillonage double echantillonage de la fonction
	* @in x_min double limite inférieur de la fonction (ex - l'infini = -10^10)
	* @in x_max double limite supérieur de la fonction (ex + l'infini = 10^10)
	*
	* @out f_de_x[] tableau de double densité  de la loi normal
	*/
	public static double[] loi_du_khi_deux(int k, double echantillonage, double x_min, double x_max )
	{
		//f_de_x est un tableau de 2 dimensions, contenant la valeur de x en premiere case et la valeur de y en deuxieme case
		//f_de_x est un tableau représentant la fonction de répartition de la variable x
		//taille = (x_max - x_min)/echantillonage +1
		//double f_de_x[taille]
		int taille = (int) (((x_max - x_min)/echantillonage) +1.0);
		double f_de_x[]  = new double[taille];
		
		//double gamma = fonction_gamma(k/2)
		double gamma = fonction_gamma(k/2);
		double x;
		//Pour valeur allant de x_min a x_max par pas de echantillonage
		for (int i = 0; i < taille ; i ++){
			//x = i*echantillonage + x_min;
			x = i*echantillonage + x_min;
			// f_de_x[i] = (1 / ((gamma)gamma*2^(n/2)))*x^((n/2)-1)*Math.exp(-x/2);
			f_de_x[i] = (1 / (gamma*Math.pow(2,(k/2))))*Math.pow(x,((k/2)-1))*Math.exp(-x/2);
		}
		
		//Fin pour
		return f_de_x;
	}
	
	/**
	* @in x
	* @out y int valeur de gamma correspondant à x
	*      -1 si x est negatif
	*/
	public static double fonction_gamma(int x)
	{
		if (x < 0) {
			return -1;
		}
		//La fonction gamma(x) peut etre approché par la fonction factoriel x-1 si x est un entier positif
		return factoriel(x-1);
	}

	/**
	* @in x
	* @out y int factoriel de x
	*/
	public static int factoriel( int x ) {
        // Il faut être sur que x est positif
		if (x < 0) {
           return -1;
		}       
		int factoriel = 1;
        // Boucle de calcul de la factoriel
		for(int i = 2; i <= x; i++)
		{			
            factoriel *= i;               
        }
		return factoriel;
    }
	
	
	/*
	Exemple de retour f_de_x
	pour f(x) = x^2
	pour x = [-2;1]
	avec un échantillonage de 0.5
	
	taille = (1 - -2)/0.5 +1= 7
	double f_de_x[taille]
	
	-2 =0*0.5+(-2)
	f_de_x[0]= 4
	
	-1.5 =1*0.5+(-2)
	f_de_x[1]= 2.25
	
	-1 =2*0.5+(-2)
	f_de_x[2]= 1
	
	-0.5 =3*0.5+(-2)
	f_de_x[3]= 0.25
	
	0 =4*0.5+(-2)
	f_de_x[4]= 0

	0.5 =5*0.5+(-2)
	f_de_x[5]= 0.25
	
	1 =6*0.5+(-2)
	f_de_x[6]= 1
	*/
}
