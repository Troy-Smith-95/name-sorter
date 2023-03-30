import java.util.*;

//Class to represent a name
public class Name {

     // Attributes of a name
     String givenName1, lastName;
     Optional<String> givenName2, givenName3;
 
     // Constructor
     public Name(String givenName1, String givenName2, String givenName3, String lastName) {
         this.givenName1 = givenName1;
         this.givenName2 = Optional.ofNullable(givenName2);
         this.givenName3 = Optional.ofNullable(givenName3);
         this.lastName = lastName;
     }
 
     // Method to format name as string
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
