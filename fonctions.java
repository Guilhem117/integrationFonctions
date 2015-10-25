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
		//float y ;
		//y = (1 / racine(2*math.factorial()))*exp(-(1/2)*x^2)
		//retourne y
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
		//float f_de_x[taille][2]
		//int i = 0 ;
		//Pour valeur allant de x_min a x_max par pas de echantillonage
			//X = ( valeur - moyenne ) / phi ;
			//f_de_x[i][0] = valeur
			//f_de_x[i][1] = loi_de_gausse(X)
			//i++;
		//Fin pour
		//retourne f_de_x
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
		//float f_de_x[taille][2]
		
		//float gamma = fonction_gamma(k/2)
		//int i = 0 ;
		//Pour x allant de x_min a x_max par pas de echantillonage
			//f_de_x[i][0] = valeur
			//f_de_x[i][1] = (1 / ())*
		//Fin pour
		//retourne f_de_x
	}
	/**
	* @in x
	* @out y float valeur de gamma correspondant à x
	*/
	public float fonction_gamma(float x)
	{
		//La fonction gamma(x) peut etre approché par la fonction factoriel x-1 si x est un entier positif
		//float y
		//y = math.factorial(x - 1)
		//sinon, et dans tous les cas :
		//y = math.intégral(t^(x-1)*math.exponentiel(-t),t,0,10^10)
		
		//retourne y
	}

		/*
	Exemple de retour f_de_x
	pour f(x) = x^2
	pour x = [-2;1]
	avec un échantillonage de 0.5
	
	taille = (1 - -2)/0.5 +1= 7
	float f_de_x[taille][2]
	
	f_de_x[0][0]= -2
	f_de_x[0][1]= 4
	
	f_de_x[1][0]= -1.5
	f_de_x[1][1]= 2.25
	
	f_de_x[2][0]= -1
	f_de_x[2][1]= 1
	
	f_de_x[3][0]= -0.5
	f_de_x[3][1]= 0.25
	
	f_de_x[4][0]= 0
	f_de_x[4][1]= 0
	
	f_de_x[5][0]= -0.5
	f_de_x[5][1]= 0.25
	
	f_de_x[6][0]= 1
	f_de_x[6][1]= 1
	*/
}
