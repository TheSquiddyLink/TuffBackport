package com.salmonpants.tuffbackport;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TuffBackport.MODID)
public class TuffBackport
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tuffbackport";
    // Directly reference a slf4j logger
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    private static final Block.Properties TUFF_PROPERTIES = Block.Properties.copy(Blocks.TUFF);

    // Tuff Bricks
    public static final RegistryObject<Block> TUFF_BRICKS = BLOCKS.register("tuff_bricks", () -> new Block(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_BRICKS_ITEM = ITEMS.register("tuff_bricks", () -> new BlockItem(TUFF_BRICKS.get(),new Item.Properties()));
    // Tuff Brick Slab
    public static final RegistryObject<SlabBlock> TUFF_BRICK_SLAB = BLOCKS.register("tuff_brick_slab", () -> new SlabBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_BRICK_SLAB_ITEM = ITEMS.register("tuff_brick_slab", () -> new BlockItem(TUFF_BRICK_SLAB.get(),new Item.Properties()));
    // Tuff Brick Stairs
    public static final RegistryObject<StairBlock> TUFF_BRICK_STAIRS = BLOCKS.register("tuff_brick_stairs", () -> new StairBlock(() -> TUFF_BRICKS.get().defaultBlockState(), TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_BRICK_STAIRS_ITEM = ITEMS.register("tuff_brick_stairs", () -> new BlockItem(TUFF_BRICK_STAIRS.get(),new Item.Properties()));
    // Tuff Brick Wall
    public static final RegistryObject<WallBlock> TUFF_BRICK_WALL = BLOCKS.register("tuff_brick_wall", () -> new WallBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_BRICK_WALL_ITEM = ITEMS.register("tuff_brick_wall", () -> new BlockItem(TUFF_BRICK_WALL.get(),new Item.Properties()));
    // Chiseled Tuff
    public static final RegistryObject<Block> CHISELED_TUFF = BLOCKS.register("chiseled_tuff", () -> new Block(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> CHISELED_TUFF_ITEM = ITEMS.register("chiseled_tuff", () -> new BlockItem(CHISELED_TUFF.get(),new Item.Properties()));
    // Chiseled Tuff Bricks
    public static final RegistryObject<Block> CHISELED_TUFF_BRICKS = BLOCKS.register("chiseled_tuff_bricks", () -> new Block(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> CHISELED_TUFF_BRICKS_ITEM = ITEMS.register("chiseled_tuff_bricks", () -> new BlockItem(CHISELED_TUFF_BRICKS.get(),new Item.Properties()));
    // Polished Tuff
    public static final RegistryObject<Block> POLISHED_TUFF = BLOCKS.register("polished_tuff", () -> new Block(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_ITEM = ITEMS.register("polished_tuff", () -> new BlockItem(POLISHED_TUFF.get(),new Item.Properties()));
    // Polished Tuff Slab
    public static final RegistryObject<SlabBlock> POLISHED_TUFF_SLAB = BLOCKS.register("polished_tuff_slab", () -> new SlabBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_SLAB_ITEM = ITEMS.register("polished_tuff_slab", () -> new BlockItem(POLISHED_TUFF_SLAB.get(),new Item.Properties()));
    // Polished Tuff Stairs
    public static final RegistryObject<StairBlock> POLISHED_TUFF_STAIRS = BLOCKS.register("polished_tuff_stairs", () -> new StairBlock(() -> POLISHED_TUFF.get().defaultBlockState(), TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_STAIRS_ITEM = ITEMS.register("polished_tuff_stairs", () -> new BlockItem(POLISHED_TUFF_STAIRS.get(),new Item.Properties()));
    // Polished Tuff Wall
    public static final RegistryObject<WallBlock> POLISHED_TUFF_WALL = BLOCKS.register("polished_tuff_wall", () -> new WallBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_WALL_ITEM = ITEMS.register("polished_tuff_wall", () -> new BlockItem(POLISHED_TUFF_WALL.get(),new Item.Properties()));
    // Tuff Slab
    public static final RegistryObject<SlabBlock> TUFF_SLAB = BLOCKS.register("tuff_slab", () -> new SlabBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_SLAB_ITEM = ITEMS.register("tuff_slab", () -> new BlockItem(TUFF_SLAB.get(),new Item.Properties()));
    // Tuff Stairs
    public static final RegistryObject<StairBlock> TUFF_STAIRS = BLOCKS.register("tuff_stairs", () -> new StairBlock(() -> POLISHED_TUFF.get().defaultBlockState() , TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_STAIRS_ITEM = ITEMS.register("tuff_stairs", () -> new BlockItem(TUFF_STAIRS.get(),new Item.Properties()));
    // Tuff Wall
    public static final RegistryObject<WallBlock> TUFF_WALL = BLOCKS.register("tuff_wall", () -> new WallBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_WALL_ITEM = ITEMS.register("tuff_wall", () -> new BlockItem(TUFF_WALL.get(),new Item.Properties()));

    public TuffBackport()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(TUFF_BRICKS_ITEM);
            event.accept(TUFF_BRICK_SLAB_ITEM);
            event.accept(TUFF_BRICK_STAIRS_ITEM);
            event.accept(TUFF_BRICK_WALL_ITEM);
            event.accept(CHISELED_TUFF_BRICKS_ITEM);
            event.accept(CHISELED_TUFF_ITEM);
            event.accept(CHISELED_TUFF_BRICKS_ITEM);
            event.accept(POLISHED_TUFF_ITEM);
            event.accept(POLISHED_TUFF_SLAB_ITEM);
            event.accept(POLISHED_TUFF_STAIRS_ITEM);
            event.accept(POLISHED_TUFF_WALL_ITEM);
            event.accept(TUFF_SLAB_ITEM);
            event.accept(TUFF_STAIRS_ITEM);
            event.accept(TUFF_WALL_ITEM);
    }
}
