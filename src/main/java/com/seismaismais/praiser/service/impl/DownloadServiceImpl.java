//package com.seismaismais.praiser.service.impl;
//
//import java.awt.Dimension;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.sl.usermodel.PictureData;
//import org.apache.poi.xslf.usermodel.XMLSlideShow;
//import org.apache.poi.xslf.usermodel.XSLFPictureData;
//import org.apache.poi.xslf.usermodel.XSLFSlide;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.seismaismais.praiser.model.Slide;
//import com.seismaismais.praiser.service.DownloadService;
//import com.seismaismais.praiser.service.SlideService;
//import com.seismaismais.praiser.util.FileUtil;
//
//@Service("downloadService")
//@Transactional
//@PropertySource(value = { "classpath:app.properties" })
//public class DownloadServiceImpl implements DownloadService {
//
//	 @Autowired
//	 private Environment environment;
//	
//	@Autowired
//	private SlideService slideService;
//	
////	@Override
////	public String generatePptx(Slide slide) throws IOException {
////		XMLSlideShow ppt = new XMLSlideShow();
////		
////		Dimension d = new Dimension();
////		// 4:3 780 - 585
////		// 16:9 1040 - 585		
////		
////		// 4:3 1333 - 1000
////		// 16:9 1777 - 1000
////		
////		//d.setSize(slide.getWidth() /1.35, slide.getHeight()/1.35);
////		//ppt.setPageSize(d);
////
////		Iterator<byte[]> imagesIterator = generateImage(slide.getSlidesImages()).iterator();
////
////		while (imagesIterator.hasNext()) {
////			byte[] image = imagesIterator.next();
////			
////			XSLFSlide slidePpt = ppt.createSlide();
////			XSLFPictureData pd = ppt.addPicture(image, PictureData.PictureType.JPEG);
////			slidePpt.createPicture(pd);
////		}
////
////		String fileName = FileUtil.generateUniqueFileName();
////		slide.setFilename(fileName);
////		slideService.update(slide);
////		
////		FileOutputStream out = new FileOutputStream(environment.getRequiredProperty("app.archive.upload.user") + fileName + ".pptx");
////		ppt.write(out);
////		out.close();
////		ppt.close();
////		
////		return fileName;
////	}
//
////	@Override
////	public List<byte[]> generateImage(String[] slidesBase64) {
////		List<byte[]> imagesList = new ArrayList<byte[]>();
////		try {
////			for (int i = 0; i < slidesBase64.length; i++) {
////				byte[] image;
////				image = FileUtil.convertBase64ToByte(FileUtil.clearStringBase64(slidesBase64[i]));
////				FileUtil.convertBase64ToImage(FileUtil.clearStringBase64(slidesBase64[i]), environment.getRequiredProperty("app.archive.upload.user") + FileUtil.generateUniqueFileName() + ".jpg");
////				imagesList.add(image);
////			}
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		return imagesList;
////	}
//
//}
