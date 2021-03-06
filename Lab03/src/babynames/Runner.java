package babynames;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Comparator;

public class Runner {

    public static void main(String[] args) {
        ArrayList<String> names = readnames();
        Collections.sort(names);  // uses the build in sorting for String
        System.out.println("The last name is " + names.get(names.size() - 1));
        
        // Use an *anonymous* Comparator to find the longest name, or a name tied for longest.
        names.sort(
        		new Comparator<String>() {
                    @Override
                     public int compare(String arg0, String arg1) {
                         return arg0.length() - arg1.length();
                     }
               }
        );
        System.out.println("The Longest name is " + names.get(names.size() - 1));
        
        // Use an *anonymous* Comparator to find the name that is, backwards, alphanumerically last.
        names.sort(
        		new Comparator<String>() {
                    @Override
                     public int compare(String arg0, String arg1) {

            			 new StringBuilder(arg0).reverse().toString();
            			 new StringBuilder(arg1).reverse().toString();
                         return arg1.length() - arg0.length();
                     }
               }
        );
        System.out.println("The backwards, alphanumerically last name is " + names.get(names.size() - 1));       
    }
    
    
    
    public static void sortTest() {
        
    }

    
    // reads names from a file named "babynames.txt", which should be in 
    //  the java package 'babynames'
    public static ArrayList<String> readnames() {
        ArrayList<String> names = new ArrayList<>();
        try {
            String path = System.getProperty("user.dir");  // gets this project's base directory
            path += "/src";   // looks in Source Packages in this project
            path += "/babynames/babynames.txt";   // looks inside the babynames package, in the babynames.txt file
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                names.add(line);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Couldn't find the file");
        } catch (IOException ex) {
            System.err.println("Couldn't read file");;
        }
        System.out.println(names.size() + " names read from file.");
        return names;
    }


}
