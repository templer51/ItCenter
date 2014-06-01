package company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExportImport implements IEmployee {


	public static void writeLine (String word[], File file ) throws IOException{	
		FileWriter fw = new FileWriter(file);
	
		for(int i=0;i<word.length;i++){
			String line = word[i];
				fw.write(line);
			}
		
		fw.flush();
	}
	
	public static  String enterLine (){	
		Scanner sc = new Scanner(System.in);
		System.out.println("EnterLine");
		String word = sc.nextLine();
		System.out.println(word);
		System.out.println("/n");
		sc.close();
		return  word;
	}
	
	public static String[]  readLine(File file) throws FileNotFoundException{
		FileReader fw = new FileReader(file);
		String[] word=new String[20];
		Scanner sc = new Scanner(fw);
		for(int i=0;i<word.length;i++){
		word [i]  = sc.nextLine();
		}return word;
	}
	/*
	public static String[] delLine (String [] mass){
		Scanner sc = new Scanner(System.in);
		System.out.println("Del line number-");
		int index= sc.nextInt();
		for(int i=index;i<mass.length-1;i++){
			mass[index]=mass[index+1];
		}
		mass[index]=null;
		
		
		
		return mass;
	}
	*/
	public static String[] newLine (String [] mass){
		Scanner sc = new Scanner(System.in);
		String [] mass1 = mass;
		System.out.println("EnterLine ");
		mass1[mass1.length-1]=sc.nextLine();
		return mass1;
	}

	public static void showMas(String [] mas){
		
		for(int i =0;i<mas.length;i++){
			System.out.println(mas[i]);
		}
		
		
	}	
}