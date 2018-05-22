package com.kylev.nerdingcraft;

import com.kylev.nerdingcraft.blocks.SmilingBlock;
import com.kylev.nerdingcraft.blocks.WoolFurnace;
import com.kylev.nerdingcraft.configuration.ConfigurationHandler;
import com.kylev.nerdingcraft.proxy.IProxy;
import com.kylev.nerdingcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class NerdCraft {
    @Mod.Instance(Reference.MOD_ID)
    public static NerdCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static final Block smilingBlock = new SmilingBlock();
    public static final Block woolFurnace = new WoolFurnace();

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("FML pre init");
        proxy.preInit(event);
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    }
}
