
package reskillAssignmentOne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandling {
    //private String filePath= "C:\\Reskill\\salesrecords.txt";
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
}
