package cz.ods.pokus;


import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;

/**
 * Created by karbo on 3.5.16.
 */
public class Main {
    // /home/karbo/IdeaProjects/pokusODS/pokus/src/main/resources/tableFile.ods

    public static void main(String[] args) {
        System.out.println("Hello! Main up and running!");

        // Load the file.
        File file = new File(Main.class.getClassLoader().getResource("tableFile.ods").getFile());
        String term = "ladi";

        try{
            SearchInSpreadSheet spreadSheet = new SearchInSpreadSheet(SpreadSheet.createFromFile(file), term);

        } catch(Throwable ex){
            System.out.println(ex.toString());
        }



    }




}
