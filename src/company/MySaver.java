package company;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class MySaver  {

	 private static String fileName = "D:/t.txt"; 
	 
	/**Serialize file*/
	  public static void save(ArrayList<Employee> empl){
	   FileOutputStream fos = null;
	   ObjectOutputStream oos = null;
	   
	   try{
	    fos = new FileOutputStream(fileName);
	    oos = new ObjectOutputStream(fos);
	    oos.writeObject(empl);
	    } catch(FileNotFoundException e){
	    System.out.println("File not found");
	    e.printStackTrace();
	   } catch(IOException ioe){
	    ioe.printStackTrace();
	   } finally {
	    if(oos != null){
	     try {
	      oos.close();
	     } catch (IOException e) {
	      e.printStackTrace();
	     }    
	    }
	    if(fos != null){
	     try {
	      fos.close();
	     } catch (IOException e) {
	      e.printStackTrace();
	     }    
	    }
	   }
	  }

	  /**Deserialize file*/
	  @SuppressWarnings("unchecked")
	  public static ArrayList<Employee> load(){
	   FileInputStream fis = null;
	   ObjectInputStream ois = null;
	   ArrayList<Employee> emploee = null;
	   try{
	    fis = new FileInputStream(fileName);
	    ois = new ObjectInputStream(fis);
	    Object o = ois.readObject();
	    emploee = (ArrayList<Employee>)o;
	   } catch(FileNotFoundException ex){
	    System.out.println("File not found!");
	   }  catch(Exception e) {
	    e.printStackTrace();
	   } finally {
	    if(ois != null){
	     try {
	      ois.close();
	     } catch (IOException e) {
	      e.printStackTrace();
	     }    
	    }
	    if(fis != null){
	     try {
	      fis.close();
	     } catch (IOException e) {
	      e.printStackTrace();
	     }    
	    }
	   }
	   return emploee;
	  }
	  
}