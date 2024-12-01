package com.kylev.nerdingcraft;

import org.slf4j.Logger;

import com.kylev.nerdingcraft.blocks.WoolFurnace;
import com.kylev.nerdingcraft.configuration.ConfigurationHandler;
import com.kylev.nerdingcraft.reference.Reference;
import com.mojang.logging.LogUtils;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.client.gui.components.tabs.Tab;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@Mod ( Reference.MOD_ID)
public class NerdCraft {
    public static Logger LOGGER = LogUtils.getLogger();

    // Registries
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
    // public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
    //         .create(ForgeRegistries.BLOCK_ENTITY_TYPES, Reference.MOD_ID);
    // public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES,
    // Reference.MOD_ID);

    // Static registry objects
    public static final RegistryObject<Block> SMILING_BLOCK = BLOCKS.register("smiling_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.ICE)));
    public static final RegistryObject<Item> SMILING_BLOCK_ITEM = ITEMS.register("smiling_block",
            () -> new BlockItem(SMILING_BLOCK.get(), new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Block> WOOL_FURNACE = BLOCKS.register("wool_furnace",
            () -> new WoolFurnace(BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS)));
    public static final RegistryObject<Item> WOOL_FURNACE_ITEM = ITEMS.register("wool_furnace",
            () -> new BlockItem(WOOL_FURNACE.get(), new Item.Properties().stacksTo(16)));

    public NerdCraft(FMLJavaModLoadingContext context) {
        LOGGER.info("NerdCraft constructor");
        IEventBus modEventBus = context.getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

}
