package com.kylev.nerdingcraft;

import com.kylev.nerdingcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylev on 5/20/18.
 */
@Mod.EventBusSubscriber
public class RegistryHandler {
    public static final List<Item> ALL_ITEMS = new ArrayList<Item>();
    public static final List<Block> ALL_BLOCKS = new ArrayList<Block>();

    @SubscribeEvent
    public static void registerModelEvent(ModelRegistryEvent event) {
        NerdCraft.proxy.registerRenderers();
    }

    @SubscribeEvent
    public static void registerBlockEvent(RegistryEvent.Register<Block> event) {
        NerdCraft.logger.info("Registering blocks");
        event.getRegistry().registerAll(ALL_BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void registerItemEvent(RegistryEvent.Register<Item> event) {
        NerdCraft.logger.info("Registering items");
        event.getRegistry().registerAll(ALL_ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerRecipeEvent(RegistryEvent.Register<IRecipe> event) {
        NerdCraft.logger.info("Registering recipes");

        //event.getRegistry().register(new Recip);
    }

    public static void registerItemBlock(Block b, String name) {
        ResourceLocation res = new ResourceLocation(Reference.MOD_ID + ":" + name);
        String loc = Reference.MOD_ID + "." + name;
        b.setRegistryName(res).setUnlocalizedName(loc);

        ALL_BLOCKS.add(b);
        ALL_ITEMS.add(new ItemBlock(b).setRegistryName(res));
    }

    static {
        registerItemBlock(NerdCraft.smilingBlock, "smiling_block");
        registerItemBlock(NerdCraft.woolFurnace, "wool_furnace");
    }
}
