package com.studio.tamer.gardenia.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModdedItems {
    public static final Item MOD_ICON = new Item(new Item.Properties());

    private static Set<Map.Entry<ResourceLocation, Item>> itemListCache = null;
    public static final List<Item> itemList = new ArrayList<>();

    public static Set<Map.Entry<ResourceLocation, Item>> getItemListWithID() {
        if (itemListCache == null)
            itemListCache = Set.of(
                    Map.entry(getLoc("mod_icon"), MOD_ICON)
            );
        return itemListCache;
    }
    private static ResourceLocation getLoc(String id){
        return new ResourceLocation("gardenia", id);
    }
}
