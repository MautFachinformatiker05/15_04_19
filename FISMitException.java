package application;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



class FISMitException {
	public static void main (String [] args)throws IOException{
		File original = new File("G:/Daten_LouisaFrison/Sonstiges/bitteKopieren.txt");
		File kopie = new File("G:/Daten_LouisaFrison/Sonstiges/erledigt.txt");

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {

			fis = new FileInputStream (original);
			fos = new FileOutputStream (kopie);

			int content;
			while((content = fis.read() ) != -1){
				fos.write((char) content);
			}

		}catch(IOException e) {

			e.printStackTrace();

		}finally{

			if(fis != null){
				fis.close();
			}
			if(fos != null) {
				fos.close();
			}

		}
	}
}