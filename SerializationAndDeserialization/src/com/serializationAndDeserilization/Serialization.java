package com.serializationAndDeserilization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serialization {
	
public static void main(String[] args) throws IOException {
		
		File file=new File("Student.txt");
		if(file.exists()) {
			FileOutputStream fileOutPutStream=new FileOutputStream(file);
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutPutStream);
			objectOutputStream.writeObject(new Student(1, "vaibhav", "vaibhavdeore8101@gmail.com", 23));
			objectOutputStream.writeObject(new Student(2, "rohit", "rohit@gmail.com", 24));
			System.out.println("Objects Wriitten to the file");
			objectOutputStream.close();
			fileOutPutStream.close();
		}
		else {
			file.createNewFile();
			System.out.println("File is Created");
			FileOutputStream fileOutPutStream=new FileOutputStream(file);
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutPutStream);
			objectOutputStream.writeObject(new Student(1, "vaibhav", "vaibhavdeore8101@gmail.com", 23));
			System.out.println("Objects Wriitten to the file");
			objectOutputStream.close();
			fileOutPutStream.close();
		}
	}


}
