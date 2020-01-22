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
		 WriteFile();
		// InfoFileShow();
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
			 System.out.println("Working Directory = " +
		              System.getProperty("D:\\test.txt"));
			
			Path file = Paths.get("D:\\test.txt");
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
			System.out.println("Error "+ex.getMessage());
		}
	}
}
