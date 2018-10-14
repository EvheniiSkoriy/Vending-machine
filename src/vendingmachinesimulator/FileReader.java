/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinesimulator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author    read information from file
 */
public class FileReader {
    

    /**
     *
     * @param filename  name of file that you want read
     * @return table of objects Food
     */

    public static List<Food> readFile(String filename) {
        BufferedReader reader = null;
        String line;
        List<Food> list = new List();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(",");
                Food f = new Food(array[0], Double.parseDouble(array[1]), Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]));
                list.add(f);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
        }
        return list;
    }

}
