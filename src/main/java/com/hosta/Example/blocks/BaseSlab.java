package com.hosta.Example.blocks;

import com.hosta.Example.Main;
import com.hosta.Example.init.ModBlocks;
import com.hosta.Example.util.IHasModel;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BaseSlab extends BlockSlab implements IHasModel {

	public static final PropertyEnum<BaseSlab.Variant> VARIANT = PropertyEnum.<BaseSlab.Variant>create("variant", BaseSlab.Variant.class);

	public BaseSlab(String name, Material material, SoundType soundtype, CreativeTabs creativetabs)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(soundtype);
		setCreativeTab(creativetabs);

		IBlockState state = this.blockState.getBaseState();

		if (!this.isDouble())
		{
			state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}

		setDefaultState(state.withProperty(VARIANT, BaseSlab.Variant.DEFAULT));
		this.useNeighborBrightness = true;

		ModBlocks.BLOCKS.add(this);
	}

	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public String getUnlocalizedName(int meta)
	{
		return super.getUnlocalizedName();
	}

	@Override
	public boolean isDouble()
	{
		return false;
	}

	public IProperty<?> getVariantProperty()
	{

		return VARIANT;
	}

	public Comparable<?> getTypeForItem(ItemStack stack)
	{
		return BaseSlab.Variant.DEFAULT;
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return 0;
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		if (!this.isDouble())
		{
			return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
		}
		return this.getDefaultState();
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		if (this.isDouble())
		{
			return 0;
		}

		return ((EnumBlockHalf) state.getValue(HALF)).ordinal() + 1;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		if (!this.isDouble())
		{
			return new BlockStateContainer(this, new IProperty[] { HALF, VARIANT });
		}
		else
		{
			return new BlockStateContainer(this, new IProperty[] { VARIANT });
		}
	}

	public static enum Variant implements IStringSerializable
	{
		DEFAULT;

		public String getName()
		{
			return "default";
		}
	}
}
