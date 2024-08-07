package operations;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo3 {
	
public static void main(String[] args) {
		
		File file = new File("C:/Users/Admin/OneDrive/Desktop/Demo.txt");
		if(file.exists()) {
			System.out.println("File is already exists");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File is created");
			}
			catch(IOException e) {
				e.printStackTrace();
				System.out.println("File is not created");
			}
		}
	}

}