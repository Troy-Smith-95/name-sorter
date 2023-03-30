import java.io.*;
import java.util.*;

public class NameSorter {
    public static void main(String[] args) {

        ArrayList<Name> names = getNames();

        Collections.sort(names, new SortByName());

        writeNames(names);
    }

    // Method to read names from file
    public static ArrayList<Name> getNames() {

        // Names are stored as Name objects inside an ArrayList
        ArrayList<Name> names = new ArrayList<>();

        try {
            File unsortedNames = new File("unsorted-names-list.txt");
            Scanner nameReader = new Scanner(unsortedNames);
            while (nameReader.hasNextLine()) {
                String[] nameParts = nameReader.nextLine().split("\\s+");
                if (nameParts.length == 4) {
                    Name name = new Name(nameParts[0], nameParts[1], nameParts[2], nameParts[3]);
                    names.add(name);
                } else if (nameParts.length == 3) {
                    Name name = new Name(nameParts[0], nameParts[1], null, nameParts[2]);
                    names.add(name);
                } else if (nameParts.length == 2) {
                    Name name = new Name(nameParts[0], null, null, nameParts[1]);
                    names.add(name);
                }
            }
            nameReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return names;
    }

    //Method to write names to file and print to console
    public static void writeNames(ArrayList<Name> names) {

        try {
            FileWriter nameWriter = new FileWriter("sorted-names-list.txt");
            for (Name name : names) {
                //Write to file
                nameWriter.write(name.toString());
                nameWriter.write(System.lineSeparator());
                //Print to console
                System.out.println(name.toString());
            }
            nameWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
