package lockedme;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.lang.String;


public class phase1assignment {
	public static final String dir = "C:\\Users\\Murugan_Sundaram\\simplelearn-workspace\\Assignment1\\Myfiles";

	public static void main(String[] args) {
		mainscreen();
		navigation();
	}

	public static void mainscreen() {
		// -------------------- Main Screen Design
		System.out.println("-----------------------------------------------------------------");
		System.out.print("|");
		System.out.format("\t \t LockedMe.com -- Lockers Pvt Ltd. \t \t");
		System.out.println("|");
		System.out.print("|");
		System.out.format("\t \t Developer : Murugan.S. \t \t \t");
		System.out.println("|");
		System.out.print("|");
		System.out.format("\t \t \t \t \t \t \t \t");
		System.out.println("|");
		System.out.println("-----------------------------------------------------------------");
		
		// -------------------- End Of Main Screen Design
	}
	
	
	// for main navigation
	public static void navigation() {
		System.out.println("Main Menu For Navigation\n");
		System.out.println("Use the below choices to proceed further\n");
		System.out.println("1. To List the files in directory");
		System.out.println("2. For user interaction operations");
		System.out.println("3. Exit Application\n");
		try {
			Scanner scanner = new Scanner(System.in);
			int selected = 0;
			if (scanner.hasNext()) {
				selected = scanner.nextInt();
			}
			// scanner.close();
			switch (selected) {
			case 1:
				listFiles();
				System.out.println("\n----------------------------------------------------\n");
				navigation();
				break;
			case 2:
				subnavigation();
				break;
			case 3:
				System.out.println("Application has been terminated! Bye............");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input!!");
				mainscreen();
				navigation();
				break;
			}
		} catch (Exception e) {
			System.out.println("Kindly choose the choice from 1 to 3...\n");
			navigation();
		}
	}
	
	
	// for second navigation
	public static void subnavigation() {
		System.out.println("\nSub Menu For Navigation\n");
		System.out.println("Enter the below choice from 1 to 4....\n");
		System.out.println("1. Add a new File");
		System.out.println("2. Delete A File");
		System.out.println("3. Search A File");
		System.out.println("4. Back To Main Menu\n");
		try {
			Scanner scanner = new Scanner(System.in);
			int selected = 0;
			if (scanner.hasNext()) {
				selected = scanner.nextInt();
			}
			// scanner.close();
			switch (selected) {
			case 1:
				addFiles();
				subnavigation();
				break;
			case 2:
				deleteFile();
				subnavigation();
				break;
			case 3:
				searchFile();
				subnavigation();
				break;
			case 4:
				mainscreen();
				navigation();
				break;
			default:
				System.out.println("Invalid Input!!");
				subnavigation();
				break;
			}
		} catch (Exception e) {
			System.out.println("Kindly choose the choice from 1 to 4...\n");
			subnavigation();
		}
	}

	// to list all files in a directory
	public static void listFiles() {
		try {
			File f1 = new File(dir);
			String s[] = f1.list();
			Arrays.sort(s);
			if (s.length != 0) {
				System.out.println("Files in the directory!");
				for (String mystr : s) { 
					System.out.println(mystr);
				}
			} else {
				System.out.println("No files in the directory!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// to add a new file logic
	public static void addFiles() {
		System.out.println("Enter the file name : ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		try {
			File myfile = new File(dir + "/" + filename + ".txt");
			if (myfile.createNewFile()) {
				System.out.println("File has been created:" + myfile.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// to delete a file
	public static void deleteFile() {
		System.out.println("Enter the file name : ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		try {
			File myfile = new File(dir + "/" + filename + ".txt");
			if (myfile.delete()) {
				System.out.println("File has been deleted:" + myfile.getName());
			} else {
				System.out.println("Failed to delete the file.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// to search a file
	public static void searchFile() {
		System.out.println("Enter the file name : ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		filename = filename + ".txt";
		try {
			File f1 = new File(dir);
			String s[] = f1.list();
			Arrays.sort(s);
			int status = 0;
			if (s.length != 0) {
				for (String mystr : s) {
					if (mystr.equals(filename)) {
						status = 1;
					}
				}
				if(status == 1){
					System.out.println("File exists in the directory....");
				}else{
					System.out.println("File not found!");
				}
			} else {
				System.out.println("Directory is empty!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
