import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import controller.FileController;
import model.Magazine;

public class DB4OMagazineManager {
	
	public static ArrayList<Magazine> magazines;
	static ObjectContainer db;
	public static void main(String[] args) throws IOException {
		DB4OMagazineManager MM = new DB4OMagazineManager();
		FileController fileController = new FileController();
		
		fileController.readAuthorsFile("src/main/resources/autors.txt");
		fileController.readMagazinesFile("src/main/resources/revistes.txt");
		magazines = fileController.readArticlesFile("src/main/resources/articles.txt");
	
		try {
			File file = new File("src/main/resources/revistes.db");
			String fullPath = file.getAbsolutePath();
			db = Db4o.openFile(fullPath);
			// store magazines
			MM.addMagazines();
			// Querying magazines
			MM.listMagazines();
			
		} finally {
			// close database
			db.close();
		}
	}
	
	public void addMagazines() {
		System.out.println("Revistes llegides des del fitxer");
		for (int i = 0; i < magazines.size(); i++) {
			System.out.println(magazines.get(i).toString());
			db.store(magazines.get(i));
		}
	}
	
	public void listMagazines() {
		System.out.println("Revistes llegides de la base de dades");
		ObjectSet<Magazine> result = db.queryByExample(new Magazine());
		System.out.println(result.size());
		while (result.hasNext()) {
			System.out.println(result.next());
		}
	}
	
}