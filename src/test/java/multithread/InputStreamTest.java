package multithread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class InputStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		File file = new File("C:\\Users\\Administrator\\Desktop\\tmp.txt");
		//MultipartFile file = new CommonsMultipartFile(new DiskFileItem("test", "text/plain", true, "tmp.txt", int, File));
		MultipartFile multipartFile = new MockMultipartFile( file.getName(), new FileInputStream(file));
		FileInputStream in = (FileInputStream)multipartFile.getInputStream();
		
	}
	
}
