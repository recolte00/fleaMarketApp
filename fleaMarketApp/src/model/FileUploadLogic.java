package model;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.http.Part;

public class FileUploadLogic {
	public void execute(Part part, Path path) throws IOException {
		try(BufferedInputStream br=new BufferedInputStream(part.getInputStream(),(int)part.getSize());
			    ByteArrayOutputStream bw = new ByteArrayOutputStream()){
		    		int count=0;
		    		byte[] buff=new byte[(int)part.getSize()];
		    	while((count=br.read(buff)) != -1) {
		    			bw.write(buff, 0, count);
		    	}
		}
	}
}
