package me.lightlord323dev.cursedlevels.util;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Created by Luda on 7/17/2020.
 */
public class ItemBuilder {

    private ItemStack itemStack;

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
    }

    public ItemBuilder(String str) {
        Material material = Material.matchMaterial(str);
        if (material == null) {
            String[] data = str.split(":");
            material = Material.matchMaterial(data[0]);
            this.itemStack = new ItemStack(material, 1, Short.parseShort(data[1]));
        } else
            this.itemStack = new ItemStack(material);
    }

    public ItemBuilder setDisplayName(String displayName) {
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.setDisplayName(displayName);
        this.itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(String lore) {
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.setLore(Lists.newArrayList(lore));
        this.itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        this.itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return itemStack;
    }
}
