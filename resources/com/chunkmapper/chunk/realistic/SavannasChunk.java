package com.chunkmapper.chunk.realistic;

import com.chunkmapper.chunk.Chunk;
import com.chunkmapper.enumeration.Biome;
import com.chunkmapper.enumeration.Block;
import com.chunkmapper.math.TriangleZonator;
import com.chunkmapper.writer.GenericWriter;
import com.chunkmapper.writer.TreeWriter;

public class SavannasChunk extends Chunk {
	protected static TriangleZonator zonator = new TriangleZonator();
	static {
		zonator.addPoint(4000, 70);
		zonator.addPoint(5500, 80);
	}
	protected boolean containsTrees = false;

	protected static final int SAVANNA_ZONE = 0, GRAVEL_ZONE = 1, SNOW_ZONE = 2;

	public static void placeColumn(int x, int z, Chunk chunk, int absChunkX, int absChunkZ, int treeProb) {
		//assumes bedrock already placed and the check for ocean block done
		int approxLat = Math.abs(absChunkZ * 16 / 3600);
		int h = chunk.getHeights(x, z);
		int zone = zonator.checkVal(h, approxLat);
		if (zone == SNOW_ZONE) {
			chunk.Blocks[h-2][z][x] = Block.Snow_Block.val;
			chunk.Blocks[h-1][z][x] = Block.Snow_Block.val;
		}
		if (zone == GRAVEL_ZONE) {
			chunk.Blocks[h-2][z][x] = RANDOM.nextInt(3) > 0 ? Block.Gravel.val : Block.Stone.val;
			chunk.Blocks[h-1][z][x] = RANDOM.nextInt(3) > 0 ? Block.Gravel.val : Block.Stone.val;
		}
		if (zone == SAVANNA_ZONE) {
			chunk.Blocks[h-2][z][x] = Block.Dirt.val;
			chunk.Blocks[h-1][z][x] = Block.Grass.val;
			if (RANDOM.nextInt(2) == 0) {
				chunk.Blocks[h][z][x] = Block.Long_Grass.val;
				chunk.Data[h][z][x] = 1;
			}
		}
		if (RANDOM.nextInt(treeProb) == 0) {
			if (zone == SAVANNA_ZONE) {
//				TreeWriter.placeSavannaTree(x, z, chunk.Blocks, chunk.Data, chunk);
			}
		}
	}

	public SavannasChunk(int absChunkX, int absChunkZ, int[][] heights) {
		super(absChunkX, absChunkZ);
		this.heights = heights;
		final int soilThickness = 2;
		int approxLat = Math.abs(absChunkZ * 16 / 3600);
//		GenericWriter.addBedrock(Blocks, heights, soilThickness);
		GenericWriter.setBiomes(Biomes, heights, zonator, new Biome[] {Biome.PLAINS, Biome.PLAINS, Biome.ICE}, approxLat);

		//now add the topsoil
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int h = heights[x][z];
				if (h < 0) {
					super.writeOceanColumn(x, z);
					continue;
				}
				int zone = zonator.checkVal(h, approxLat);
				containsTrees |= zone == SAVANNA_ZONE;

				if (zone == SNOW_ZONE) {
					Blocks[h-2][z][x] = Block.Snow_Block.val;
					Blocks[h-1][z][x] = Block.Snow_Block.val;
				}
				if (zone == GRAVEL_ZONE) {
					Blocks[h-2][z][x] = RANDOM.nextInt(3) > 0 ? Block.Gravel.val : Block.Stone.val;
					Blocks[h-1][z][x] = RANDOM.nextInt(3) > 0 ? Block.Gravel.val : Block.Stone.val;
				}
				if (zone == SAVANNA_ZONE) {
					Blocks[h-2][z][x] = Block.Grass.val;
					Blocks[h-1][z][x] = Block.Grass.val;
					if (RANDOM.nextInt(2) == 0) {
						Blocks[h][z][x] = Block.Long_Grass.val;
						Data[h][z][x] = 1;
					}
				}
			}
		}
		if (containsTrees && RANDOM.nextInt(2) == 0) {
			int x = 2 + RANDOM.nextInt(12);
			int z = 2 + RANDOM.nextInt(12);
			int zone = zonator.checkVal(heights[x][z], approxLat);
			if (zone == SAVANNA_ZONE) {
//				TreeWriter.placeSavannaTree(x, z, Blocks, Data, this);
			}
		}
	}
}
