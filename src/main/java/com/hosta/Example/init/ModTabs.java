package com.hosta.Example.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModTabs {

	public static CreativeTabs TabExample = new CreativeTabs("tab_example")
	{

		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(Items.APPLE);
		}
	};
}
