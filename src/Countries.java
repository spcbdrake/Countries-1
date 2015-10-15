import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {

    public static void main(String[] args) {
        HashMap<String, ArrayList<Country>> countries = new HashMap();
        ArrayList<Country> countryList = new ArrayList();
        String postCountry = readFile("countries.txt");
        String[] lines = postCountry.split("\n");


        for (String line : lines) {
            String[] columns = line.split("\\|");
            String abbreviation = columns[0];
            String name = columns[1];

            Country country = new Country(name, abbreviation);
            countryList.add(country);
        }

        Scanner scanner = new Scanner(System.in);
        int  = -1;
        while (true) {

        }
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
