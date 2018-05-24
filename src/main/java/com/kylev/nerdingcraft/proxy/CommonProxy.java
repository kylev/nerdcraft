package com.kylev.nerdingcraft.proxy;

import com.kylev.nerdingcraft.NerdCraft;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NerdCraft.logger.info("In common pre-init");
    }

    @Override
    public void registerRenderers() {}
}
