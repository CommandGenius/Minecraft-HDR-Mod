package xyz.rrtt217.HDRMod.fabric.mixin.compat.flashback;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(targets = "com.moulberry.flashback.editor.ui.CustomImGuiImplGl3$Data")
public interface DataAccessor{
    @Accessor("glslVersion")
    String getGlslVersion();
}
