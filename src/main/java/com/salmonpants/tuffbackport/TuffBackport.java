package com.salmonpants.tuffbackport;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tuffbackport")
public class TuffBackport
{

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final BlockBehaviour.Properties TUFF_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE);
    public static final String MODID = "tuffbackport";
    public static final CreativeModeTab TAB = new CreativeModeTab(MODID){
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.TUFF);
        }
    };
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    // Tuff Bricks
    public static final RegistryObject<Block> TUFF_BRICKS = BLOCKS.register("tuff_bricks", () -> new Block(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_BRICKS_ITEM = ITEMS.register("tuff_bricks", () -> new BlockItem(TUFF_BRICKS.get(),new Item.Properties().tab(TAB)));
    // Tuff Brick Slab
    public static final RegistryObject<SlabBlock> TUFF_BRICK_SLAB = BLOCKS.register("tuff_brick_slab", () -> new SlabBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_BRICK_SLAB_ITEM = ITEMS.register("tuff_brick_slab", () -> new BlockItem(TUFF_BRICK_SLAB.get(),new Item.Properties().tab(TAB)));
    // Tuff Brick Stairs
    public static final RegistryObject<StairBlock> TUFF_BRICK_STAIRS = BLOCKS.register("tuff_brick_stairs", () -> new StairBlock(() -> TUFF_BRICKS.get().defaultBlockState(), TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_BRICK_STAIRS_ITEM = ITEMS.register("tuff_brick_stairs", () -> new BlockItem(TUFF_BRICK_STAIRS.get(),new Item.Properties().tab(TAB)));
    // Tuff Brick Wall
    public static final RegistryObject<WallBlock> TUFF_BRICK_WALL = BLOCKS.register("tuff_brick_wall", () -> new WallBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_BRICK_WALL_ITEM = ITEMS.register("tuff_brick_wall", () -> new BlockItem(TUFF_BRICK_WALL.get(),new Item.Properties().tab(TAB)));
    // Chiseled Tuff
    public static final RegistryObject<Block> CHISELED_TUFF = BLOCKS.register("chiseled_tuff", () -> new Block(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> CHISELED_TUFF_ITEM = ITEMS.register("chiseled_tuff", () -> new BlockItem(CHISELED_TUFF.get(),new Item.Properties().tab(TAB)));
    // Chiseled Tuff Bricks
    public static final RegistryObject<Block> CHISELED_TUFF_BRICKS = BLOCKS.register("chiseled_tuff_bricks", () -> new Block(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> CHISELED_TUFF_BRICKS_ITEM = ITEMS.register("chiseled_tuff_bricks", () -> new BlockItem(CHISELED_TUFF_BRICKS.get(),new Item.Properties().tab(TAB)));
    // Polished Tuff
    public static final RegistryObject<Block> POLISHED_TUFF = BLOCKS.register("polished_tuff", () -> new Block(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_ITEM = ITEMS.register("polished_tuff", () -> new BlockItem(POLISHED_TUFF.get(),new Item.Properties().tab(TAB)));
    // Polished Tuff Slab
    public static final RegistryObject<SlabBlock> POLISHED_TUFF_SLAB = BLOCKS.register("polished_tuff_slab", () -> new SlabBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_SLAB_ITEM = ITEMS.register("polished_tuff_slab", () -> new BlockItem(POLISHED_TUFF_SLAB.get(),new Item.Properties().tab(TAB)));
    // Polished Tuff Stairs
    public static final RegistryObject<StairBlock> POLISHED_TUFF_STAIRS = BLOCKS.register("polished_tuff_stairs", () -> new StairBlock(() -> POLISHED_TUFF.get().defaultBlockState(), TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_STAIRS_ITEM = ITEMS.register("polished_tuff_stairs", () -> new BlockItem(POLISHED_TUFF_STAIRS.get(),new Item.Properties().tab(TAB)));
    // Polished Tuff Wall
    public static final RegistryObject<WallBlock> POLISHED_TUFF_WALL = BLOCKS.register("polished_tuff_wall", () -> new WallBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> POLISHED_TUFF_WALL_ITEM = ITEMS.register("polished_tuff_wall", () -> new BlockItem(POLISHED_TUFF_WALL.get(),new Item.Properties().tab(TAB)));
    // Tuff Slab
    public static final RegistryObject<SlabBlock> TUFF_SLAB = BLOCKS.register("tuff_slab", () -> new SlabBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_SLAB_ITEM = ITEMS.register("tuff_slab", () -> new BlockItem(TUFF_SLAB.get(),new Item.Properties().tab(TAB)));
    // Tuff Stairs
    public static final RegistryObject<StairBlock> TUFF_STAIRS = BLOCKS.register("tuff_stairs", () -> new StairBlock(() -> POLISHED_TUFF.get().defaultBlockState() , TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_STAIRS_ITEM = ITEMS.register("tuff_stairs", () -> new BlockItem(TUFF_STAIRS.get(),new Item.Properties().tab(TAB)));
    // Tuff Wall
    public static final RegistryObject<WallBlock> TUFF_WALL = BLOCKS.register("tuff_wall", () -> new WallBlock(TUFF_PROPERTIES));
    public static final RegistryObject<BlockItem> TUFF_WALL_ITEM = ITEMS.register("tuff_wall", () -> new BlockItem(TUFF_WALL.get(),new Item.Properties().tab(TAB)));

    public TuffBackport()
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("tuffbackport", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
