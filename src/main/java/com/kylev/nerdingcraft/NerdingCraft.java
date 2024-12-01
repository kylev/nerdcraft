package com.kylev.nerdingcraft;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.kylev.nerdingcraft.block.WoolFurnace;

/**
 * The main mod class for NerdingCraft.
 */
@Mod(NerdingCraft.MOD_ID)
public class NerdingCraft {
    public static final String MOD_ID = "nerdingcraft";
    public static Logger LOGGER = LogUtils.getLogger();

    // Registries
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            NerdingCraft.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            NerdingCraft.MOD_ID);

    // A minimal block and item
    public static final RegistryObject<Block> SMILING_BLOCK = BLOCKS.register("smiling_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.ICE)));
    public static final RegistryObject<Item> SMILING_BLOCK_ITEM = ITEMS.register("smiling_block",
            () -> new BlockItem(SMILING_BLOCK.get(), new Item.Properties().stacksTo(64)));

    // A customized furnace
    public static final RegistryObject<Block> WOOL_FURNACE = BLOCKS.register("wool_furnace",
            () -> new WoolFurnace(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL)));
    public static final RegistryObject<Item> WOOL_FURNACE_ITEM = ITEMS.register("wool_furnace",
            () -> new BlockItem(WOOL_FURNACE.get(), new Item.Properties().stacksTo(16)));

    public NerdingCraft(FMLJavaModLoadingContext context) {
        LOGGER.info("NerdingCraft constructor");
        IEventBus modEventBus = context.getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
