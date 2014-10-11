/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pccleaner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author Ashish Padalkar
 */
public class NewClass{
        
    
    public static void displayDirectoryContents(BufferedWriter bw,File dir) 
            {
                
                
                
                try{                    File[] files = dir.listFiles();
                                        for (File file : files) {
                                            if(file == null){ System.out.println("NUll directory found ");continue;}
                                            if (file.isDirectory()) {
                                                
                                                
                                                System.out.println("hiiiii"+file.getCanonicalPath());
                                                if (file.listFiles()==null) { continue;}                                            displayDirectoryContents(bw,file);}
                                            else{
                                                
                                                    String ext=getExtension(file);
                                                        if(ext==null){continue;}
                                                        String chkext ="c";
                                                        if( ext.equals(chkext))
                                                            {   
                                                                bw.append("hi"+file.getCanonicalPath());
                                                                bw.newLine();
                                                            }

                                                    System.out.println("byeeeee"+file.getCanonicalPath());
                                                }

                                        }
                            
                                        }catch( IOException e) {
                                             JOptionPane.showMessageDialog(null,"error :   "+ e);
                                        }
             
            }
   
    
    
                
    public static void main(String[] args){
        System.out.println("HI");
        try{ 
        FileWriter fw = new FileWriter("C:/filenames.txt");
         BufferedWriter bw = new BufferedWriter(fw);
        
         File currentDir = new File("C:\\pd");    
        displayDirectoryContents(bw,currentDir);
        bw.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"error :   "+ e);
    }
    }
    
public static String getExtension(File f) {
                            String ext = null;
                            String s = f.getName();
                            int i = s.lastIndexOf('.');

                            if (i > 0 &&  i < s.length() - 1) {
                                ext = s.substring(i+1).toLowerCase();
                            }
                            return ext;
                            }    
    


}
