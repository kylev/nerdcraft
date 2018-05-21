package com.kylev.nerdingcraft;

import com.kylev.nerdingcraft.blocks.WoolFurnace;
import com.kylev.nerdingcraft.configuration.ConfigurationHandler;
import com.kylev.nerdingcraft.proxy.IProxy;
import com.kylev.nerdingcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class NerdCraft {
    public static Logger logger;

    @Mod.Instance(Reference.MOD_ID)
    public static NerdCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static final Block woolFurnace = new WoolFurnace();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("FML pre init");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("FML init");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("FML post init");
    }

}
