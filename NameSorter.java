import java.io.*;
import java.util.*;

public class NameSorter {
    public static void main(String[] args) {
        ArrayList<String[]> names = getNames();
        for (String[] stringArray : names) {
            for (String s : stringArray) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<String[]> getNames() {
        ArrayList<String[]> names = new ArrayList<String[]>();
        try {

            File unsortedNames = new File("unsorted-names-list.txt");
            Scanner nameReader = new Scanner(unsortedNames);

            while (nameReader.hasNextLine()) {
                String[] name = nameReader.nextLine().split("\\s+");
                names.add(name);
            }
            nameReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return names;
    }
}

