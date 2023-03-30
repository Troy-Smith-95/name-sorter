import java.io.*;
import java.util.*;

//Class to represent a name
class Name {

    //Attributes of a name
    String givenName1, lastName;
    Optional<String> givenName2, givenName3;

    //Constructor
    public Name(String givenName1, String givenName2, String givenName3, String lastName) {
        this.givenName1 = givenName1;
        this.givenName2 = Optional.ofNullable(givenName2);
        this.givenName3 = Optional.ofNullable(givenName3);
        this.lastName = lastName;
    }

    //Method to format name as string
    public String toString() {
        if ((givenName2 != null && !givenName2.isEmpty()) && (givenName3 != null && !givenName3.isEmpty())) {
            return String.format("%s %s %s %s", givenName1, givenName2.orElse(""), givenName3.orElse(""), lastName);
        } else if ((givenName2 != null && !givenName2.isEmpty()) && (givenName3 == null || givenName3.isEmpty())) {
            return String.format("%s %s %s", givenName1, givenName2.orElse(""), lastName);
        } else {
            return String.format("%s %s", givenName1, lastName);
        }
    }
}

//Class to implement Comparator interface
class SortByName implements Comparator<Name> {

    //Sorting by last name, then first through third given name if applicable
    public int compare(Name name1, Name name2) {

        int result = name1.lastName.compareTo(name2.lastName);

        //If last names are the same, compare first names
        if (result == 0 ){
            result = name1.givenName1.compareTo(name2.givenName1);
            //If first names are the same, compare second given names
            if (result == 0) {
                if ((name1.givenName2 != null && !name1.givenName2.isEmpty()) && (name2.givenName2 != null && !name2.givenName2.isEmpty())) {
                    result = name1.givenName2.toString().compareTo(name2.givenName2.toString());
                    //If second given names are the same, compare third given names
                    if (result == 0) {
                        if ((name1.givenName3 != null && !name1.givenName3.isEmpty()) && (name2.givenName3 != null && !name2.givenName3.isEmpty())) {
                            result = name1.givenName2.toString().compareTo(name2.givenName2.toString());
                        } else if ((name1.givenName3 != null && !name1.givenName3.isEmpty()) && (name2.givenName3 == null || name2.givenName3.isEmpty())) {
                            result = 1;
                        } else {
                            result = -1;
                        }
                    }
                }
            } else if ((name1.givenName2 != null && !name1.givenName2.isEmpty()) && (name2.givenName2 == null || name2.givenName2.isEmpty())) {
                result = 1;
            } else {
                result = -1;
            }
        }
        return result;
    }
}


public class NameSorter {
    public static void main(String[] args) {

        ArrayList<Name> names = getNames();
        for (Name name : names) {
            System.out.print(name.toString());
            System.out.println();
        }

        Collections.sort(names, new SortByName());
        System.out.println("Sorted:");
        for (Name name : names) {
            System.out.print(name.toString());
            System.out.println();
        }
    }

    //Method to read names from file
    public static ArrayList<Name> getNames() {

        //Names are stored as Name objects inside an ArrayList
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
                } else {
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
}

