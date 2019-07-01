package com.hosta.Example.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BaseSlabDouble extends BaseSlab {

	public BaseSlabDouble(String name, Material material, SoundType soundtype, CreativeTabs creativetabs)
	{
		super(name, material, soundtype, creativetabs);
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}
}
