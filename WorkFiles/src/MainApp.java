import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class MainApp {
	public static void main(String[] args) {

		// ReadFile();
		// WriteFile();
		// InfoFileShow();
		// CreateFolder();
		WriteUTF8();
		ReadUTF8();
	}

	private static void ReadFile() {
		try (FileInputStream fin = new FileInputStream("test.txt")) {
			int i = -1;
			while ((i = fin.read()) != -1) {

				System.out.print((char) i);
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}

	private static void WriteFile() {
		String fileName = "test.txt";
		try (FileOutputStream fout = new FileOutputStream(fileName)) {
			String str = "Hello Semen!";
			byte[] buffer = str.getBytes();
			fout.write(buffer, 0, buffer.length);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		try (FileInputStream fin = new FileInputStream(fileName)) {
			System.out.println("Byte file size: " + fin.available());
			System.out.println("Show file");
//			int item=-1;
//			while((item=fin.read())!=-1)
//			{
//				System.out.print((char)item);
//			}
			int fileSize = fin.available();
			byte[] content = new byte[fileSize];
			fin.read(content, 0, fileSize);
			for (byte item : content) {
				System.out.print((char) item);
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void InfoFileShow() {
		try {
			System.out.println("Working Directory = " + System.getProperty("test.txt"));

			Path file = Paths.get("test.txt");
			BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

			System.out.println("creationTime: " + attr.creationTime());
			System.out.println("lastAccessTime: " + attr.lastAccessTime());
			System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

			System.out.println("isDirectory: " + attr.isDirectory());
			System.out.println("isOther: " + attr.isOther());
			System.out.println("isRegularFile: " + attr.isRegularFile());
			System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
			System.out.println("size: " + attr.size());

		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		}
	}

	private static void CreateFolder() {
		File dir = new File("step");
		boolean isCreatDirectory = dir.mkdir();
		if (isCreatDirectory) {
			System.out.println("Ствоерня папки успішне!");
		}
		if (dir.exists()) {
			System.out.println("Папка існує!");
		}
		File newDir = new File("ttt");
		dir.renameTo(newDir);
		// newDir.delete();
		String par = newDir.getParent();
		System.out.println(par);
	}

	private static void WriteUTF8() {
		Customer[] list = new Customer[] { new Customer("Іван", 12), new Customer("Семен", 23),
				new Customer("Оксана", 18), new Customer("Діма", 12), new Customer("Саша", 33) };
		
		try(DataOutputStream fileData = 
				new DataOutputStream(
						new FileOutputStream("customer2.bin", true)))
		{
			//fileData.writeInt(list.length);
			for(Customer cust : list)
			{
				fileData.writeUTF(cust.GetName());
				fileData.writeInt(cust.GetAge());
			}
			System.out.println("Добре.");
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	private static void ReadUTF8() {
		try(DataInputStream fileData = 
				new DataInputStream(
						new FileInputStream("customer2.bin")))
		{
			//int size=fileData.readInt();
			while(true)
			{
				String name = fileData.readUTF();
				int age = fileData.readInt();
				System.out.println(name+" "+age);
			}
			
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
