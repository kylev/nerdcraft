package com.kylev.nerdingcraft.proxy;

import com.kylev.nerdingcraft.NerdCraft;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NerdCraft.logger.info("In client-side pre-init");
    }
}
