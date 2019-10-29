/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary;

import Controller.Kamus;
import Controller.Stemming;
import Controller.TanpaSYR;
import Controller.DenganSYR;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Anggi Juwita
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here\
//        new MainFormTA().setVisible(true);

        String pathsumber = "C:\\Users\\User\\Documents\\NetBeansProjects\\BuatProgramTA\\tes_doc\\text1.txt";
        String pathbanding = "C:\\Users\\User\\Documents\\NetBeansProjects\\BuatProgramTA\\tes_doc\\text2.txt";

        System.out.println(pathbanding);

        TanpaSYR syr = new TanpaSYR();
        syr.parseFilesU(pathbanding);
        String[] stem = syr.getTermDocArray();
        String join1 = String.join(" ", syr.getTermDocArray());
        System.out.println("jon1=" + join1);
        List<String> join_stem1 = Arrays.asList(join1.split(" "));

        System.out.println("stem doc banding:");
        for (int i = 0; i < stem.length; i++) {
            System.out.println(stem[i]);
        }

        System.out.println("\n");
        System.out.println(pathsumber);
        syr.parseFilesU(pathsumber);
        String[] stem2 = syr.getTermDocArray();
        String join2 = String.join(" ", syr.getTermDocArray());
        System.out.println("jon2=" + join2);
        
        //store kamus by line
        Kamus reads = new Kamus();
        List<String> list_kamus = reads.SYR();
              
        for (int i = 0; i < list_kamus.size(); i++) {
            System.out.println(list_kamus.get(i));
        }
        
        //cek sinonim
        DenganSYR dsyr = new DenganSYR();
        
        for (String word : join_stem1) {
            if (list_kamus.contains(word)) {
                System.out.println(word);
            }
        }

    }

}
