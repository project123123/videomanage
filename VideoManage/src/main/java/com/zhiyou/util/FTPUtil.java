package com.zhiyou.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPUtil {

	public static String upload(InputStream input,String fileName) {
		
		fileName=System.currentTimeMillis()+fileName;
		
		//1 实例化 ftpClient
		
		FTPClient ftpClient = new FTPClient();
		
		String url = "ftp://192.168.124.60/";
		try {
			//连接服务器
			ftpClient.connect("192.168.124.60");
			//根据账号密码登入服务器
			ftpClient.login("admin", "123");
			//更改客户端模式
			ftpClient.enterLocalPassiveMode();
			//设置文件上传到服务器的位置
			ftpClient.changeWorkingDirectory("/");
			//设置文件的类型
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			//上传文件
			ftpClient.storeFile(fileName,input);
			return url+fileName;
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ftpClient.logout();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	} 
}
