package com.jarhax.jewelersconstruct.blocks;

import javax.annotation.Nullable;

import com.jarhax.jewelersconstruct.JewelersConstruct;
import com.jarhax.jewelersconstruct.tileentities.TileEntityPartShaper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPartShaper extends Block {
    
    public BlockPartShaper() {
        
        super(Material.IRON);
        this.setHardness(2.0f);
    }
    
    @Override
    public boolean onBlockActivated (World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        
        if (!worldIn.isRemote) {
            playerIn.openGui(JewelersConstruct.INSTANCE, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
    
    @Override
    public void breakBlock (World worldIn, BlockPos pos, IBlockState state) {
        
        final TileEntityPartShaper tileentity = (TileEntityPartShaper) worldIn.getTileEntity(pos);
        
        for (int i = 0; i < tileentity.getInventory().getSlots(); i++) {
            InventoryHelper.spawnItemStack(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ(), tileentity.getInventory().getStackInSlot(i));
        }
        worldIn.updateComparatorOutputLevel(pos, this);
        
        super.breakBlock(worldIn, pos, state);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox (IBlockState state, IBlockAccess source, BlockPos pos) {
        
        return new AxisAlignedBB(0, 0, 0, 1, 1 - 0.0625, 1);
    }
    
    @Override
    public boolean hasTileEntity (IBlockState state) {
        
        return true;
    }
    
    @Nullable
    @Override
    public TileEntity createTileEntity (World world, IBlockState state) {
        
        return new TileEntityPartShaper();
    }
    
    @Override
    public boolean isTopSolid (IBlockState state) {
        
        return false;
    }
    
    @Override
    public boolean isFullBlock (IBlockState state) {
        
        return false;
    }
    
    @Override
    public boolean isOpaqueCube (IBlockState state) {
        
        return false;
    }
    
}
