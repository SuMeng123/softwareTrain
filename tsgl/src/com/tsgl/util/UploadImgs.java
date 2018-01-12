package com.tsgl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class UploadImgs {

	public static List<String> upload(List<File> myFile, List<String> fileName,
			String savePartPath) {
		List<String> imageFileName = new ArrayList<String>();
		if (myFile == null || myFile.size() == 0){
			imageFileName.clear();
			imageFileName.add("emptyError");
            return imageFileName;
		}
        for (int i = 0; i < myFile.size(); i++) {
        	String saveParPath = savePartPath;
        	File upload = myFile.get(i);
	        String uploadFileName = fileName.get(i);
			String fileType = uploadFileName.substring(uploadFileName
					.lastIndexOf("."));
			List<String> allowTypesList= new ArrayList<String>();
			allowTypesList.add(".jpeg");
			allowTypesList.add(".gif");
			allowTypesList.add(".pjpeg");
			allowTypesList.add(".jpg");
			allowTypesList.add(".png");
			allowTypesList.add(".bmp");
			if(!allowTypesList.contains(fileType))
			{
				imageFileName.clear();
				imageFileName.add("typeError");
	            return imageFileName;
			}
			Random r = new Random();
			int n = r.nextInt(900) + 100;
			String uploadPath = ""
					+ saveParPath
					+ TypeConverter.convertDate2String(Calendar.getInstance()
							.getTime(), "yyyyMMddHHmmss") + n;

			HttpServletRequest request = ServletActionContext.getRequest();
			String realPath = request.getSession().getServletContext()
					.getRealPath(uploadPath);
			File file = new File(realPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			String fn = "";
			uploadFileName = TypeConverter.convertDate2String(Calendar
					.getInstance().getTime(), "yyyyMMddHHmmss")
					+ n + fileType;
			fn = realPath + File.separator + uploadFileName;
			String filePath = uploadPath + "/" + uploadFileName;
			String filePos = filePath.substring(1);

			FileOutputStream fos = null;
			InputStream is = null;
			try {
				fos = new FileOutputStream(fn);

				is = new FileInputStream(upload);
				byte[] buffer = new byte[8192];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
			} catch (Exception e) {
			} finally {
				try {
					fos.close();
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			imageFileName.add(filePos);
		}
        return imageFileName;
	}
		

}
