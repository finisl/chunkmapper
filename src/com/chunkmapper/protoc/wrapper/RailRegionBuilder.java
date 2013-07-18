package com.chunkmapper.protoc.wrapper;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.chunkmapper.protoc.LakeContainer.Lake;
import com.chunkmapper.protoc.RailSectionContainer.RailSection;

public class RailRegionBuilder implements RegionBuilder {
	public final ArrayList<RailSection> railSections = new ArrayList<RailSection>();
	@Override
	public RegionBuilder newBuilder() {
		return new RailRegionBuilder();
	}

	@Override
	public List<SectionWrapper> getSections() {
		ArrayList<SectionWrapper> out = new ArrayList<SectionWrapper>();
		for (RailSection section : railSections) {
			out.add(new RailSectionWrapper(section));
		}
		return out;
	}

	@Override
	public void addSection(SectionWrapper section) {
		RailSectionWrapper section2 = (RailSectionWrapper) section;
		railSections.add(section2.railSection);
	}

	@Override
	public int getSectionCount() {
		return railSections.size();
	}

	@Override
	public RegionBuilder newBuilder(InputStream in) throws IOException {
		DataInputStream in2 = new DataInputStream(in);
		RailRegionBuilder builder = new RailRegionBuilder();
		try {
			while(true) {
				int len = in2.readInt();
				byte[] data = new byte[len];
				in2.readFully(data);
				builder.addSection(new RailSectionWrapper(RailSection.parseFrom(data)));
			}
		} catch (EOFException e) {}
		return builder;
	}

	@Override
	public byte[] toByteArray() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DataOutputStream out2 = new DataOutputStream(out);
		for (RailSection section : railSections) {
			byte[] data = section.toByteArray();
			out2.writeInt(data.length);
			out2.write(data);
		}
		return out.toByteArray();
	}

}
