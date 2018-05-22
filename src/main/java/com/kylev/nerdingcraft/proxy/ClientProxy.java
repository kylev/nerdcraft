package com.kylev.nerdingcraft.proxy;

import com.kylev.nerdingcraft.NerdCraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        NerdCraft.logger.info("In client-side pre-init");
    }

    @Override
    public void registerRenderers() {
        super.registerRenderers();

        registerBlockModel(NerdCraft.woolFurnace);
    }

    @SideOnly(Side.CLIENT)
    public static void registerBlockModel(Block block)
    {
        registerBlockModel(block, 0, block.getRegistryName().toString());
    }

    @SideOnly(Side.CLIENT)
    public static void registerBlockModel(Block block, int meta, String name)
    {
        Item item = Item.getItemFromBlock(block);
        ModelResourceLocation model = new ModelResourceLocation(name, "inventory");

        if(!name.equals(item.getRegistryName().toString()))
        {
            ModelBakery.registerItemVariants(item, model);
        }

        ModelLoader.setCustomModelResourceLocation(item, meta, model);
    }
}
