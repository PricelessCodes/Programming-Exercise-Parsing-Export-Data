
/**
 * Write a description of ParsingExportData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParsingExportData {
    public String countryInfo(CSVParser parser, String country) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            String countryRecord = record.get("Country");
            //Check if it contains exportOfInterest
            if (countryRecord.equalsIgnoreCase(country)) {
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                return (countryRecord + ":" + export + ":" + value);
            }
        }
        return "Not Found";
    }
    
    public void countryInfo(CSVParser parser, String exportItem1, String exportItem2) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Check if it contains exportOfInterest
            String export = record.get("Exports");
            if (export.contains(exportItem1) && export.contains(exportItem2)) {
                String countryRecord = record.get("Country");
                System.out.println(countryRecord);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        //for each row in the CSV File
        int count = 0; 
        for (CSVRecord record : parser) {
            //Check if it contains exportOfInterest
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Check if it contains exportOfInterest
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                String countryRecord = record.get("Country");
                System.out.println(countryRecord + " " + value);
            }
        }
    }

    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Nauru"));
        //countryInfo(parser, "cotton", "flowers");
        //parser = fr.getCSVParser();
        //System.out.println(numberOfExporters(parser, "cocoa"));
        bigExporters(parser, "$999,999,999,999");
    }

}
