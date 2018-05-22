package com.kylev.nerdingcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * The simplest possible tutorial block.
 *
 * As you can see, there is very little code here. Block handles a lot of the work for us, and modern Forge uses a lot
 * descriptive config rather than boilerplate code.
 *
 * This Java class can't full exist without 3 resource files:
 * - models/block/smiling_block.json to describe what the block should look like.
 * - models/item/smiling_block.json to describe how it'll look as an item, in hand. Frequently it just refers to the
 *   block version and Minecraft will render a miniature version of it.
 * - blockstates/smiling_block.json to describe our single essential block state: normal.
 *
 * And, of course, none of this happens unless you register it with Minecraft. Follow the path of
 * NerdCraft.smilingBlock to learn more. 
 */
public class SmilingBlock extends Block {
    public SmilingBlock() {
        super(Material.WOOD);
    }
}
