# Name Sorter

This name sorter program sorts the names in the unsorted-names-list.txt file and both writes the sorted list of names in the sorted-names-list.txt file and prints the sorted list to the console/terminal. Names in the unsorted-names-list.txt file are each on their own unique line and have a minimum of one given name and a last name and a maximum of three given names and one last name. Names are first sorted by last name. If the last names are the same, it then looks to compare the first given name onwards. In the case where two names are otherwise identical but one has an additional given name, the name with the additional given name will be sorted before the one that does not have the additional name. For example, Troy Austin Smith would be sorted before Troy Smith.

The NameSorter.java file contains the main method where the program is executed. It also includes the functionilty to write and read the names to and from files.

The Name.java file contains the name class to generate name objects that represent the names in the list.

The SortByNameFunction.java file contains a class that implements the Comparator interface to define logic to sort the Names.

The NameSorterTests.java file defines two unit tests to test the sorting function.
