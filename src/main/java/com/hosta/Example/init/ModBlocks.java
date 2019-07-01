package com.hosta.Example.init;

import java.util.ArrayList;
import java.util.List;

import com.hosta.Example.blocks.BaseSlabDouble;
import com.hosta.Example.blocks.BaseSlabHalf;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;

public class ModBlocks {

	public static final List<Block>	BLOCKS						= new ArrayList<Block>();

	public static final BlockSlab	BLOCK_HALF_EXAMPLE			= (BlockSlab) new BaseSlabHalf("slab_example", Material.ROCK, SoundType.STONE, ModTabs.TabExample);
	public static final BlockSlab	BLOCK_DOUBLE_HALF_EXAMPLE	= (BlockSlab) new BaseSlabDouble("slab_example_double", Material.ROCK, SoundType.STONE, ModTabs.TabExample);

	static
	{
		ModItems.ITEMS.add(new ItemSlab(BLOCK_HALF_EXAMPLE, BLOCK_HALF_EXAMPLE, BLOCK_DOUBLE_HALF_EXAMPLE).setRegistryName(BLOCK_HALF_EXAMPLE.getRegistryName()));
	}
}
