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
 
public class Fonctions {
	
	/**
	* Densité de la loi normal centrée réduite
	* @in valeur_X valeur de la variable aléatoire centrée réduite entre -1 et 1
	*
	* @out y float probabilité que X prenne la valeur valeur_X
	*/
	public float loi_de_gausse(valeur_X)
	{
		float y ;
		//y = (1 / sqrt(2*PI()))*exp(-(1/2)*x^2)
		y = (1 / Math.sqrt(2*Math.PI()))*Math.exp(-(1/2)*x*x);
		return y;
	}

	/**
	* Densité de la loi normal 
	* @in moyenne l'espérance (moyenne) de la loi
	* @in phi l’écart type 
	* @in echantillonage echantillonage de la fonction
	* @in x_min limite inférieur de la fonction (ex - l'infini = -10^10)
	* @in x_max limite supérieur de la fonction (ex + l'infini = 10^10)
	*
	* @out f_de_x[][] tableau de float densité de la loi normal
	*/
	public float[] loi_normal(float moyenne, float phi, float echantillonage, float x_min, float x_max )
	{
		//f_de_x est un tableau de 2 dimensions, contenant la valeur de x en premiere case et la valeur de y en deuxieme case
		//f_de_x est un tableau représentant la fonction de répartition de la variable x
		//taille = (x_max - x_min)/echantillonage +1
		int taille = (x_max - x_min)/echantillonage +1
		float f_de_x[taille]
		int i = 0 ;
		//Pour valeur allant de x_min a x_max par pas de echantillonage
		For (i= 0 ; i <= taille ; i ++){
			//valeur = i*echantillonage + x_min;
			valeur = i*echantillonage + x_min;
			//X = ( valeur - moyenne ) / phi ;
			X = ( valeur - moyenne ) / phi ;
			//f_de_x[i] = loi_de_gausse(X)
			f_de_x[i] = loi_de_gausse(X)
		}
		//Fin pour
		//retourne f_de_x
		return f_de_x
	}

	/**
	* Densité de la loi normal 
	* @in k int le degrée de liberté et le nombre de variables aléatoires indépendentes suivant N(0,1) de la loi du khi-deux
	* @in echantillonage float echantillonage de la fonction
	* @in x_min float limite inférieur de la fonction (ex - l'infini = -10^10)
	* @in x_max float limite supérieur de la fonction (ex + l'infini = 10^10)
	*
	* @out f_de_x[] tableau de float densité  de la loi normal
	*/
	public float[] loi_du_khi_deux(int k, float echantillonage, float x_min, float x_max )
	{
		//f_de_x est un tableau de 2 dimensions, contenant la valeur de x en premiere case et la valeur de y en deuxieme case
		//f_de_x est un tableau représentant la fonction de répartition de la variable x
		//taille = (x_max - x_min)/echantillonage +1
		//float f_de_x[taille]
		float f_de_x[taille];
		int i = 0 ;
		//float gamma = fonction_gamma(k/2)
		float gamma = fonction_gamma(k/2);
		int i = 0 ;
		//Pour valeur allant de x_min a x_max par pas de echantillonage
		For (i= 0 ; i <= taille ; i ++){
			//x = i*echantillonage + x_min;
			x = i*echantillonage + x_min;
			// f_de_x[i] = (1 / ((gamma)gamma*2^(n/2)))*x^((n/2)-1)*Math.exp(-x/2);
			f_de_x[i] = (1 / ((gamma)gamma*2^(n/2)))*x^((n/2)-1)*Math.exp(-x/2);
		//Fin pour
		return f_de_x
	}
	/**
	* @in x
	* @out y float valeur de gamma correspondant à x
	*/
	public float fonction_gamma(float x)
	{
		//La fonction gamma(x) peut etre approché par la fonction factoriel x-1 si x est un entier positif
		//float y
		y = factoriel(x - 1);
		return y
	}

	/**
	* @in x
	* @out y int factoriel de x
	*/
	public static int factoriel( int x ) {
        // Il faut être sur que x est positif
		if (x < 0) throw{
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
	float f_de_x[taille]
	
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
