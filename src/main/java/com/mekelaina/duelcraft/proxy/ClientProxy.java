package com.mekelaina.duelcraft.proxy;

import com.mekelaina.duelcraft.blocks.rarityalter.TESRPillar;
import com.mekelaina.duelcraft.blocks.tileentities.TileEntityPillar;
import com.mekelaina.duelcraft.items.ItemCard;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		//ModelLoader.setCustomMeshDefinition(item, meshDefinition);
	}
	
	
	@Override
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPillar.class, new TESRPillar());
	}
}
