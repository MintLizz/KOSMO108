package a.b.c.com.kosmo.common;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileRename implements FileRenamePolicy {
	
	public FileRename() {
		
		
	}

	@Override
	public File rename(File sf) {
		// TODO Auto-generated method stub
		
		String f = sf.getName();
		
		System.out.println("	fileName 은 ?	>>> : " + f);
		
		try {
			
			String s = f;
			
			for (int i = 1; sf.exists(); i++) {
				
				int lt = s.lastIndexOf(".");
				String s1 = s.substring(0, lt);
				String s2 = s.substring(lt);
				String st = "_" + i + "_";
				f = s1.concat(st).concat(s2);
				
				sf = new File(sf.getParent(), f);
			}
			
		}catch (Exception e) {
			
			System.out.println("	FileRename 의 reName() 오류는 ?	>>> : " + e.getMessage());
				
		}
		
		
		return sf;
	}
	
	public static void main(String[] args) {
		
		File f = new File("C:\\msdia80.dll");
		File ss = new FileRename().rename(f);
		System.out.println("	ss 는 ?	>>> : " + ss);
	}

}