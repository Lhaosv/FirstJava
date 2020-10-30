package test2;
import java.io.*;
public class Objectser implements Serializable {

	public static void main(String[] args) {
		Student stu=new Student(981036,"Li Ming",16,"CSD");
		try{
			FileOutputStream fo= new FileOutputStream("data.ser");
			ObjectOutputStream so = new ObjectOutputStream(fo);
			so.writeObject(stu);
			so.close();
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
