package com.mekelaina.duelcraft;

import java.io.File;

import com.mekelaina.duelcraft.card.CardImages;
import com.mekelaina.duelcraft.init.ModBlocks;
import com.mekelaina.duelcraft.init.ModItems;
import com.mekelaina.duelcraft.network.PacketRequestUpdatePillar;
import com.mekelaina.duelcraft.network.PacketUpdatePillar;
import com.mekelaina.duelcraft.proxy.CommonProxy;
import com.mekelaina.duelcraft.util.Reference;
import com.mekelaina.duelcraft.util.handlers.CardLoadingHandler;
import com.mekelaina.duelcraft.util.handlers.ModGuiHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Duelcraft
{
	public static final CreativeTabs MAIN_TAB = new CreativeTabs(Reference.MOD_ID+"mainTab") 
	{
		
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(Item.getItemFromBlock(ModBlocks.CARD_TABLE_CLEAR_GLASS));
		}
	};
	
	public static final CreativeTabs CARD_TAB = new CreativeTabs(Reference.MOD_ID+"cardTab") 
	{
		
		@Override
		public ItemStack getTabIconItem() 
		{
			ItemStack stack = new ItemStack(ModItems.CARD);
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("Card_ID", "0");
			stack.setTagCompound(nbt);
			
			return stack;
			
			//return new ItemStack(ModItems.CARD, 0, 0, null);
		}
		
		public boolean hasSearchBar() 
		{
			return true;
		} 
	}.setBackgroundImageName("item_search.png");
	
	public static Configuration config;
	public static String config_dir;
	public static SimpleNetworkWrapper network;
	
	@Instance
	public static Duelcraft instance;
	
	//public static final String CONFIG_DIRECTORY;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	//private static SimpleNetworkWrapper network;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		network.registerMessage(new PacketUpdatePillar.Handler(), PacketUpdatePillar.class, 0, Side.CLIENT);
		network.registerMessage(new PacketRequestUpdatePillar.Handler(), PacketRequestUpdatePillar.class, 1, Side.SERVER);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ModGuiHandler());
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		config_dir = event.getModConfigurationDirectory().getAbsolutePath();
		
		CardLoadingHandler.loadCardInfo();
		
		proxy.registerRenderers();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
