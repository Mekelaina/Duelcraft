package com.mekelaina.duelcraft.util.handlers;

import com.mekelaina.duelcraft.blocks.BlockOreBase;
import com.mekelaina.duelcraft.blocks.tileentities.TileEntityPillar;
import com.mekelaina.duelcraft.blocks.tileentities.TileEntityTest;
import com.mekelaina.duelcraft.init.ModBlocks;
import com.mekelaina.duelcraft.init.ModItems;
import com.mekelaina.duelcraft.items.ItemOre;
import com.mekelaina.duelcraft.util.Reference;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;
import com.mekelaina.duelcraft.util.interfaces.IItemWithMeshDefinition;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof ItemOre)
			{
				((ItemOre) item).initOreDict();
			}
		}
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof BlockOreBase)
			{
				((BlockOreBase) block).initOreDict();
			}
		}
		
		GameRegistry.registerTileEntity(TileEntityPillar.class, new ResourceLocation(Reference.MOD_ID, "tileentity_duelcraft_pillar"));
		GameRegistry.registerTileEntity(TileEntityTest.class, new ResourceLocation(Reference.MOD_ID, "tileentity_duelcraft_test"));
	}
	
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
			
			
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		
		
		
	//	ModItems.initSpecialModels();
	}

	
}
