/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Anggi Juwita
 */

public class DenganSYR {

    private String[] termDocArray;
    Kamus stpwlist;

    public void parseFilesU(String filePath) throws FileNotFoundException, IOException {
        File file = new File(filePath);
        BufferedReader in = null;
        Kamus kamus = new Kamus();
        List<String> hasilStemm = new ArrayList<>();

        if (file != null) {
            in = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String s = null;
            while ((s = in.readLine()) != null) {
                sb.append(s);
            }

            String[] tokenizedTerms = sb.toString().toLowerCase().replaceAll("[!\"$%&'()*\\+,.;:/<=>?\\[\\]^~_\\`{|}…0987654321]", "").split("\\W+");   //to get individual terms
            List<String> listTermDoc = new ArrayList<String>(Arrays.asList(tokenizedTerms));
            listTermDoc.removeAll(kamus.readStopWord());  //stopword pada TermDoc

            for (String stemm : listTermDoc) {
                Stemming st = new Stemming(); //Stemm
                stemm = st.kataDasar(stemm);
                hasilStemm.add(stemm);
            }

            termDocArray = hasilStemm.toArray(new String[0]);
        }
    }

    public String[] getTermDocArray() {
        return termDocArray;
    }
    
    public List<String> cek_sameWord(List<String> string2){
        List<String> sameWord = new ArrayList<>();
        
        for (String word : termDocArray) {
            if (string2.contains(word)) {
                sameWord.add(word);
            }
        }
        
        return sameWord;
    }
    
    public List<String> cek_sinonim(List<String> cek_sameWord){
        List<String> sameWord = new ArrayList<>();
        List<String> lststopword = new ArrayList<String>();
        Kamus stpwlist = new Kamus();

        lststopword = stpwlist.SYR();
        
        for (String word : cek_sameWord) {
            if (lststopword.contains(word)) {
                sameWord.add(word);
            }
        }
        return sameWord;
    }

//    public void Sinonim(String[] termDocArray) {
//        int sinonim = 0;
//        for (int i = 0; i < termDocArray.length; i++) {
//            if (termDocArray[i].length() > 1) {
////                find_sinonim
//                if (findSinonim(termDocArray[i])) {
//                    sinonim = 1;
//                }
//            }
//        }
//
//        if (sinonim == 1) {
//            System.out.println("ada");
//        }
//    }
//
//    public void SameWord(String[] termDocArray) {
//        int sameWord = 0;
//        for (int i = 0; i < termDocArray.length; i++) {
//            if (termDocArray[i].length() > 1) {
////                find_sinonim
//                if (findSameWord(termDocArray[i])) {
//                    sameWord = 1;
//                }
//            }
//        }
//
//        if (sameWord == 1) {
//            System.out.println("ada kata yang sama");
//        }
//    }
//
//    public boolean findSameWord(String str) {
//        boolean ada = false;
//        for (int i = 0; i < termDocArray.length; i++) {
//            if (termDocArray[i].equals(str)) {
//                ada = true;
//                break;
//            }
//        }
//        return ada;
//    }
//
//    public void printSameWord(String str) {
//
//        for (int i = 0; i < termDocArray.length; i++) {
//            if (termDocArray[i].contains(str)) {
//                System.out.println(str);
//            }
//        }
//    }
//
//    public boolean findSinonim(String str) {
//        List<String> lststopword = new ArrayList<String>();
//        Kamus stpwlist = new Kamus();
//
//        lststopword = stpwlist.SYR();
//
//        boolean ada = false;
//
//        for (int i = 0; i < lststopword.size(); i++) {
//            if (lststopword.get(i).equals(str)) {
//                ada = true;
//                break;
//            }
//        }
//        return ada;
//    }

}
