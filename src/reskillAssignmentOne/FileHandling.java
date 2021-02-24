package reskillAssignmentOne;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface FileHandling {
    List readFile(String filePath) throws FileNotFoundException, IOException, ParseException;

}
