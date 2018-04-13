/**
 *
 */
package code.controllers;

import code.Gui.GameScreen;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileController {
	String fileName = "SavedFile.txt";
	public void read() {
		try {
			BufferedReader inputFile = new BufferedReader(new FileReader(this.fileName));

			// Read the header line
			String line = inputFile.readLine();  // Contains SKU,Quantity,Price,Description (we skip this line)

			// Read the rest of the file line by line
			while ((line = inputFile.readLine()) != null) {

				// Turn the string into an array of strings
				String[] ary = line.split(",");
				// Extract each item
				String name = ary[0];
				int highScore = Integer.parseInt(ary[1]);
				String date = ary[2];


				// Output item
				System.out.printf(name + " "
						+ highScore + " "
						+ date);

			}
			inputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(GameScreen gameScreen){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String date = dtf.format(localDate);

		try {
			String mycontent = "\n" + gameScreen.getAvatar().getName()+","+gameScreen.getAvatar().getScore() +"," + date;
			//Specify the file name and path here
			File file = new File("resources\\SavedFile.txt");
			FileWriter fw = new FileWriter(file, true);
			fw.append(mycontent);
			fw.close();
			System.out.println("File written Successfully");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}


	public void load(){

	}

	public static void main(String[] args){
		FileController fileController = new FileController();
		fileController.read();
	}
}
