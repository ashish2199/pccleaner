/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pccleaner;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashish Padalkar
 */
public class progress extends javax.swing.JFrame {
    
    
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
    
    
    

    /**
     * Creates new form progress
     */
    public progress() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblstatus = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblstatus.setText("jLabel1");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(lblstatus))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(lblstatus)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblstatus;
    // End of variables declaration//GEN-END:variables
}
