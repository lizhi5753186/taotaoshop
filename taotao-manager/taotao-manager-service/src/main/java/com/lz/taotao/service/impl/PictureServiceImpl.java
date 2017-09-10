package com.lz.taotao.service.impl;

import com.lz.taotao.common.utils.FtpUtil;
import com.lz.taotao.common.utils.IDUtils;
import com.lz.taotao.service.PictureService;
import com.sun.jersey.api.client.WebResource;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sun.jersey.api.client.Client;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传服务
 * <p>Title: PictureServiceImpl</p>
 * <p>Description: </p>

 * @author	lizhi
 * @date	2015年9月4日下午2:50:42
 * @version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {
	
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Override
	public Map uploadPicture(MultipartFile uploadFile) {
		Map resultMap = new HashMap<>();
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			//UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, 
					FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
			//返回结果
			if(!result) {
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
            //使用common io的文件写入操作
			//实例化一个Jersey
			Client client = new Client();
			//保存图片服务器的请求路径

			String url = IMAGE_BASE_URL  + "/" + newName;
			//设置请求路径
			WebResource resource = client.resource(url);
			//发送post get put
			resource.put(String.class, uploadFile.getBytes ());
			resultMap.put("error", 0);
			resultMap.put("url", IMAGE_BASE_URL  + "/" + newName);
			return resultMap;
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}
}
