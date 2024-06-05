/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public List<List<String>> readFile(String fileName){
        try {
            List<List<String>> data = new ArrayList<>();
            FileInputStream fis = new FileInputStream(fileName);
            Scanner sc = new Scanner(fis);
            
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(!line.isEmpty()){
                    List<String> lineData = Arrays.asList(line.split(","));
                    data.add(lineData);
                }
            }
            
            sc.close();
            fis.close();
                return data;
                   
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void writeFile(String fileName, List<List<String>> data){
        try {
            PrintWriter pw = new PrintWriter(fileName);
            for (List<String> lineData : data){
                String line = String.join(",", lineData);
                pw.println(line);
            }
            pw.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
//    public void save(String fileName) {
//        List<List<String>> data = new ArrayList<>();
//        for (List<String> lineData : data){
//            data.add(lineData);
//        }
//
//    }
}
