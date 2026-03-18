package xyz.rrtt217.HDRMod.mixin;

import com.mojang.blaze3d.opengl.GlConst;
import com.mojang.blaze3d.opengl.GlDevice;
import com.mojang.blaze3d.textures.TextureFormat;
import me.shedaniel.autoconfig.AutoConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.lwjgl.opengl.GL30;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import xyz.rrtt217.HDRMod.config.HDRModConfig;
import xyz.rrtt217.HDRMod.util.HDRModInjectHooks;
import xyz.rrtt217.HDRMod.util.TextureUpgradeUtils;

import static xyz.rrtt217.HDRMod.HDRMod.enableHDR;

@Mixin(GlDevice.class)
public class MixinGlDevice {
    @ModifyArgs(method = "createTexture(Ljava/lang/String;ILcom/mojang/blaze3d/textures/TextureFormat;IIII)Lcom/mojang/blaze3d/textures/GpuTexture;", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/opengl/GlStateManager;_texImage2D(IIIIIIIILjava/nio/ByteBuffer;)V", ordinal = 1))
    private void hdr_mod$upgradeColorBufferFormat$0(Args args)
    {
        if(TextureUpgradeUtils.getTargetTextureFormat() > 0){
            TextureUpgradeUtils.resetTargetTextureFormat();
            args.set(2, TextureUpgradeUtils.getTargetTextureFormat());
        }
        if(TextureUpgradeUtils.getTargetReadPixelFormat() > 0){
            TextureUpgradeUtils.resetTargetReadPixelFormat();
            args.set(7, TextureUpgradeUtils.getTargetReadPixelFormat());
        }
    }
}
