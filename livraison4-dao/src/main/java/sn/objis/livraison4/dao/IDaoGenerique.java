package sn.objis.livraison4.dao;

import java.util.List;

/**
 * Date Juillet 23-2018 # L'interface IDaoGenerique c'est une interface
 * generique qui contient nos m�thodes g�n�rique.
 * 
 * @author DIOUF Mamadou
 *
 * @param <X>
 *            Parametre de type generique
 */
public interface IDaoGenerique<X> {
	/**
	 * La methode 'create(X x)' generique a pour but de recevoir un objet et de
	 * l'ajouer dans une base de donnees relationnelle.
	 * 
	 * @param x
	 *            Parametre de type generique
	 */
	public void create(X x);

	/**
	 * La methode 'read()' generique a pour but lire des donnees dans une base de
	 * donnees relationnelle, creer une liste et l'ajouter dans cette derniere.
	 * 
	 * @return List (retourne une liste d'objet)
	 */
	public List<X> read();

	/**
	 * La methode 'update()' generique a pour but de mettre � jour les donnees d'une
	 * ligne pr�cise dans une base de donnees relationnelle.
	 * 
	 * @param x
	 *            Parametre de type g�n�rique
	 */
	public void update(X x);

	/**
	 * La methode 'delete(X x)' generique a pour but de supprimer les donnees d'une
	 * ligne precise dans une base de donnees relationnelle.
	 * 
	 * @param x
	 *            Parametre de type generique
	 */
	public void delete(X x);

	/**
	 * La methode 'findByCode(String code)' generique a pour but de rechercher les
	 * donnees dans une base de donnees relationnelle.
	 * 
	 * @param code
	 *            Parametre que re�oit notre methode 'findByCode'
	 * @return X (Type generique) Retourne l'objet trouve
	 */
	public X findByCode(String code);
}
