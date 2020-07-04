package com.akh.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import com.akh.bean.LogoInformation;
import com.akh.dao.Image;
import com.akh.dao.ImageDAO;

public class ImageInfoService {

	public static List<LogoInformation> getImageInfoFromDb(ImageDAO imageDAO) {
		
		List<LogoInformation> logoInfoList = new ArrayList<LogoInformation>();
		
		byte[] imgData = null;
		
		System.out.println(imageDAO);
		
		List<Image> imageList = imageDAO.getImage();
		
		for (int i = 0; i < imageList.size(); i++) {
			LogoInformation logoInfo = new LogoInformation();
			logoInfo.setImageId(String.valueOf(imageList.get(i).getId()));
			logoInfo.setImageName(imageList.get(i).getName());
			SimpleImageInfo imageInfo = null;
			try {
				imageInfo = findResolution(imageList.get(i).getBytes());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("sql fuck");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("io fuck");
			}
			logoInfo.setMimeType(imageInfo.getMimeType());
			imgData = imageList.get(i).getBytes();
			logoInfo.setImageBlog(imgData);
			logoInfo.setImageInfo(getByteArrayString(imgData));
			logoInfo.setWidth(imageInfo.getWidth());
			logoInfo.setHeight(imageInfo.getHeight());
			logoInfoList.add(logoInfo);
		}
		return logoInfoList;
	}

	private static String getByteArrayString(byte[] imgData) {
		return new Base64().encodeToString(imgData);
	}
	
	
	private static SimpleImageInfo findResolution(byte[] bytes)
			throws SQLException, IOException {
		SimpleImageInfo imageInfo = new SimpleImageInfo(bytes);
		return imageInfo;
	}
}
