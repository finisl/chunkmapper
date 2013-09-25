package com.chunkmapper.protoc.admin;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

import com.chunkmapper.protoc.HeightsContainer;

public class HeightsInfo {
	private static HashSet<Point> points;
	private static void setPoints() {
		InputStream in = null;
		try {
			URL url = new URL(BucketInfo.getBucket("chunkmapper-admin") + "/heights");
			in = new BufferedInputStream(url.openStream());
			HeightsContainer.Heights heights = HeightsContainer.Heights.parseFrom(in);
			points = new HashSet<Point>();
			Iterator<Integer> lats = heights.getLatsList().iterator(), lons = heights.getLonsList().iterator();
			while (lats.hasNext()) {
				points.add(new Point(lats.next(), lons.next()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			points = null;
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
	public static boolean hasPoint(int lat, int lon) throws InterruptedException {
		while (points == null) {
			setPoints();
			if (points == null)
				Thread.sleep(1000);
		}
		return points.contains(new Point(lat, lon));
	}
	public static void main(String[] args) throws Exception {
		setPoints();
		PrintWriter lats = new PrintWriter("/Users/matthewmolloy/python/wms/lats.csv"), lons = new PrintWriter("/Users/matthewmolloy/python/wms/lons.csv");
		for (Point p : points) {
			lats.println(p.x);
			lons.println(p.y);
		}
		lats.close();
		lons.close();
		System.out.println("done");
	}
}