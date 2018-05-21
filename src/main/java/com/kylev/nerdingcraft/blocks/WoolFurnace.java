package com.kylev.nerdingcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by kylev on 5/20/18.
 */
public class WoolFurnace extends Block {
    public WoolFurnace() {
        super(Material.CLOTH);
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
