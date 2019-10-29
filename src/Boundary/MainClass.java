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
        
        System.out.println("stem doc sumber:");
        for (int i = 0; i < stem2.length; i++) {
            System.out.println(stem2[i]);
        }
        
        
        //cek same word
        List<String> sameWord = new ArrayList<>();
        List<String> word2 = Arrays.asList(join2.split(" "));
        List<String> word1 = Arrays.asList(join1.split(" "));
        for (String word : stem) {
            if (word2.contains(word)) {
                sameWord.add(word);
            }
        }
        
        System.out.println("\nkata sama= " + sameWord);
    
        
        //cek sinonim same word
        List<String> lststopword = new ArrayList<String>();
        List<String> sinonim = new ArrayList<>();
        Kamus stpwlist = new Kamus();
        lststopword = stpwlist.SYR();

//        for (int i = 0; i < lststopword.size(); i++) {
//            if (lststopword.get(i).equals(sameWord)) {
//                //...
//            }
//        }

        System.out.println("\nkata sinonim= ");
        for (String cekString : lststopword) {
            if (sameWord.contains(cekString)) {
                sinonim.add(cekString);
                System.out.println(sinonim);
            }
        }
        
//        =======================================================

        System.out.println("\ncek fungsi= ");
        DenganSYR dsyr = new DenganSYR();
        List<String> cek_kata = dsyr.cek_sameWord(word2);
        List<String> cek_sinonim = dsyr.cek_sameWord(cek_kata);
        System.out.println(cek_kata);
        System.out.println(cek_sinonim);
        
        //replace sinonim
        
        
    }
    
}
