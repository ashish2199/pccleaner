import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;       
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.*;
import org.apache.commons.io.FileUtils;

    
public class gui extends javax.swing.JFrame {
private ProgressInfinite taskInfinite;
private ProgressInfinite2 taskInfinite2;
int firsttime=0,result_tab=0,edit_tab=0,scan_tab=0;
int j=0,z=0,ext_no=0;
long freeSpace,totalSpace,usedSpace,size=0,m=0,mem=0,x,hours,minutes,seconds;
int errors;
String filename;
int recoverspace=0,resme_btn=0;
private boolean abortProcessing;
private boolean pauseProcessing;


//Thread t=new Thread();

String userexts[];
String[] exts;
String[] fexts ={
//<editor-fold defaultstate="collapsed" desc="file extensions">
    "crdownload",
    "part",
    "thumbdata3--1967290299",
    "thumbdata5--1967290299_0",
    "thumbdata3--1763508120",
    "thumbdata3--number",
    "download",
    "csi",
    "mxdl",
    "thumbdata3--1967290299",
    "tmp",
    "cvr",
    "adadownload",
    "fseventsd-uuid",
    "localstorage-journal",
    "laccdb",
    "ewc2",
    "!ut",
    "lck",
    "~cr",
    "etl",
    "csd",
    "filepart",
    "dtapart",
    "egt",
    "cache",
    "rra",
    "objectcache",
    "glh",
    "waf",
    "chkn",
    "rcv",
    "imgcache",
    "fb!",
    "prmdc",
    "temp",
    "download",
//"_501",
    "tec",
    "bdm",
    "thumbdata-1763508120_0",
    "thumbdata5",
    "partial",
    "tv5",
    "waf",
    "box",
    "onecache",
    "cah",
    "swo",
    "swn",
    "pft",
    "wfm",
    "little",
    "rsc_tmp",
    "phc",
    "msj",
    "TemporaryItems",
// "reapeaks",
//"inf",
    "bu",
    "nov",
    "dap",
    "hex",
    "ptn2",
    "utpart",
    "nb2",
    "msj",
    "thumbdata",
    "download",
//"dat",
    "rld",
    "rsx",
    "cfa",
//"cache-2",VLC font cache file
    "tmt",
    "lrd",
    "bmc",
    "ird",
    "dca",
//"pnf", micosoft windows pre compile setup information
//"indexArrays",
//"m_p",
    "BridgeCacheT",
    "dia",
//"indexPositions",
    "lai",
    "shadowIndexTermIds",
    "wcc",
    "thumbdata5--1967290299_0",
    "bv6",
    "bv7",
    "exd",
    "mex",
    "tv2",
    "$vm",
    ")2(",
    "^fsf",
    "bmb",
    "qbt",
    "tof",
    "4sh",
    "crc",
    "cdc",
    "mtx",
    "pat",
//"idlk",
    "buf",
    "(d)",
    "inprogress",
    "hmap",
    "save",
    "cos2",
    "zoner-rawdata-cache",
    "hax",
    "csstore",
    "sqlite3-journal",
    "bv4",
    "dtf",
    "fchc",
    "meb",
    "moz",
    "peb",
    "ytf",
    "spc",
    "tv1",
    "tv3",
    "tv6",
    "$db",
    "fes",
    "nmu",
    "heu",
    "mx1",
    "pm$",
    "qbi",
    "rdn",
    "zsr",
    "00a",
    "ers",
    "tst",
    "identcache",
    "asx","muf",
    "vsscc",
    "aso",
    "TemporaryItems",
    "vaf",
    "lockfile",
    "@@1",
    "a$v",
    "wsb",
    "tmd",
    "alt",
    "tic",
    "mbc",
    "indexPositionTable",
    "shadowIndexCompactDirectory",
    "ilp",
    "bridgecache",
    "f2l",
    "xcuserstate",
    "nc2",
    "thumbdata3",
    "thumbdata5--1763508120_0",
    "$$$",
    "---",
    "~$~",
    "bv2",
    "bv1",
    "bv3",
    "bv5",
    "bv8",
    "bv9",
    "chk",
    "clp",
    "db$",
    "db$",
    "dov",
    "vmc",
    "fts",
    "init",
    "jnk",
    "met",
    "ncch",
    "pet",
    "pzx",
    "qdat",
    "sdx",
    "~nt",
    "t44",
    "tv4",
    "tv7",
    "tv8",
    "tv9",
    "u96",
    "w44",
    "qtindex",
    "wtmp",
    "$ed",
    "bde",
    "c1s",
    "dw3",
    "xp~",
    "md0",
    "r1m",
    "tb0",
    "t$m",
    "zn~",
    "#$#",
    "ipe_tempfile",
    "ebktml",
    "@@2",
    "als",
    "bom",
    "ger",
    "memb",
    "pls",
    "ref",
    "pfc",
    "§§§",
    "adblock",
    "swd",
    "mpx",
    "rad",
    "dir00",
    "wlx",
    "onetmp",
    "zl",
    "csac",
    "ipl",
    "cdt",
    "###",
    "isl",
    "compo",
    "mpgindex",
    "wid",
    "ci",
    "bsi",
    "hmap.Dir",
    
    "wa~",
    "dinfo",
    "dmsk",
    "svn-work",
    "stf",
    "zoner-index-cache",
    "abc",
    "s2mi",
    "iff",
    "ipl22",
    "preview7",
    "sss~",
    "xps",
    "wov",
    "fdpart",
    "simpl_int",
    "vmdk-converttmp",
    "grbdropfile",
    "appdownload",
    "as$",
//"cache-3", vlc font
    "qp2",
    "qp1",
    "escopy",
    "thumbdata4",
    "thumbdata4--1967290299",
    "thumbdata4--1763508120",
    "fsf"
//</editor-fold>
};

public void show_text() // for result test area
{
    try{
         FileReader fr = new FileReader("C:\\fpc fileslist\\filenames.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) 
            {     
                  jTextArea1.append(line+"\n");
               
            }
    }
    catch(Exception ex)
    {
        
    }
}

public void getscan_time(File file)    // for checking that the file is under 24 hrs then date wont be displayed
{
     Date date1= new Date(file.lastModified());
     //System.out.println(date1);
          Date date2 = new Date();
        
        SimpleDateFormat sdf= new SimpleDateFormat("yy/dd/M HH:mm:ss");
        String date_start= sdf.format(date2);
        String date_stop= sdf.format(date1);
      //  System.out.println(date_start);
      //  System.out.println(date_stop);
       
        Date d1= null;
        Date d2= null;
        try{
            d1= sdf.parse(date_start);   // converts to the simple date format 
            d2= sdf.parse(date_stop);    // converts to the simple date format
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        long diff =d1.getTime()-d2.getTime();
        seconds =TimeUnit.MILLISECONDS.toSeconds(diff);
        minutes =TimeUnit.MILLISECONDS.toMinutes(diff);
         hours= TimeUnit.MILLISECONDS.toHours(diff);
       ///System.out.println(hours);
}

public  void size(String filename)
   {             
                  File file=new  File(filename);
                 mem=  (file.length());
                 
   }

    public boolean displayDirectoryContents(BufferedWriter bw,File dir,DefaultMutableTreeNode root2,DefaultListModel list2) throws InterruptedException 
            {   DefaultMutableTreeNode newdir = new DefaultMutableTreeNode();              
		try{                     
                                        File[] files = dir.listFiles();
                                        
                                              for (File file : files) 
                                        {  
                                            if(file == null)
                                            {  
                                                System.out.println("NUll directory found ");                                            
                                                continue; // skips if the file is empty
                                            }
                                            
                                            if (file.isDirectory()) 
                                            {   
                                                //System.out.println("DIRECTORY :"+file.getCanonicalPath());                                               
                                                  statuslbl.setText(file.getCanonicalPath());
                                                 
                                                if (file.listFiles()==null) 
                                                {  
                                                    continue;
                                                }
                                                 
                                                DefaultTreeModel model =(DefaultTreeModel) result.getModel();
                                                DefaultMutableTreeNode root=(DefaultMutableTreeNode) model.getRoot();
                                                newdir = new DefaultMutableTreeNode(file.getName());
                                                /*if(root2.isLeaf())
                                                {JOptionPane.showMessageDialog(null,"Root is leaf Directed added:"+newdir);
                                                root2.add(newdir);
                                                }
                                                else{*/
                                                    //JOptionPane.showMessageDialog(null,"Root2 Directory added:"+newdir);
                                                root2.add(newdir);
                                                //}
                                                // to add a node 
                                                //JOptionPane.showMessageDialog(null,"The directory added "+newdir);
                                                //JOptionPane.showMessageDialog(null,"The directory added "+newdir.getPath());
                                                //newdir.getPath();
                                        
                                                model.reload();
                                               //JOptionPane.showMessageDialog(null,"Recursion function called for folder:"+newdir);
                                                displayDirectoryContents(bw,file,newdir,list2);
                                            }
                                            else
                                            {                                           
                                                    String ext=getExtension(file);
                                                        if(ext==null)
                                                        {     
                                                            continue;
                                                        }
                                                for (String chkext : fexts) {
                                                    if( ext.equals(chkext))
                                                        
                                                    {     
                                                        System.out.println("Extension: "+ext);
                                                        
                                                        //System.out.println("Written to disk FILE: "+file.getCanonicalPath());
                                                        getscan_time(file.getCanonicalFile());
                                                        if(hours>=24)
                                                        {
                                                         
                                                        bw.append(file.getCanonicalPath());
                                                        bw.newLine();
                                                               
                                                        list2.addElement(file.getCanonicalPath());
                                                        
                                                        //JOptionPane.showMessageDialog(null,"THe name of file is "+file.getName());
                                                        DefaultTreeModel model =(DefaultTreeModel) result.getModel();
                                                        DefaultMutableTreeNode selectednode = newdir;//(DefaultMutableTreeNode) result.getLastSelectedPathComponent();
                                                        DefaultMutableTreeNode newfile =new DefaultMutableTreeNode(file.getName());
                                                        //JOptionPane.showMessageDialog(null,"Selected node"+selectednode);
                                                        //if(selectednode!=null){
                                                        selectednode = root2;
                                                        //JOptionPane.showMessageDialog(null,"not a leaf File added :"+file.getName()+"      to the folder"+selectednode);
                                                        model.insertNodeInto(newfile, selectednode, selectednode.getChildCount());
                                                        model.reload();
                                                        recoverspace+=file.length();
                                                        
                                                        lbl_freespacegained.setText(""+(recoverspace/1000)+" KB");
                                                        //}
                                                        
                                                        errors++;
                                                        } 
                                                    }
                                                }
                                                            j++;
                                                            //errors=j;
                                                            filesnos.setText(""+j);
                                                            
                                                            size(file.getCanonicalPath());
                                                            
                                                             x= (((mem)/m)/1000000);     
                                                             z=(int)((z+x));
                                                             percent.setText(z+"%");
                                                             jProgressBar1.setValue((int)z);
                                                             statuslbl.setText(file.getCanonicalPath());
                                                    //System.out.println("FILE: "+file.getCanonicalPath());
                                                
                                                }
              if (abortProcessing) {
            return false;
         }
         
         while (pauseProcessing) {
            try { 
                Thread.sleep(50);
               if (abortProcessing) {
                  return false;
               }
            } 
            catch (Exception e) {}
         }
                                            

                                        }
                                        return true;
                                        }catch( IOException e) {
                                             JOptionPane.showMessageDialog(null,"error :   "+ e,null,JOptionPane.WARNING_MESSAGE);
                                        }    
    return true;
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
    

    
    
    //vinayak's OLD code for autostartup
        
     private static void copyFileUsingStream() throws java.io.IOException {
        final String user = System.getProperty("user.name");
        File currentDirFile = new File(".");
        String helper = currentDirFile.getAbsolutePath();
        
 helper = helper.substring(0, helper.length()-1);
         File source=new File(helper+"dist\\pccleaner.lnk");
      File destination=new File("C:\\ProgramData\\Microsoft\\Windows\\"
              + "Start Menu\\Programs\\StartUp\\pccleaner.lnk");
   
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        os = new FileOutputStream(destination);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
       
    }
    
    finally {
        is.close();
        os.close();
    }
    
    }
    
public static long getFolderSize(File dir) {
    long size = 0;
    for (File file : dir.listFiles()) {
        if (file.isFile()) {
            System.out.println(file.getName() + " " + file.length());
            size += file.length();
        }
        else
            size += getFolderSize(file);
    }
    return size;
}
public static int getFolderCount(File dir) {
    int count = 0;
    for (File file : dir.listFiles()) {
        if (file.isFile()) {
            //System.out.println(file.getName() + " " + file.length());
            //size += file.length();
            count++;
        }
        else
            count += getFolderCount(file);
    }
    return count;
}

   
    class ProgressInfinite2 extends SwingWorker<Void, Void> 
    {
        @Override
       
        public Void doInBackground() throws InterruptedException {
            jProgressBar2.setVisible(true);
            progressing2.setVisible(true);
            pendrive_status.setVisible(true);
            per2.setVisible(true);
            AbstractListModel model = (AbstractListModel) jList2.getModel();
         String str= jList2.getSelectedValue().toString();
         String selected =  str.substring(16, 19);  
        //  System.out.print(selected);
      
                    
            File currentDir = new File(selected); 
             File[] f=File.listRoots(); //to select the pendrive
                    
    
             for(File k:f)
             {     
               String s= k.getPath();
                      
                 if(s.equals(selected))
               {
                           file_delete(currentDir);
             }
              
                     }
            
      return null;
       }
        @Override
        public void done()
        {   jProgressBar2.setValue(100);
            per2.setText("100%");
            JOptionPane.showMessageDialog(null, "Format Completed ",null,JOptionPane.INFORMATION_MESSAGE ,new ImageIcon("check-icon.png"));
            progressing2.setVisible(false);
        }
        
        public void file_delete(File dir)
    {   long free=dir.getUsableSpace();
        try{
            File[] files=dir.listFiles();
            for(File file:files)
            {
                if(file.isDirectory())
                {
                    System.out.println("directory"+file.getCanonicalPath());
                    file_delete(file);
                    
                }
                else
                {   
                    if(file.delete()){
                    pendrive_status.setText(file.getAbsolutePath());
               }
                
                    System.out.println("file"+file.getCanonicalPath());
                                                         size(file.getCanonicalPath());
                                                            x= ((mem*100)/free);     
                                                             z=(int)((z+x));
                                                            
                                                            per2.setText(z+"%");
                                                            jProgressBar2.setValue((int)z);
                }
            }
            
            for(File file2:files)
            {  if(file2.isDirectory())
                {
                   // System.out.println("directory"+file2.getCanonicalPath());
                    file2.delete();
                    
                }
                
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
        
    }
    class ProgressInfinite extends SwingWorker<Void, Void> 
    {
 
        @Override
       
        public Void doInBackground() throws InterruptedException {
        int flag=0;
            try
          {  
              
              
              if(quickscan.isSelected())      
          {
             
            File f1 = new File("C:\\fpc fileslist\\filenames.txt");
            if(f1.isFile()){
            JOptionPane.showMessageDialog(null,"filenames.txt it is a file ");
            }else
            {
            JOptionPane.showMessageDialog(null,"ERROR   filenames.txt it is not a file ");
            }
            FileWriter fw = new FileWriter("C:\\fpc fileslist\\filenames.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
           
            DefaultListModel<File> list = new DefaultListModel<File>();
            jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            
            String tmp_path=System.getProperty("java.io.tmpdir");
              System.out.println("unedited string"+tmp_path);
        int n=tmp_path.length();
        tmp_path=tmp_path.replace(tmp_path.substring( tmp_path.length()-5,n),"");
        
        filename=tmp_path;
        System.out.println(filename.toString());
            File currentDir = new File(filename); 
             
            long size = FileUtils.sizeOfDirectory(new File(filename));
                         if(m==0)
                         {
                             m=10;
                         }
                         else{
                         m= size;
                         
                         }
                           
                        
            if(currentDir.isFile()){
            JOptionPane.showMessageDialog(null,"is file",null,JOptionPane.INFORMATION_MESSAGE, new ImageIcon("check-icon.png"));
            if(currentDir.isDirectory()){
            JOptionPane.showMessageDialog(null,"is Directory too",null,JOptionPane.INFORMATION_MESSAGE, new ImageIcon("check-icon.png"));
            }
            }
            
            DefaultTreeModel model =(DefaultTreeModel) result.getModel();
            DefaultMutableTreeNode root=(DefaultMutableTreeNode) model.getRoot();
            displayDirectoryContents(bw,currentDir,root,list);
            jList1.setModel(list);
            bw.close(); 
            
            
            
            
          }
              
          
              
              
              
              
              
              
              
              if(custom_rbtn.isSelected())      
          {
            File f1 = new File("C:\\fpc fileslist\\filenames.txt");
            if(f1.isFile()){
            JOptionPane.showMessageDialog(null,"filenames.txt it is a file ");
            }else
            {
            JOptionPane.showMessageDialog(null,"ERROR   filenames.txt it is not a file ");
            }  
            FileWriter fw = new FileWriter("C:\\fpc fileslist\\filenames.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
           
            DefaultListModel list = new DefaultListModel();
            jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            
            
            
            
            File currentDir = new File(filename); 
             File[] f=File.listRoots();
                    
    
                     for(File k:f)
                     {     
                         String s= k.getPath();
                      //  s = s.substring(0,s.length()-1)+"/";
                         if(s.equals(filename))
                         {
                             flag++;
                         }
              //   currentDir=new File(s);
                     }
                     if(flag>0)
                     {
                          freeSpace = currentDir.getFreeSpace();
                 totalSpace = currentDir.getTotalSpace();
                 m=totalSpace-freeSpace;
                     }
                     else{

                         long size = FileUtils.sizeOfDirectory(new File(filename));
                         if(m==0)
                         { 
                             m=10;
                         }
                         else{
                         m= size;
                         }
                           
                        }
              
                     if(currentDir.isFile()){
                        
                JOptionPane.showMessageDialog(null,"is file",null,JOptionPane.INFORMATION_MESSAGE, new ImageIcon("check-icon.png"));
            if(currentDir.isDirectory()){
             
                JOptionPane.showMessageDialog(null,"is Directory too",null,JOptionPane.INFORMATION_MESSAGE, new ImageIcon("check-icon.png"));
            }
            
            }
             
            DefaultTreeModel model =(DefaultTreeModel) result.getModel();
            DefaultMutableTreeNode root=(DefaultMutableTreeNode) model.getRoot();
             
            displayDirectoryContents(bw,currentDir,root,list);
            jList1.setModel(list);
            bw.close(); 
            
            
            
            
          }
              
                  if(custom_rbtn.isSelected())      
          {
              
            FileWriter fw = new FileWriter("C:\\fpc fileslist\\filenames.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
           
            DefaultListModel list = new DefaultListModel();
            jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            
            
            
            
            File currentDir = new File(filename); 
             File[] f=File.listRoots();
                    
    
                     for(File k:f)
                     {     
                         String s= k.getPath();
                      //  s = s.substring(0,s.length()-1)+"/";
                         if(s.equals(filename))
                         {
                             flag++;
                         }
              //   currentDir=new File(s);
                     }
                     if(flag>0)
                     {
                          freeSpace = currentDir.getFreeSpace();
                 totalSpace = currentDir.getTotalSpace();
                 m=totalSpace-freeSpace;
                     }
                     else{

                         long size = FileUtils.sizeOfDirectory(new File(filename));
                         if(m==0)
                         { 
                             m=10;
                         }
                         else{
                         m= size;
                         }
                           
                        }
              
                     if(currentDir.isFile()){
                        
                JOptionPane.showMessageDialog(null,"is file",null,JOptionPane.INFORMATION_MESSAGE, new ImageIcon("check-icon.png"));
            if(currentDir.isDirectory()){
             
                JOptionPane.showMessageDialog(null,"is Directory too",null,JOptionPane.INFORMATION_MESSAGE, new ImageIcon("check-icon.png"));
            }
            
            }
             
            DefaultTreeModel model =(DefaultTreeModel) result.getModel();
            DefaultMutableTreeNode root=(DefaultMutableTreeNode) model.getRoot();
             
            displayDirectoryContents(bw,currentDir,root,list);
            jList1.setModel(list);
            bw.close(); 
            
            
            
            
          }
              
            
            if(full_rbtn.isSelected())
            
    {
            FileWriter fw = new FileWriter("C:\\fpc fileslist\\filenames.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
           
            DefaultListModel list = new DefaultListModel();
            jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            DefaultTreeModel model =(DefaultTreeModel) result.getModel();
            DefaultMutableTreeNode root=(DefaultMutableTreeNode) model.getRoot();
            File[] f=File.listRoots();
                    
    
                     for(File k:f)
                     {     
                         String s= k.getPath();
                        s = s.substring(0,s.length()-1)+"/";
                         filename=s;
            
            File currentDir = new File(filename);
            
                 freeSpace = currentDir.getFreeSpace();
                 totalSpace = currentDir.getTotalSpace();
                 m=totalSpace-freeSpace;
            
            if(currentDir.isFile()){
            JOptionPane.showMessageDialog(null,"is file",null,JOptionPane.INFORMATION_MESSAGE,new ImageIcon("check-icon.png"));
            if(currentDir.isDirectory()){
            JOptionPane.showMessageDialog(null,"is Directory too",null,JOptionPane.INFORMATION_MESSAGE,new ImageIcon("check-icon.png"));
            }
            }
            
            displayDirectoryContents(bw,currentDir,root,list);
                     }
            jList1.setModel(list);
            bw.close(); 
            }
                   }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"error :   "+ e,null,JOptionPane.WARNING_MESSAGE);
        } 

            return null;
        }
        
        @Override
        public void done() 
        {  firsttime=2;
            if(stop.isEnabled())
        {    scanpane.getRootPane().setDefaultButton(btn_result); 
            jProgressBar1.setValue(100);
               percent.setText("100%");
            pause.setVisible(false);
            resume.setVisible(false);
            stop.setVisible(false);
            scanninggif.setVisible(false);
            btn_result.setVisible(true);          
             JOptionPane.showMessageDialog(null, "Task completed",null,JOptionPane.INFORMATION_MESSAGE,new ImageIcon("check-icon.png"));
             recoverspace=recoverspace/1024*1024;
             JOptionPane.showMessageDialog(null,"You have Recivered "+(recoverspace/1000)+"KB",null,JOptionPane.INFORMATION_MESSAGE,new ImageIcon("check-icon.png"));
            lbl_freespacegained1.setText(""+(recoverspace/1000)+" KB"); 
            
        }
             
        last_scan();
        show_text();
         }
   
    }
    
    public void last_scan()
    {         Date date = new Date();
      SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/YYYY   HH:mm:ss");
        String last_date= sdf.format(date);
      int last_errors=errors;
        
             lastscan.setText(last_date);
             scanerrors.setText(""+errors);
        try
        {
        FileWriter fw = new FileWriter("C:\\fpc fileslist\\lastscaned_date.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(last_date);
              
            bw.close();
         }
        
        
        catch(Exception ex)
        {
           
        }  
         
        try{
            FileWriter fw = new FileWriter("C:\\fpc fileslist\\lastscaned_errors.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n"+last_errors);
              
            bw.close();
        }
        catch(Exception ex)
        {
           
        }  
    }
    

    public void stored_laststatus()
    {
        try{
            FileReader fr = new FileReader("C:\\fpc fileslist\\lastscaned_date.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            int n;
            while ((line = br.readLine()) != null) 
            {     
            
                 lastscan.setText(line);
            
            }
        }
            catch(Exception ex)
                {
        
                 }
        
        try{
            FileReader fr = new FileReader("C:\\fpc fileslist\\vlastscaned_errors.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            int n;
            while ((line = br.readLine()) != null) 
            {     
            
                 scanerrors.setText(line);
            
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public  void edit_panel()
    {
        jTabbedPane1.addTab("editresults", null);
        JPanel edit_panel= new JPanel();
        
    }
    
    
    
    public gui() {        
        initComponents();
        
        this.setTitle("Friends Pc Cleaner");
        setIconImage(Toolkit.getDefaultToolkit().getImage(gui.class.getResource("task.png")));
        this.setSize(885, 705);
         
        this.setResizable(false);
        stored_laststatus();
        jTextArea1.setEditable(false);
        jTabbedPane1.removeTabAt(7);
        jTabbedPane1.removeTabAt(2);
        quickscan.setSelected(true);
        quicktab();
        jTabbedPane1.removeTabAt(6);
        per2.setVisible(false);
        jProgressBar2.setVisible(false);
        progressing2.setVisible(false);
        pendrive_status.setVisible(false);
        
        ext_txt.setVisible(false);
       lbl_userext.setVisible(false);
//jTabbedPane1.setEnabledAt(2, false);
        
        //jTabbedPane1.setc//
         buttonGroup1.add(quickscan);
       

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField2 = new javax.swing.JTextField();
        quickstart_bu = new javax.swing.JButton();
        quicktext2 = new javax.swing.JLabel();
        samplerad = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        homepane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        scanerrors = new javax.swing.JLabel();
        lastscan = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        full_rbtn = new javax.swing.JRadioButton();
        custom_rbtn = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        quickscan = new javax.swing.JRadioButton();
        scanpane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        percent = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        statuslbl = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        filesnos = new javax.swing.JLabel();
        startscan_btn = new javax.swing.JButton();
        choose_txtlbl = new javax.swing.JLabel();
        directorytxt = new javax.swing.JTextField();
        btn_result = new javax.swing.JButton();
        choose_btn = new javax.swing.JButton();
        resume = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        scanninggif = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_freespace = new javax.swing.JLabel();
        lbl_freespacegained = new javax.swing.JLabel();
        quicktext1 = new javax.swing.JLabel();
        ext_txt = new javax.swing.JTextField();
        lbl_userext = new javax.swing.JLabel();
        resultspane = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        result = new javax.swing.JTree();
        btn_editresult = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        lbl_freespacegained1 = new javax.swing.JLabel();
        back_results = new javax.swing.JButton();
        toolspane = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        format_drive = new javax.swing.JCheckBox();
        chk_ext = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        internethistory = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        settingspane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        autostartup = new javax.swing.JCheckBox();
        selectall = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        systemrelatederror = new javax.swing.JCheckBox();
        registryerrors = new javax.swing.JCheckBox();
        comandactivex = new javax.swing.JCheckBox();
        userrelated = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        registerpane = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LICENCEKEY = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        editresults = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        remove = new javax.swing.JButton();
        finalise = new javax.swing.JButton();
        back_edit = new javax.swing.JButton();
        format_device = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jProgressBar2 = new javax.swing.JProgressBar();
        progressing2 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        per2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pendrive_status = new javax.swing.JLabel();

        jToggleButton2.setBackground(new java.awt.Color(255, 255, 255));

        jToggleButton4.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setAlignmentY(0.0F);

        jTextField2.setText("jTextField2");

        quickstart_bu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quickstart_bu.setForeground(new java.awt.Color(0, 153, 153));
        quickstart_bu.setText("Start Scan");

        quicktext2.setText("Performs Quick Scan of the System");

        samplerad.setText("sample radio");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setBackground(new java.awt.Color(0, 153, 204));
        jLabel1.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/42475.png"))); // NOI18N
        jLabel1.setText("Friends PC Cleaner");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setAlignmentX(2);
        jTabbedPane1.setAlignmentY(2);
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(300, 100));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        homepane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Home");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setText("Last Scan");

        jLabel16.setText("Scan Status");

        scanerrors.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scanerrors.setForeground(new java.awt.Color(255, 0, 0));
        scanerrors.setText("Total Errors");

        lastscan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lastscan.setForeground(new java.awt.Color(51, 255, 51));
        lastscan.setText("Last Scan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scanerrors)
                    .addComponent(lastscan))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lastscan))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(scanerrors))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel19.setText("Select scan type");

        full_rbtn.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(full_rbtn);
        full_rbtn.setText("Full System Scan");
        full_rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                full_rbtnActionPerformed(evt);
            }
        });

        custom_rbtn.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(custom_rbtn);
        custom_rbtn.setText("Custom Scan");
        custom_rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_rbtnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 51, 0));
        jButton3.setText("Start Scan");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scan_again(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("<html>Scan PC to find errors<br>present on your PC</html>");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 255));
        jButton4.setText("Upgrade to Full Version");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        quickscan.setBackground(new java.awt.Color(255, 255, 255));
        quickscan.setText("Quick Scan");
        quickscan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickscanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homepaneLayout = new javax.swing.GroupLayout(homepane);
        homepane.setLayout(homepaneLayout);
        homepaneLayout.setHorizontalGroup(
            homepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homepaneLayout.createSequentialGroup()
                        .addGroup(homepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(homepaneLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(homepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homepaneLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(424, 424, 424))
                                    .addGroup(homepaneLayout.createSequentialGroup()
                                        .addComponent(full_rbtn)
                                        .addGap(53, 53, 53)
                                        .addComponent(custom_rbtn)
                                        .addGap(37, 37, 37)))
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(homepaneLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 359, Short.MAX_VALUE))))
            .addGroup(homepaneLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(homepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quickscan)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homepaneLayout.setVerticalGroup(
            homepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(homepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(full_rbtn)
                    .addComponent(custom_rbtn)
                    .addComponent(jButton3)
                    .addComponent(quickscan))
                .addGap(34, 34, 34)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" HOME           ", new javax.swing.ImageIcon(getClass().getResource("/house_2.png")), homepane, ""); // NOI18N

        scanpane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quick_scan.png"))); // NOI18N

        percent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        percent.setText("0 %");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Current File");

        statuslbl.setAutoscrolls(true);
        statuslbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setText("No of Files Scanned:");

        filesnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        startscan_btn.setBackground(new java.awt.Color(255, 255, 255));
        startscan_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        startscan_btn.setForeground(new java.awt.Color(0, 102, 255));
        startscan_btn.setText("Start Scan");
        startscan_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startscan_btnActionPerformed(evt);
            }
        });

        choose_txtlbl.setText("Choose the Directory which you want to scan");

        btn_result.setBackground(new java.awt.Color(255, 255, 255));
        btn_result.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_result.setForeground(new java.awt.Color(255, 0, 0));
        btn_result.setText("Show Result");
        btn_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resultActionPerformed(evt);
            }
        });

        choose_btn.setBackground(new java.awt.Color(255, 255, 255));
        choose_btn.setText("Choose Location");
        choose_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose_btnActionPerformed(evt);
            }
        });

        resume.setBackground(new java.awt.Color(255, 255, 255));
        resume.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resume.setForeground(new java.awt.Color(51, 153, 255));
        resume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/20140718023323973_easyicon_net_24.png"))); // NOI18N
        resume.setText("Resume");
        resume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeActionPerformed(evt);
            }
        });

        pause.setBackground(new java.awt.Color(255, 255, 255));
        pause.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pause.setForeground(new java.awt.Color(51, 153, 255));
        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause-24.png"))); // NOI18N
        pause.setText("Pause");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        stop.setBackground(new java.awt.Color(255, 255, 255));
        stop.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stop.setForeground(new java.awt.Color(51, 153, 255));
        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/20140718023457154_easyicon_net_24.png"))); // NOI18N
        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        scanninggif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajax-loade.gif"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel24.setText("SCAN ");

        lbl_freespace.setText("Free Space Recovered");

        lbl_freespacegained.setBackground(new java.awt.Color(255, 255, 255));
        lbl_freespacegained.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        quicktext1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quicktext1.setForeground(new java.awt.Color(51, 51, 0));
        quicktext1.setText("System Scan");

        lbl_userext.setText("Type the list of extensions you want to search");

        javax.swing.GroupLayout scanpaneLayout = new javax.swing.GroupLayout(scanpane);
        scanpane.setLayout(scanpaneLayout);
        scanpaneLayout.setHorizontalGroup(
            scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scanpaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quicktext1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1028, 1028, 1028))
            .addGroup(scanpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scanpaneLayout.createSequentialGroup()
                        .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(scanpaneLayout.createSequentialGroup()
                                .addComponent(pause)
                                .addGap(18, 18, 18)
                                .addComponent(resume)
                                .addGap(36, 36, 36)
                                .addComponent(stop))
                            .addGroup(scanpaneLayout.createSequentialGroup()
                                .addComponent(btn_result)
                                .addGap(18, 18, 18)
                                .addComponent(startscan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(choose_txtlbl)
                            .addGroup(scanpaneLayout.createSequentialGroup()
                                .addComponent(lbl_freespace)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filesnos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_freespacegained, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(scanpaneLayout.createSequentialGroup()
                                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, scanpaneLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ext_txt)
                                            .addGroup(scanpaneLayout.createSequentialGroup()
                                                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel24)
                                                    .addComponent(lbl_userext))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addComponent(directorytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choose_btn)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(scanpaneLayout.createSequentialGroup()
                        .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(scanpaneLayout.createSequentialGroup()
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(percent))
                            .addComponent(jLabel23)
                            .addGroup(scanpaneLayout.createSequentialGroup()
                                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statuslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scanninggif)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        scanpaneLayout.setVerticalGroup(
            scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scanpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(scanpaneLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_userext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ext_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quicktext1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(choose_txtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(scanpaneLayout.createSequentialGroup()
                        .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choose_btn)
                            .addComponent(directorytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(percent)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addGap(4, 4, 4)
                        .addComponent(statuslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scanninggif))
                .addGap(24, 24, 24)
                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filesnos, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_freespacegained, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_freespace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pause)
                    .addComponent(resume)
                    .addComponent(stop))
                .addGap(10, 10, 10)
                .addGroup(scanpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_result, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startscan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("     Scan         ", new javax.swing.ImageIcon(getClass().getResource("/MagnifyingGlass.png")), scanpane); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setText("RESULTS");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        result.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(result);

        btn_editresult.setBackground(new java.awt.Color(255, 255, 255));
        btn_editresult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_editresult.setForeground(new java.awt.Color(255, 0, 0));
        btn_editresult.setText("EDIT and DELETE files");
        btn_editresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editresultActionPerformed(evt);
            }
        });

        jLabel18.setText("Free Space recovered");

        back_results.setBackground(new java.awt.Color(255, 255, 255));
        back_results.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back_results.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back-icon.png"))); // NOI18N
        back_results.setText("Back");
        back_results.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_resultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resultspaneLayout = new javax.swing.GroupLayout(resultspane);
        resultspane.setLayout(resultspaneLayout);
        resultspaneLayout.setHorizontalGroup(
            resultspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultspaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(resultspaneLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(btn_editresult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_freespacegained1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(back_results, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        resultspaneLayout.setVerticalGroup(
            resultspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultspaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(resultspaneLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(resultspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_freespacegained1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_editresult)))
                    .addComponent(back_results, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("     Results         ", new javax.swing.ImageIcon(getClass().getResource("/copy doc.png")), resultspane); // NOI18N

        toolspane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Tools");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Customise your friends PC cleaner tools settings ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("Please select the category you want to run ");

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Disk Cleaner");

        format_drive.setBackground(new java.awt.Color(255, 255, 255));
        format_drive.setText("Format Removable Drives");
        format_drive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                format_driveActionPerformed(evt);
            }
        });

        chk_ext.setBackground(new java.awt.Color(255, 255, 255));
        chk_ext.setText("Find Files with Specified Extension");

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Registry Defragment");

        internethistory.setBackground(new java.awt.Color(255, 255, 255));
        internethistory.setText("Internet History Cleaner");

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 0, 0));
        jButton6.setText("Use Tool");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toolspaneLayout = new javax.swing.GroupLayout(toolspane);
        toolspane.setLayout(toolspaneLayout);
        toolspaneLayout.setHorizontalGroup(
            toolspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolspaneLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(toolspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toolspaneLayout.createSequentialGroup()
                        .addGroup(toolspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(toolspaneLayout.createSequentialGroup()
                        .addGroup(toolspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox4))
                        .addGap(18, 18, 18)
                        .addGroup(toolspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(internethistory)
                            .addGroup(toolspaneLayout.createSequentialGroup()
                                .addComponent(format_drive)
                                .addGap(18, 18, 18)
                                .addComponent(chk_ext)))
                        .addContainerGap(397, Short.MAX_VALUE))))
        );
        toolspaneLayout.setVerticalGroup(
            toolspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolspaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(34, 34, 34)
                .addGroup(toolspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(format_drive)
                    .addComponent(chk_ext))
                .addGap(30, 30, 30)
                .addGroup(toolspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(internethistory))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("       Tools          ", new javax.swing.ImageIcon(getClass().getResource("/gtk_preferences.png")), toolspane); // NOI18N

        settingspane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Settings");

        autostartup.setBackground(new java.awt.Color(255, 255, 255));
        autostartup.setText("Auto StartUp");
        autostartup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autostartupActionPerformed(evt);
            }
        });

        selectall.setBackground(new java.awt.Color(255, 255, 255));
        selectall.setText("Select All");
        selectall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectallActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        systemrelatederror.setBackground(new java.awt.Color(255, 255, 255));
        systemrelatederror.setText("System Related Errors");
        systemrelatederror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systemrelatederrorActionPerformed(evt);
            }
        });

        registryerrors.setBackground(new java.awt.Color(255, 255, 255));
        registryerrors.setText("Registry related Errors");
        registryerrors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registryerrorsActionPerformed(evt);
            }
        });

        comandactivex.setBackground(new java.awt.Color(255, 255, 255));
        comandactivex.setText("Other Errors");
        comandactivex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comandactivexActionPerformed(evt);
            }
        });

        userrelated.setBackground(new java.awt.Color(255, 255, 255));
        userrelated.setText("User Related Errors");
        userrelated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userrelatedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(systemrelatederror)
                    .addComponent(registryerrors))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comandactivex)
                    .addComponent(userrelated))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(systemrelatederror)
                    .addComponent(comandactivex))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registryerrors)
                    .addComponent(userrelated))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 255));
        jButton5.setText("APPLY");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingspaneLayout = new javax.swing.GroupLayout(settingspane);
        settingspane.setLayout(settingspaneLayout);
        settingspaneLayout.setHorizontalGroup(
            settingspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingspaneLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(settingspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jLabel4)
                    .addComponent(selectall)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autostartup))
                .addContainerGap(536, Short.MAX_VALUE))
        );
        settingspaneLayout.setVerticalGroup(
            settingspaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingspaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(autostartup)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("       Settings         ", new javax.swing.ImageIcon(getClass().getResource("/application_x_desktop.png")), settingspane); // NOI18N

        registerpane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Register Now");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setText("Already have license key");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("if you already have a license key then enter it in the box below ");

        LICENCEKEY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LICENCEKEYActionPerformed(evt);
            }
        });
        LICENCEKEY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                licence_dash(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Register now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Need a License key");

        jLabel10.setText("<html>We recommend that you upgrade to the full version of the System Scaner to clean <br>all infections from your PC.Other benefits include security from infections,<br>multiple sheilds protecting your PC and keeps hackers and intruders out.</html>");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 255));
        jButton2.setText("Buy now");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Click buy now and clean all PC errors");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("License key");

        jLabel37.setText(" XXXX-XXXX-XXXX");

        javax.swing.GroupLayout registerpaneLayout = new javax.swing.GroupLayout(registerpane);
        registerpane.setLayout(registerpaneLayout);
        registerpaneLayout.setHorizontalGroup(
            registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerpaneLayout.createSequentialGroup()
                .addGroup(registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerpaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(registerpaneLayout.createSequentialGroup()
                                .addGroup(registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(registerpaneLayout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerpaneLayout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(138, 138, 138)))
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(registerpaneLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registerpaneLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel7))
                            .addGroup(registerpaneLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LICENCEKEY, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(registerpaneLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel9))
                            .addGroup(registerpaneLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerpaneLayout.setVerticalGroup(
            registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LICENCEKEY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(4, 4, 4)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(registerpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerpaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(registerpaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("   Register    ", new javax.swing.ImageIcon(getClass().getResource("/register.png")), registerpane); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel26.setText("Created By ");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/screedbot (1).gif"))); // NOI18N

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatar947990_1.gif"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/screedbotashish.gif"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/screedbothemant.gif"))); // NOI18N
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/screedbotneeraj.gif"))); // NOI18N
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/screedbotvinayak.gif"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Email: ashish2199@gmail.com");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("Email: h.nigam654@gmail.com");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Email: neerajkumarmsit@gmail.com");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Email: vinayaksharma280@gmail.com");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addGap(155, 155, 155)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26))
                    .addComponent(jLabel28))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel34)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(28, 28, 28)))
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel36)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("     Created By            ", new javax.swing.ImageIcon(getClass().getResource("/Users-icon.png")), jPanel5); // NOI18N

        jScrollPane3.setViewportView(jList1);

        remove.setBackground(new java.awt.Color(255, 255, 255));
        remove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        remove.setText("Remove Files");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        finalise.setBackground(new java.awt.Color(255, 255, 255));
        finalise.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        finalise.setForeground(new java.awt.Color(255, 0, 0));
        finalise.setText("DELETE Files");
        finalise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finaliseActionPerformed(evt);
            }
        });

        back_edit.setBackground(new java.awt.Color(255, 255, 255));
        back_edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back_edit.setForeground(new java.awt.Color(51, 0, 0));
        back_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back-icon.png"))); // NOI18N
        back_edit.setText("Back");
        back_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editresultsLayout = new javax.swing.GroupLayout(editresults);
        editresults.setLayout(editresultsLayout);
        editresultsLayout.setHorizontalGroup(
            editresultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editresultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editresultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editresultsLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(editresultsLayout.createSequentialGroup()
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)
                        .addComponent(finalise)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234))))
        );
        editresultsLayout.setVerticalGroup(
            editresultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editresultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editresultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(remove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finalise, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("    Edit and Delete Results  ", new javax.swing.ImageIcon(getClass().getResource("/edit.png")), editresults); // NOI18N

        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jList2);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 51, 51));
        jButton7.setText("Format");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 0, 51));
        jButton8.setText("Detect");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        progressing2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processing.gif"))); // NOI18N

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 51, 51));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back-icon.png"))); // NOI18N
        jButton9.setText("Back");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        per2.setText("     0 %");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Current File");

        javax.swing.GroupLayout format_deviceLayout = new javax.swing.GroupLayout(format_device);
        format_device.setLayout(format_deviceLayout);
        format_deviceLayout.setHorizontalGroup(
            format_deviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(format_deviceLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(format_deviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(format_deviceLayout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addComponent(jButton9))
                    .addGroup(format_deviceLayout.createSequentialGroup()
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(per2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressing2))
                    .addComponent(pendrive_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        format_deviceLayout.setVerticalGroup(
            format_deviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(format_deviceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendrive_status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(format_deviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressing2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(per2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(format_deviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(format_deviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Format External Device", new javax.swing.ImageIcon(getClass().getResource("/usb-icon.png")), format_device); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        if(homepane.isShowing())
        {
            homepane.getRootPane().setDefaultButton(jButton3);
        }

        if(settingspane.isShowing())
        {
            settingspane.getRootPane().setDefaultButton(jButton5);
        }
        if(registerpane.isShowing())
        {
            registerpane.getRootPane().setDefaultButton(jButton1);
        }
        if(scan_tab==1)
            {   
                scanpane.getRootPane().setDefaultButton(startscan_btn);
                
            }
            if(scan_tab==2)
            {  
                scanpane.getRootPane().setDefaultButton(btn_result);
            }

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("http://www.facebook.com/friendspcclean");
            desktop.browse(oURL);
        } catch (URISyntaxException | IOException e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Scanner input=new Scanner(System.in);
        if(LICENCEKEY.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter Licence Key", null, JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            if(LICENCEKEY.getText().length()<8||LICENCEKEY.getText().length()>14)
            {
                JOptionPane.showMessageDialog(null, "Invalid Licence Key",null, JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                char c=0;
                int count=0;
                int f=0;

                for(int i=0;i<LICENCEKEY.getText().length();i++)
                {
                    if(i==4||i==9)
                    {
                        i++;
                    }
                    char cc = LICENCEKEY.getText().charAt(i);

                    if(Character.isLetterOrDigit(cc))
                    {
                        f=1;
                    }
                    else
                    {
                        f=2;
                        break;
                    }
                    c++;

                }
                //JOptionPane.showMessageDialog(null, f);
                if(f==1)
                {
                    JOptionPane.showMessageDialog(null, "Accepted", null,JOptionPane.WARNING_MESSAGE,new ImageIcon("check-icon.png"));
                    jTabbedPane1.removeTabAt(4);
                    try {

                        Desktop desktop = java.awt.Desktop.getDesktop();
                        URI oURL = new URI("http://www.google.com");

                        desktop.browse(oURL);
                    }
                    catch (URISyntaxException | IOException e)
                    {
                        JOptionPane.showMessageDialog(null, e.toString(),null,JOptionPane.WARNING_MESSAGE);
                    }

                    //JOptionPane.showMessageDialog(null, "111");

                }
                if(f==2)
                {
                    JOptionPane.showMessageDialog(null, "Not Accepetd",null, JOptionPane.ERROR_MESSAGE);
                }

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void licence_dash(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_licence_dash
        String obj= LICENCEKEY.getText();

        if(LICENCEKEY.getText().length()==4||LICENCEKEY.getText().length()==9)
        {
            LICENCEKEY.setText(obj+"-");
        }
        if(LICENCEKEY.getText().length()==14)
        {
            LICENCEKEY.setEditable(false);
        }

        char key= evt.getKeyChar();
        int k=key;

        if(k==KeyEvent.VK_BACK_SPACE)
        {
            LICENCEKEY.setEditable(true);
        }

    }//GEN-LAST:event_licence_dash

    private void LICENCEKEYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LICENCEKEYActionPerformed

    }//GEN-LAST:event_LICENCEKEYActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if(autostartup.isSelected()){

            try{copyFileUsingStream();
            }
            catch(IOException ie){

            }
        }

        else{
           //if(!autostartup.isSelected()){
            try{
                final String user = System.getProperty("user.name");
                File file = new File("C:\\ProgramData\\Microsoft\\Windows\\"
              + "Start Menu\\Programs\\StartUp\\pccleaner.lnk");

                    if(file.delete()){
                        System.out.println(file.getName() + " is deleted!");
                    }else{
                        System.out.println("Delete operation is failed.");
                    }

                }catch(Exception e){
                }
            
            //}
        }
            JOptionPane.showMessageDialog(null, "apply",null,JOptionPane.WARNING_MESSAGE,new ImageIcon("check-icon.png"));       // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void userrelatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userrelatedActionPerformed
        settingspane.getRootPane().setDefaultButton(jButton5);

        if(registryerrors.isSelected()&&systemrelatederror.isSelected()&&comandactivex.isSelected())
        {
            selectall.setSelected(true);
        }
        else
        {
            selectall.setSelected(false);
        }
        if(!userrelated.isSelected())
        {
            selectall.setSelected(false);
        }
    }//GEN-LAST:event_userrelatedActionPerformed

    private void comandactivexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comandactivexActionPerformed
        settingspane.getRootPane().setDefaultButton(jButton5);

        if(registryerrors.isSelected()&&systemrelatederror.isSelected()&&userrelated.isSelected())
        {
            selectall.setSelected(true);
        }
        else
        {
            selectall.setSelected(false);
        }
        if(!comandactivex.isSelected())
        {
            selectall.setSelected(false);
        }
    }//GEN-LAST:event_comandactivexActionPerformed

    private void registryerrorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registryerrorsActionPerformed
        settingspane.getRootPane().setDefaultButton(jButton5);

        if(comandactivex.isSelected()&&systemrelatederror.isSelected()&&userrelated.isSelected())
        {
            selectall.setSelected(true);
        }
        else
        {
            selectall.setSelected(false);
        }
        if(!registryerrors.isSelected())
        {
            selectall.setSelected(false);
        }

    }//GEN-LAST:event_registryerrorsActionPerformed

    private void systemrelatederrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systemrelatederrorActionPerformed
        settingspane.getRootPane().setDefaultButton(jButton5);
        if(registryerrors.isSelected()&&comandactivex.isSelected()&&userrelated.isSelected())
        {
            selectall.setSelected(true);
        }
        else
        {
            selectall.setSelected(false);
        }
        if(!systemrelatederror.isSelected())
        {
            selectall.setSelected(false);
        }
    }//GEN-LAST:event_systemrelatederrorActionPerformed

    private void selectallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectallActionPerformed
        settingspane.getRootPane().setDefaultButton(jButton5);

        if(selectall.isSelected()){
            userrelated.setSelected(true);
            registryerrors.setSelected(true);
            systemrelatederror.setSelected(true);
            comandactivex.setSelected(true);
        }
        if(!selectall.isSelected()){
            userrelated.setSelected(false);
            registryerrors.setSelected(false);
            systemrelatederror.setSelected(false);
            comandactivex.setSelected(false);
        }
        /*if( !userrelated.isSelected()||!registryerrors.isSelected()|| !systemrelatederror.isSelected()||!comandactivex.isSelected())
        {    JOptionPane.showMessageDialog(null, "1");
            selectall.setSelected(false);
        }
        if( userrelated.isSelected()&&registryerrors.isSelected()&&systemrelatederror.isSelected()&&comandactivex.isSelected())
        {   JOptionPane.showMessageDialog(null, "2");
            selectall.isSelected();
        }*/
        // TODO add your handling code here:
    }//GEN-LAST:event_selectallActionPerformed

    private void autostartupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autostartupActionPerformed
        settingspane.getRootPane().setDefaultButton(jButton5);
    }//GEN-LAST:event_autostartupActionPerformed
   
    /*public void deletehistory(File file){
    
    if(file.isDirectory()){
    deletehistory(file);
    }
    else{
    File[] list = file.listFiles();
    for(File fi  : list)
    {
    fi.delete();
    }
    }
    
    }*/
    
    
    
    
    public void internet()
   {
       System.out.println("running");
            final String user = System.getProperty("user.name");
            File historyfile = new File("C:\\users\\"+user+"\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
            System.out.println(historyfile.toString());
                
            if(historyfile.delete()){
            
                System.out.println(historyfile.getName() + " is deleted!");
            }else{
            System.out.println("Delete operation is failed.");
            }
            //deletehistory(historyfile);
   }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(internethistory.isSelected()){
             internet();

            }
        
        if(format_drive.isSelected())
        {     
       jTabbedPane1.removeTabAt(2);
       jTabbedPane1.insertTab("   Format External Device   ",new ImageIcon("usb-icon.png"),format_device,null, 2);
       jTabbedPane1.setSelectedIndex(2);
       
        }
        if(chk_ext.isSelected()){
           ext_no=1;
            custom_rbtn.setSelected(true);
            quicktext2.setVisible(false);
            quickstart_bu.setVisible(false);
            
            
            jTabbedPane1.setEnabledAt(1, true);
            
            
          jTabbedPane1.setSelectedIndex(1);
          
          show_tab();
         
      
              
        for(int p=0;p<fexts.length;p++){
            String tempext = fexts[p].toLowerCase();
            fexts[p]=tempext;    
            
          ext_txt.setVisible(true);
          lbl_userext.setVisible(true);
          
        } 
        
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed
    
      
             
    private void finaliseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finaliseActionPerformed

        DefaultListModel mode = (DefaultListModel) jList1.getModel();
        ListModel model = jList1.getModel();

        for(int i=0; i < model.getSize(); i++){
            Object o =  model.getElementAt(i);
            //JOptionPane.showMessageDialog(null, o.toString());
            File directory = new File(o.toString());

            if(directory.delete()){

                System.out.println(directory.getName() + " is deleted!");

                mode.removeAllElements();
                JOptionPane.showMessageDialog(null,"Files deleted",null,JOptionPane.INFORMATION_MESSAGE,new ImageIcon("check-icon.png"));

            }else{
                System.out.println("Delete operation is failed.");
                JOptionPane.showMessageDialog(null, "Delete operation is failed.", null, JOptionPane.ERROR_MESSAGE);
            }

            //System.out.println(o);

            // use delete function here
        }

        /*
        for(Object s:filestobedeleted)
        { //message.concat(s.toString());
            // message.concat("\n");
            JOptionPane.showConfirmDialog(null, s.toString());
        }
        System.out.println(message);
        //JOptionPane.showConfirmDialog(null, message);
        */
    }//GEN-LAST:event_finaliseActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed

        DefaultListModel model = (DefaultListModel) jList1.getModel();
        /*int selectedIndex[] = jList1.getSelectedIndices();
        System.out.println("THE number of indexes selected :"+selectedIndex.length);
        for(int i=0;i<selectedIndex.length;i++)
        {
            System.out.print("\n Indexes :"+selectedIndex[i]);
        }
        for(int i=0;i<=(selectedIndex.length-1);i++)
        {
            if (selectedIndex[i] != -1)
            {
                //System.out.print("\nRemoved Indexes :"+selectedIndex[i]);
                //model.remove(selectedIndex[i]);
            }
        }   */
        List selectedvalues;
        selectedvalues = jList1.getSelectedValuesList();
        for(Object s:selectedvalues)
        {

            int n=jList1.getModel().getSize();

            for(int i=0;i<n;i++)
            {
                String v = model.getElementAt(i).toString();

                if(s.equals(v)){
                    System.out.print("\nV :"+v);
                    model.remove(i);
                    n--;
                }
            }
        }

    }//GEN-LAST:event_removeActionPerformed

    private void btn_editresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editresultActionPerformed
        edit_tab=1;
       jTabbedPane1.removeTabAt(1);
       jTabbedPane1.insertTab("   Edit and Delete Results   ",new ImageIcon("edit.png"),editresults,null, 1);
       jTabbedPane1.setSelectedIndex(1);
      //  jTabbedPane1.addTab("Edit and Delete Results", new ImageIcon("edit.png"), editresults);
      //  jTabbedPane1.setSelectedIndex(7);

    }//GEN-LAST:event_btn_editresultActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        abortProcessing = true;
       
        
    }//GEN-LAST:event_stopActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
     pauseProcessing = true;
     //JOptionPane.showMessageDialog(null,pause.isSelected());
    }//GEN-LAST:event_pauseActionPerformed

    private void resumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeActionPerformed
           
      
   pauseProcessing=false;
       
    }//GEN-LAST:event_resumeActionPerformed

    private void choose_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose_btnActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        File f = chooser.getCurrentDirectory();
        filename = f.getAbsolutePath();
        directorytxt.setText(filename);        // TODO add your handling code here:
    }//GEN-LAST:event_choose_btnActionPerformed

    private void btn_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resultActionPerformed
        scan_tab=3;
        result_tab=1;
        ImageIcon img= new ImageIcon("copy doc.png");
        jTabbedPane1.removeTabAt(1);
       jTabbedPane1.insertTab("   Results   ", img, resultspane,null, 1);
       jTabbedPane1.setSelectedIndex(1);
        //jTabbedPane1.addTab("       Results     ",img, resultspane);
       // jTabbedPane1.setSelectedIndex(6);
        //   jTabbedPane1.setEnabledAt(2, true);

        try{        //JOptionPane.showMessageDialog(null, "File reading started");
            FileReader fr = new FileReader("C:\\filenames.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ;
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
                jTextArea1.append(line+"\n");
            }

        } catch(IOException e){}
        if(scan_tab==3)
        {
            resultspane.getRootPane().setDefaultButton(btn_editresult);
        }
        //resultspane.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resultActionPerformed

    private void startscan_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startscan_btnActionPerformed
        //JOptionPane.showMessageDialog(null,"START");
        scan_tab=2;
        firsttime=1;
        if(custom_rbtn.isSelected())
        {     
              if(ext_no==1)
              {   if(ext_txt.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Please enter the extensions before starting scan", "User Action performed",JOptionPane.WARNING_MESSAGE);
              }
              else{String tempexts = ext_txt.getText();
                  exts = tempexts.split(",");
                  fexts=null;
                 fexts=exts.clone();}
              }
        
            if(directorytxt.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "choose directory to scan",null,JOptionPane.WARNING_MESSAGE);

            }
            else { 
                abortProcessing = false;
                 pauseProcessing = false;
                 
                taskInfinite = new ProgressInfinite();
                taskInfinite.execute();
                pause.setSelected(false);
                pause.setVisible(true);
                resume.setVisible(true);
                stop.setVisible(true);
                scanninggif.setVisible(true);
                choose_btn.setVisible(false);
                directorytxt.setVisible(false);
                choose_txtlbl.setVisible(false);
                scanninggif.setVisible(true);
                startscan_btn.setVisible(false);
            }
        }
        if(full_rbtn.isSelected()||quickscan.isSelected()){
            taskInfinite = new ProgressInfinite();
            taskInfinite.execute();
            pause.setVisible(true);
            resume.setVisible(true);
            stop.setVisible(true);
            scanninggif.setVisible(true);
            choose_btn.setVisible(false);
            directorytxt.setVisible(false);
            choose_txtlbl.setVisible(false);
            scanninggif.setVisible(true);
            startscan_btn.setVisible(false);
        }
        /*if(chk_ext.isSelected()){
        if(directorytxt.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "choose directory to scan",null,JOptionPane.WARNING_MESSAGE);

            }
            else { 

            directorytxt.setVisible(true);
            choose_btn.setVisible(true);
            choose_txtlbl.setVisible(false);
            startscan_btn.setVisible(true);
            
               String[] fexts=null;
               String[] exts=fexts.clone();
                abortProcessing = false;
                pauseProcessing = false;
                lbl_freespace.setVisible(false);
                lbl_freespacegained.setVisible(false);
                taskInfinite = new ProgressInfinite();
                taskInfinite.execute();
                pause.setSelected(false);
                pause.setVisible(true);
                resume.setVisible(true);
                stop.setVisible(true);
                scanninggif.setVisible(true);
                choose_btn.setVisible(false);
                directorytxt.setVisible(false);
                choose_txtlbl.setVisible(false);
                scanninggif.setVisible(true);
                startscan_btn.setVisible(false);
            }
        
        }*/
       
        
    }//GEN-LAST:event_startscan_btnActionPerformed

    private void quickscanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickscanActionPerformed

    }//GEN-LAST:event_quickscanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        scan_tab =1;
        if(firsttime==0||firsttime==2)
        {
        if(full_rbtn.isSelected()||custom_rbtn.isSelected()||quickscan.isSelected())
        {
            
            quicktext2.setVisible(false);
            quickstart_bu.setVisible(false);
            
            
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
            

        }
        show_tab();
         
        
        for(int p=0;p<fexts.length;p++){
            String tempext = fexts[p].toLowerCase();
            fexts[p]=tempext;
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Scanning is in Progress", null, JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void custom_rbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_rbtnActionPerformed
        
    }//GEN-LAST:event_custom_rbtnActionPerformed

    private void full_rbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_full_rbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_full_rbtnActionPerformed

    private void back_resultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_resultsActionPerformed
        jTabbedPane1.removeTabAt(1);
        jTabbedPane1.insertTab("  Scan  ", new ImageIcon("MagnifyingGlass.png"), scanpane, null, 1);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_back_resultsActionPerformed

    private void back_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_editActionPerformed
        jTabbedPane1.removeTabAt(1);
        jTabbedPane1.insertTab("  Results  ", new ImageIcon("copy doc.png"),resultspane, null, 1);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_back_editActionPerformed

    private void scan_again(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_again
        if(firsttime==1)
        {
            JOptionPane.showConfirmDialog(null, "enter");

        }
    }//GEN-LAST:event_scan_again

    private void format_driveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_format_driveActionPerformed
        
    }//GEN-LAST:event_format_driveActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
           String driveLetter = ""; 
             FileSystemView fsv = FileSystemView.getFileSystemView();
				
                File[] f = File.listRoots();
                    for (int i = 0; i < f.length; i++) 
                    {
                                final String drive = f[i].getPath();
                                final String displayName = fsv.getSystemDisplayName(f[i]);
                                String type = fsv.getSystemTypeDescription(f[i]);
                                boolean isDrive = fsv.isDrive(f[i]);
                                boolean isFloppy = fsv.isFloppyDrive(f[i]);
                                boolean canRead = f[i].canRead();
                                boolean canWrite = f[i].canWrite();
                                
                                
                                    if (canRead && canWrite && !isFloppy && isDrive && (type.toLowerCase().contains("removable") || type.toLowerCase().contains("rimovibile"))) 
                                    {       jList2.setModel(new javax.swing.AbstractListModel() {
                                            String[] strings = { "Detected Drive: " + drive + " - "+ displayName };

                                            @Override
                                            public Object getElementAt(int i) { return strings[i]; }

                                            @Override
                                                     public int getSize() {
                                                      return strings.length;  
                                                    }
                                                });
                                            //System.out.println("Detected Drive: " + drive + " - "+ displayName);
                                             driveLetter = drive;
                                             break;
                                    }
                                
                      }
                      
                                    if (driveLetter.equals("")) {
                                        JOptionPane.showMessageDialog(null, "No External Device found", null, JOptionPane.WARNING_MESSAGE);

                                    }      
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
              
             taskInfinite2 = new ProgressInfinite2();
                taskInfinite2.execute();
        
        
                   
         
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jTabbedPane1.removeTabAt(2);
        jTabbedPane1.insertTab("  Tools         ", new ImageIcon("gtk_preferences.png"),toolspane, null, 2);
        jTabbedPane1.setSelectedIndex(2);       
    }//GEN-LAST:event_jButton9ActionPerformed
    
    
    public  void quicktab()
  {   
    
        startscan_btn.setVisible(true);
              resume.setVisible(false);
              stop.setVisible(false);
              pause.setVisible(false);
              btn_result.setVisible(false);
              directorytxt.setVisible(false);
               choose_btn.setVisible(false);
               scanninggif.setVisible(false);
               full_rbtn.setSelected(false);
               jProgressBar1.setValue(0);
            percent.setText("0%");
            statuslbl.setText("");
            filesnos.setText("");
            lbl_freespacegained.setText("");
            choose_txtlbl.setVisible(false);
  }
  
  
  public void show_tab()
  {
      if(full_rbtn.isSelected())

        {   jTabbedPane1.removeTabAt(1);
            jTabbedPane1.insertTab("     Scan     ", new ImageIcon("MagnifyingGlass.png"), scanpane, null, 1);
            quicktext1.setVisible(false);

            choose_txtlbl.setVisible(false);
            startscan_btn.setVisible(true);
            jTabbedPane1.setSelectedIndex(1);
            directorytxt.setVisible(false);
            choose_btn.setVisible(false);
            scanninggif.setVisible(false);
            full_rbtn.setSelected(false);
            jProgressBar1.setValue(0);
            percent.setText("0%");
            statuslbl.setText("");
            filesnos.setText("");
            lbl_freespacegained.setText("");
             btn_result.setVisible(false);
        }

        else if(custom_rbtn.isSelected()){
            jTabbedPane1.removeTabAt(1);
            jTabbedPane1.insertTab("     Scan     ", new ImageIcon("MagnifyingGlass.png"), scanpane, null, 1);
            quicktext1.setVisible(false);
            jTabbedPane1.setSelectedIndex(1);
            directorytxt.setVisible(true);
            choose_btn.setVisible(true);
            choose_txtlbl.setVisible(false);
            startscan_btn.setVisible(true);
            scanninggif.setVisible(false);
            custom_rbtn.setSelected(false);
            jProgressBar1.setValue(0);
            percent.setText("0%");
            statuslbl.setText("");
            filesnos.setText("");
            lbl_freespacegained.setText("");
            directorytxt.setText("");
            choose_txtlbl.setVisible(true);
            btn_result.setVisible(false);
        }
        else 
        {   jTabbedPane1.removeTabAt(1);
            jTabbedPane1.insertTab("     Scan     ", new ImageIcon("MagnifyingGlass.png"), scanpane, null, 1);
            quicktext1.setVisible(true);

            startscan_btn.setVisible(true);
            jTabbedPane1.setSelectedIndex(1);
            directorytxt.setVisible(false);
            choose_btn.setVisible(false);
            scanninggif.setVisible(false);
            full_rbtn.setSelected(false);
            jProgressBar1.setValue(0);
            percent.setText("0%");
            statuslbl.setText("");
            filesnos.setText("");
            lbl_freespacegained.setText("");
            choose_txtlbl.setVisible(false);
            btn_result.setVisible(false);
        }
        
      
  }
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
         try{
          UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
             
            
            gui gui = new gui();
        }
                  catch (ParseException | UnsupportedLookAndFeelException e) {
				      System.err.println("Look and feel not set.");
				    }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new gui().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LICENCEKEY;
    private javax.swing.JCheckBox autostartup;
    private javax.swing.JButton back_edit;
    private javax.swing.JButton back_results;
    private javax.swing.JButton btn_editresult;
    private javax.swing.JButton btn_result;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chk_ext;
    private javax.swing.JButton choose_btn;
    private javax.swing.JLabel choose_txtlbl;
    private javax.swing.JCheckBox comandactivex;
    private javax.swing.JRadioButton custom_rbtn;
    private javax.swing.JTextField directorytxt;
    private javax.swing.JPanel editresults;
    private javax.swing.JTextField ext_txt;
    private javax.swing.JLabel filesnos;
    private javax.swing.JButton finalise;
    private javax.swing.JPanel format_device;
    private javax.swing.JCheckBox format_drive;
    private javax.swing.JRadioButton full_rbtn;
    private javax.swing.JPanel homepane;
    private javax.swing.JCheckBox internethistory;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JLabel lastscan;
    private javax.swing.JLabel lbl_freespace;
    private javax.swing.JLabel lbl_freespacegained;
    private javax.swing.JLabel lbl_freespacegained1;
    private javax.swing.JLabel lbl_userext;
    private javax.swing.JButton pause;
    private javax.swing.JLabel pendrive_status;
    private javax.swing.JLabel per2;
    private javax.swing.JLabel percent;
    private javax.swing.JLabel progressing2;
    private javax.swing.JRadioButton quickscan;
    private javax.swing.JButton quickstart_bu;
    private javax.swing.JLabel quicktext1;
    private javax.swing.JLabel quicktext2;
    private javax.swing.JPanel registerpane;
    private javax.swing.JCheckBox registryerrors;
    private javax.swing.JButton remove;
    private javax.swing.JTree result;
    private javax.swing.JPanel resultspane;
    private javax.swing.JButton resume;
    private javax.swing.JRadioButton samplerad;
    private javax.swing.JLabel scanerrors;
    private javax.swing.JLabel scanninggif;
    private javax.swing.JPanel scanpane;
    private javax.swing.JCheckBox selectall;
    private javax.swing.JPanel settingspane;
    private javax.swing.JButton startscan_btn;
    private javax.swing.JLabel statuslbl;
    private javax.swing.JButton stop;
    private javax.swing.JCheckBox systemrelatederror;
    private javax.swing.JPanel toolspane;
    private javax.swing.JCheckBox userrelated;
    // End of variables declaration//GEN-END:variables
}