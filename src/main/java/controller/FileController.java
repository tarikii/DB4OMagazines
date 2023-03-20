package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import model.*;

/**
 * @author Joan Anton Pérez
 * @version FileAccessorv01
 * @since 29/12/2015
 */

public class FileController {

	ArrayList<Author> authorsList = new ArrayList();
	ArrayList<Magazine> llistaRevistes = new ArrayList();

	public FileController() {
	}

	/**
	 * @param filename
	 *            Aquest String correspon amb l'arxiu on s'emmagatzemen les
	 *            dades de les instancies d'Autor
	 * @throws IOException
	 * @see Author
	 *
	 *      <dt><b>Preconditions:</b>
	 *      <dd>
	 *      filename<>nil </br> llistaAutors == nil
	 *      <dt><b>Postconditions:</b>
	 *      <dd>
	 *      llistaAutors<>nil
	 */

	public void readAuthorsFile(String filename) throws IOException {
		int id;
		String name, year, country;
		boolean active;

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			id = Integer.parseInt(str.nextToken());
			name = str.nextToken();
			year = str.nextToken();
			country = str.nextToken();
			active = Boolean.parseBoolean(str.nextToken());
			// System.out.println(id + name + country + year + active);
			authorsList.add(new Author(id, name, country, year, active));

		}
		br.close();

	}

	public void printAutors() {
		for (int i = 0; i < authorsList.size(); i++) {
			System.out.println(authorsList.get(i).toString());
		}
	}

	public void printRevistes() {
		// TODO
		//
		for (int i = 0; i < llistaRevistes.size(); i++) {
			System.out.println(llistaRevistes.get(i).toString());
		}
	}

	/**
	 * 
	 * @param filename
	 *            Aquest String correspon amb l'arxiu on s'emmagatzemen les
	 *            dades de les instancies de Revista
	 * @throws IOException
	 * 
	 *             <dt><b>Preconditions:</b>
	 *             <dd>
	 *             filename<>nil </br> llistaRevistes == nil
	 *             <dt><b>Postconditions:</b>
	 *             <dd>
	 *             llistaRevistes<>nil
	 */

	public void readMagazinesFile(String filename) throws IOException {
		int id;
		String titol;
		Date date;
		DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			id = Integer.parseInt(str.nextToken());
			titol = str.nextToken();
			try {
				date = dateformat.parse(str.nextToken());
				// TODO
				// Cal afegir un objecte Magazine a la llista
				llistaRevistes.add(new Magazine(id, titol, date));

			} catch (ParseException e) {
				System.err.println(" errada format data al fitxer");
				e.printStackTrace();
			}

		}
		br.close();

	}

	/**
	 * @param filename
	 *            Aquest String correspon amb l'arxiu on s'emmagatzemen les
	 *            dades de les isntancies de Revista
	 * @return ArrayList d'objectes Revista, amb els seus articles i la
	 *         informació de l'autor
	 * @throws IOException
	 * 
	 *             <dt><b>Preconditions:</b>
	 *             <dd>
	 *             filename<>nil </br> llistaRevistes<>nil </br>
	 *             llistaRevistes.getRevista(i).getArticles()== nil</br>
	 *             <dt><b>Postconditions:</b>
	 *             <dd>
	 *             llistaRevistes.getRevistes()<>nil</br>
	 *             llistaRevistes.getRevista(i).getArticles()<>nil</br>
	 *             llistaRevistes.getRevista(i).getArticle(j)<>nil</br>
	 *             llistaRevistes
	 *             .getRevista(i).getArticle(j).getAutor()<>nil</br>
	 * 
	 */
	public ArrayList<Magazine> readArticlesFile(String filename)
			throws IOException {
		int idArticle, idRevista, idAutor;
		String titol;
		Date data_creacio;
		boolean publicable;
		DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			idArticle = Integer.parseInt(str.nextToken());
			idRevista = Integer.parseInt(str.nextToken());
			idAutor = Integer.parseInt(str.nextToken());
			titol = str.nextToken();
			try {
				data_creacio = dateformat.parse(str.nextToken());
				publicable = Boolean.parseBoolean(str.nextToken());
				// System.out.println(idArticle + ", idrev" + idRevista + ", idaut" + idAutor + ", titol " + titol 	+ data_creacio);
				Article a = new Article(idArticle, titol, data_creacio, publicable,
						authorsList.get(idAutor-1));
				//llistaAutors.get(idAutor-1).addArticle(a);
				llistaRevistes.get(idRevista-1).addArticle(a);
				/**
				System.out.println(llistaRevistes.get(idRevista-1).toString());
				for (int i = 0; i < llistaRevistes.get(idRevista-1).getArticles()
						.size(); i++) {
					
					System.out.println(llistaRevistes.get(idRevista-1)
							.getArticle(i).toString());
					System.out.println(llistaRevistes.get(idRevista-1).getArticle(i).getAutor().toString());

				}
				**/
				// llistaAutors.add(new Autor(id, name, country, year, active));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}

		}
		br.close();
		

		return llistaRevistes;
		// TODO
	}

}
