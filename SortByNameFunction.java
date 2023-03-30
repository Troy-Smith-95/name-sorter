import java.util.*;

// Class to implement Comparator interface
public class SortByNameFunction implements Comparator<Name> {

    // Sorting by last name, then first through third given name if applicable
    public int compare(Name name1, Name name2) {

        int result = name1.lastName.compareTo(name2.lastName);

        // If last names are the same, compare first names
        if (result == 0) {
            result = name1.givenName1.compareTo(name2.givenName1);
            // If first names are the same, compare second given names
            if (result == 0) {
                if ((name1.givenName2 != null && !name1.givenName2.isEmpty())
                        && (name2.givenName2 != null && !name2.givenName2.isEmpty())) {
                    result = name1.givenName2.toString().compareTo(name2.givenName2.toString());
                    // If second given names are the same, compare third given names
                    if (result == 0) {
                        if ((name1.givenName3 != null && !name1.givenName3.isEmpty())
                                && (name2.givenName3 != null && !name2.givenName3.isEmpty())) {
                            result = name1.givenName2.toString().compareTo(name2.givenName2.toString());
                        } else if ((name1.givenName3 != null && !name1.givenName3.isEmpty())
                                && (name2.givenName3 == null || name2.givenName3.isEmpty())) {
                            result = -1;
                        } else {
                            result = 1;
                        }
                    }
                } else if ((name1.givenName2 != null && !name1.givenName2.isEmpty())
                        && (name2.givenName2 == null || name2.givenName2.isEmpty())) {
                    result = -1;
                } else {
                    result = 1;
                }
            }
        }
        return result;
    }
}
