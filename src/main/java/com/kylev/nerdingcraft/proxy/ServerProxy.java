package com.kylev.nerdingcraft.proxy;

import com.kylev.nerdingcraft.NerdCraft;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NerdCraft.logger.info("In server-side pre-init");
    }
}
