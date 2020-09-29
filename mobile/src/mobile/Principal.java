package mobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {
	
	public static void main(String[] args) {

		Horario horario = new Horario(21, 17, 54);
		
		System.out.println(horario);
		
		try {
			FileOutputStream fileOut = new FileOutputStream(new File("./horario.txt"));
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(horario);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Horario HorarioFromFile = null;
		
		try {
			FileInputStream fileIn = new FileInputStream(new File("./horario.txt"));
			ObjectInputStream in = new ObjectInputStream(fileIn);
			HorarioFromFile = (Horario) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			return;
		}
		catch (ClassNotFoundException  e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println(HorarioFromFile);
	}
}
