package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckDirectoryContentsLogic {
	public String checkDirectry(Path path) {
		String msg=path.toAbsolutePath().toString();
		if(Files.exists(path)) {
			msg=msg+"は存在します";
		} else {
			msg=msg+"は存在しません";
		}
		return msg;
	}
	public File[] filepath(Path path) throws IOException{
		File[] files=new File(path.toString()).listFiles();
		return files;
	}
}
