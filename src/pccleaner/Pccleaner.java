package pccleaner;
import java.io.*;
import java.io.IOException;
import javax.swing.JOptionPane;

//import pccleaner.progressbar.*;

public class Pccleaner {    
    static File[] fileslist;
    static int i=0;
    public static void displayDirectoryContents(File dir) throws IOException
      
            {
                
                
		try {
                    FileWriter fw = new FileWriter("C:/filenames.txt");
                     BufferedWriter bw = new BufferedWriter(fw);
                     
                        //System.out.println("File opened");
                
			File[] files = dir.listFiles();
                     	for (File file : files) {
                            if(file == null){ System.out.println("NUll directory found ");continue;}
                                if (file.isDirectory()) {
					//System.out.println("directory:" + file.getCanonicalPath());
					    if (file.listFiles()==null) { continue;
                                               }
                                        displayDirectoryContents(file);
				} 
                                else {  
                                        String ext=getExtension(file);
                                        if(ext==null){continue;}
                                        String chkext ="mp3";
                                        if( ext.equals(chkext))
                                        {
                                            
                                            JOptionPane.showMessageDialog(null, file.getCanonicalPath());
                                            bw.write(file.getCanonicalPath());
                                            bw.newLine();
                                            
                                        //System.out.println("Write operation performed");    
                                       
                                        //bw.write(file.getCanonicalPath());
                                        //bw.newLine();
                                        //if(ext==null){continue;}
                                        //fileslist[i]=file;
                                        i++;
                                        
                                        System.out.println("Extension: "+getExtension(file)+"     file:" + file.getCanonicalPath());
                                        }
                
                                    
                                    
                                        //System.out.println("Extension: "+getExtension(file)+"     file:" + file.getCanonicalPath());
                                    }
                                
			}
                        bw.close();
                        //System.out.println("File Closed");
                    } catch (IOException e) 
                                        { JOptionPane.showMessageDialog(null, "error         "+e);
                                            }       
            }
    
            public static void main(String[] args) throws IOException{
                File currentDir = new File("C:/Users/Ashish Padalkar/Downloads");    
                displayDirectoryContents(currentDir);// current directory
                     
                    //for(int k=0;k<100;k++){
                        
                       // if(fileslist[i].listFiles()==null){continue;}
                System.out.println(i);  
                 
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