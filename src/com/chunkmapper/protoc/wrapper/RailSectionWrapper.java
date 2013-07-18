package com.chunkmapper.protoc.wrapper;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.chunkmapper.protoc.LakeContainer.Lake;
import com.chunkmapper.protoc.PointContainer;
import com.chunkmapper.protoc.RailSectionContainer.RailSection;
import com.chunkmapper.protoc.RectangleContainer;

public class RailSectionWrapper implements SectionWrapper {
	public final RailSection railSection;
	public final Rectangle bbox;
	public final ArrayList<Point> points = new ArrayList<Point>();
	
	public RailSectionWrapper(RailSection section) {
		railSection = section;
		RectangleContainer.Rectangle r = section.getBbox();
		bbox = new Rectangle(r.getX(), r.getZ(), r.getWidth(), r.getHeight());
		for (PointContainer.Point rawPoint : section.getPointsList()) {
			points.add(new Point(rawPoint.getX(), rawPoint.getZ()));
		}
	}
	@Override
	public Rectangle getBbox() {
		return bbox;
	}

	@Override
	public RegionBuilder getRegion(InputStream in) throws IOException {
		RegionBuilder out = new RailRegionBuilder();
		DataInputStream in2 = new DataInputStream(in);
		try {
			while (true) {
				int size = in2.readInt();
				byte[] data = new byte[size];
				in2.readFully(data);
				out.addSection(new RailSectionWrapper(RailSection.parseFrom(data)));
			}
		} catch (EOFException e) {
		}
		return out;
	}

	@Override
	public byte[] toByteArray() {
		return railSection.toByteArray();
	}
	
	@Override
	public int hashCode() {
		return bbox.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (!(other instanceof RailSectionWrapper))
			return false;
		RailSectionWrapper other2 = (RailSectionWrapper) other;
		
		if (other2.points.size() != points.size())
			return false;
		for (int i = 0; i < points.size(); i++) {
			if (!other2.points.get(i).equals(points.get(i)))
				return false;
		}
		return true;
	}
//		
	

}
