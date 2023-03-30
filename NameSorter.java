import java.io.*;
import java.util.*;

//Class to represent a name
class Name {

    //Attributes of a name
    String firstName, lastName;
    Optional<String> middleName;

    //Constructor
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = Optional.ofNullable(middleName);
        this.lastName = lastName;
    }

    //Getter methods
    public String getFirstName() {
        return firstName;
    }

    public Optional<String> getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    //Method to format name as string
    public String toString() {
        if (middleName != null && !middleName.isEmpty()) {
            return String.format("%s %s %s", firstName, middleName.orElse(""), lastName);
        } else {
            return String.format("%s %s", firstName, lastName);
        }
        
    }
}



public class NameSorter {
    public static void main(String[] args) {
        ArrayList<Name> names = getNames();
        for (Name name : names) {
            System.out.print(name.toString());
            System.out.println();
        }
    }

    public static ArrayList<Name> getNames() {
        ArrayList<Name> names = new ArrayList<>();
        try {

            File unsortedNames = new File("unsorted-names-list.txt");
            Scanner nameReader = new Scanner(unsortedNames);

            while (nameReader.hasNextLine()) {
                String[] nameParts = nameReader.nextLine().split("\\s+");
                if (nameParts.length == 3) {
                    Name name = new Name(nameParts[0], nameParts[1], nameParts[2]);
                    names.add(name);
                } else {
                    Name name = new Name(nameParts[0], null, nameParts[1]);
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

