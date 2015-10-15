import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {

    public static void main(String[] args) {
        HashMap<String, ArrayList<Country>> countries = new HashMap();

        String postCountry = readFile("countries.txt");
        String[] lines = postCountry.split("\n");

        for (String line : lines) {
            String[] columns = line.split("\\|");
            String abbreviation = columns[1];
            String name = columns[0];
            Country country = new Country(name, abbreviation);
            if (countries.containsKey(name.substring(0, 1))) {
                countries.get(name.substring(0,1)).add(country);
            } else {
                ArrayList<Country> countryList = new ArrayList();
                countryList.add(country);
                countries.put(name.valueOf(name.charAt(0)), countryList);
            }
        }
            Scanner scanner = new Scanner(System.in);
            String placeLists = "";
            String l = "";
            while (true) {
                System.out.println("Enter a letter");
                l = scanner.nextLine();
                if (countries.containsKey(l)) {
                    for (Country place : countries.get(l)) {
                        placeLists += String.format("%s %s\n ", place.abbreviation, place.name);
                    }
                }
                writeFile(String.format("%s_countries.txt", l), placeLists);
                break;
            }
    }

    static String readFile(String fileName) {
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }

    static void writeFile(String fileName, String fileContent) {
        File f = new File(fileName);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        } catch (Exception e) {

        }
    }
}
