package cz.ods.pokus;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * Created by karbo on 4.5.16.
 */
public class SearchInSpreadSheet {
    private SpreadSheet spreadSheet;

    private void printSheet(Sheet sheet){
        int cols = sheet.getColumnCount();
        int rows = sheet.getRowCount();

        System.out.println("List: " + sheet.getName());

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                System.out.print(" " + sheet.getValueAt(col, row).toString() );
            }
            System.out.println(" ");
        }

    }

    private void printRow(int row, Sheet sheet){
        int cols = sheet.getColumnCount();
        String[] line = new String[cols + 1];

        line[0] = sheet.getName();
        for (int i = 0; i < cols ; i++) {
            line[i+1]= sheet.getValueAt(i, row).toString();
        }

        //print row
        System.out.print("line = ");
        for (String cell : line) {
            System.out.print(cell + ", ");
        }
        System.out.println(" ");

    }

    private void searchSheet(Sheet sheet, String term){
        int cols = sheet.getColumnCount();
        int rows = sheet.getRowCount();

        for (int row = 1; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (sheet.getValueAt(col, row).toString().contains(term)) {
                    printRow(row, sheet);
                }
            }
        }

    }


    public SearchInSpreadSheet(SpreadSheet spreadSheet, String term) {
        this.spreadSheet = spreadSheet;
        int numSheets = spreadSheet.getSheetCount();

        //print all sheets
        for (int i = 0; i < numSheets; i++){
            printSheet(spreadSheet.getSheet(i));
            System.out.println("---");
        }

        System.out.println("searching for < " + term + " >");
        //Search in all Sheets
        for (int i = 0; i < numSheets; i++){
            searchSheet(spreadSheet.getSheet(i), term);
        }


    }
}
