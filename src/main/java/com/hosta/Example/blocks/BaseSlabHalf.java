package com.hosta.Example.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BaseSlabHalf extends BaseSlab {

	public BaseSlabHalf(String name, Material material, SoundType soundtype, CreativeTabs creativetabs)
	{
		super(name, material, soundtype, creativetabs);
	}

	@Override
	public boolean isDouble()
	{
		return false;
	}
}
