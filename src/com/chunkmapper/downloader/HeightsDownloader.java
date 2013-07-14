package com.chunkmapper.downloader;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import com.chunkmapper.FileValidator;
import com.chunkmapper.Point;
import com.chunkmapper.Zip;
import com.chunkmapper.resourceinfo.HeightsResourceInfo;

public class HeightsDownloader extends Downloader {

	@Override
	protected void download(Point task, boolean useBackupServer) throws Exception {

		HeightsResourceInfo fileToDownload = new HeightsResourceInfo(task.x, task.z);
		if (FileValidator.checkValid(fileToDownload.file)) {
			return;
		}

		System.out.println("downloading " + fileToDownload.url);
		HttpGet httpGet = new HttpGet(fileToDownload.url.toURI());
		HttpResponse response = httpclient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		InputStream in = entity.getContent();
		try {
			byte[] buffer = Zip.readFully(in);
			if (buffer.length != HeightsResourceInfo.FILE_LENGTH)
				throw new RuntimeException("buffer too short");

			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileToDownload.file));
			out.write(buffer);
			out.close();
			FileValidator.setValid(fileToDownload.file);
		} finally {
			in.close();
			EntityUtils.consumeQuietly(entity);
			httpGet.releaseConnection();
		}

	}

}
