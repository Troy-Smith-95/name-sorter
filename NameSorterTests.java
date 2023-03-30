import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.*;

public class NameSorterTests {
    
    @Test 
    public void testSortByName1(){

        //Create name objects
        Name janet = new Name("Janet", null, null, "Parsons");
        Name vaughn = new Name("Vaughn", null, null, "Lewis");
        Name adonis = new Name("Adonis", "Julius", null, "Archer");
        Name shelby = new Name("Shelby", "Nathan", null, "Yoder");
        Name marin = new Name("Marin", null, null, "Alvarez");
        Name london = new Name("London", null, null, "Lindsey");
        Name beau = new Name("Beau", "Tristan", null, "Bentley");
        Name leo = new Name("Leo", null, null, "Gardner");
        Name hunter = new Name("Hunter", "Uriah", "Mathew", "Clarke");
        Name mikayla = new Name("Mikayla", null, null, "Lopez");
        Name frankie = new Name("Frankie", "Conner", null, "Ritter");

         // Create unsorted names list
         ArrayList<Name> unsortedNames = new ArrayList<>();
         Collections.addAll(unsortedNames, janet, vaughn, adonis, shelby, marin, london, beau, leo, hunter, mikayla, frankie);
 
         // Create expected sorted names list
         ArrayList<Name> expectedSortedNames = new ArrayList<>();
         Collections.addAll(expectedSortedNames, marin, adonis, beau, hunter, leo, vaughn, london, mikayla, janet, frankie, shelby);
 
         // Sort the unsorted names list
         Collections.sort(unsortedNames, new SortByName());
 
         // Verify that the sorted list matches the expected sorted list
         assertEquals(expectedSortedNames, unsortedNames);
    }

    @Test 
    public void testSortByName2(){

        //Create name objects
        Name lovel = new Name("Lovel", "Geneva", null, "Midgley");
        Name ermintrude = new Name("Ermintrude", "Ursella", null, "Merrill");
        Name merton = new Name("Merton", null, null, "Addison");
        Name ryland = new Name("Ryland", null, null, "Shaw");
        Name alysa = new Name("Alysa", null, null, "Bancroft");
        Name jem = new Name("Jem", null, null, "Sniders");
        Name norma = new Name("Norma", null, null, "Prescott");
        Name manny = new Name("Manny", "Freddie", "Mel", "Savege");
        Name jules = new Name("Jules", "Delia", "Kelan", "Dickman");
        Name sam = new Name("Sam", null, null, "Addison");
        Name norma2 = new Name("Norma", "Conner", null, "Prescott");

         // Create unsorted names list
         ArrayList<Name> unsortedNames = new ArrayList<>();
         Collections.addAll(unsortedNames, lovel, ermintrude, merton, ryland, alysa, jem, norma, manny, jules, sam, norma2);
 
         // Create expected sorted names list
         ArrayList<Name> expectedSortedNames = new ArrayList<>();
         Collections.addAll(expectedSortedNames, merton, sam, alysa, jules, ermintrude, lovel, norma2, norma, manny, ryland, jem);
 
         // Sort the unsorted names list
         Collections.sort(unsortedNames, new SortByName());
 
         // Verify that the sorted list matches the expected sorted list
         assertEquals(expectedSortedNames, unsortedNames);
    }

}
