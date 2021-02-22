
package reskillAssignmentOne;

/*import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandling {
    private String filePath= "C:\\Reskill\\salesrecords.txt";
    private  String line="";
    private  String[] csvValues;
    private List<String[]> orderlist = new ArrayList<>();
   
    public List readCSVFile (String filePath) throws FileNotFoundException,IOException{

        BufferedReader br;
        {
            try {
                br = new BufferedReader(new FileReader(filePath));
                while ((line = br.readLine()) != null) {
                    csvValues = line.split(",");
                    orderlist.add(csvValues);
                   // System.out.println(Arrays.toString(csvValues));
                }
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            } catch (IOException ioe) {
                throw new IOException();
            }
        }
    return orderlist;
    }

    /*
    public  void readAllDataAtOnce()
    {
        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Reskill\\salesrecords.txt"));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    System.out.println(Arrays.toString(nextLine));
                }

            }
        }catch (Exception e){
            System.out.println(e);

        }
    }

     */


}
