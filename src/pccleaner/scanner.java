package pccleaner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class scanner implements Runnable{
Thread t;
    scanner(){
    t= new Thread(this,"Scanner Thread");
    t.start();
    }
    
    public void run(){
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(scanner.class.getName()).log(Level.SEVERE, null, ex);
            }
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

}
