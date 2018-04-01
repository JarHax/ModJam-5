package com.jarhax.jewelersconstruct.api.part;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class PartType extends IForgeRegistryEntry.Impl<PartType> {
    
    @SideOnly(Side.CLIENT)
    public String getTranslationName () {
        
        final ResourceLocation identifier = this.getRegistryName();
        return "jewelersconstruct.part." + identifier.getResourceDomain() + "." + identifier.getResourcePath();
    }
}