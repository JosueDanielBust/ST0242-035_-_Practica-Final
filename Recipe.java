/**
 * Creator: Josue Daniel Bustamante
 * Version: 04/06/2014
 */
import java.util.ArrayList;
import java.util.Arrays;

/**
 * What I need say of this class?
 * It's a recipe, no more.
 */
public class Recipe {
    private ArrayList<String> recipe;
    private String patient;
    
    /**
     * Recipe is a cool class, is the recipe of the drugs that the patient
     * need for make you better and restore your heal, the personal that can
     * makes new recipe are only the Nurse.
     * 
     * @param patient   Is the name of the patient
     * @param drugs     Are the drugs for the patient. Auch!
     */
    public Recipe(String patient, ArrayList<String> drugs) {
        this.patient = patient;
        recipe = new ArrayList<String>();
        for (String d : drugs) { recipe.add(d); }
    }

    /**
     * Makes a print of the recipe with the drugs that the
     * nurse put or enter in the system
     */
    public void print() {
        System.out.println(patient + "\n-----");
        for (String d : recipe) {
            System.out.println(d);
        }
    }
    
    /**
     * What is the name of the patient?, This method say's the info
     * 
     * @return Patient name
     */
    public String getRecipePatientName() { return patient; }
}
