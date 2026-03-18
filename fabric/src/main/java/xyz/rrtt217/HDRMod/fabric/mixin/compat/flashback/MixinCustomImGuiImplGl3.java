package xyz.rrtt217.HDRMod.fabric.mixin.compat.flashback;

import com.moulberry.flashback.editor.ui.CustomImGuiImplGl3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CustomImGuiImplGl3.class)
public class MixinCustomImGuiImplGl3 {
    @Shadow
    protected Object data;
    /**
     * @author rrtt217
     * @reason Do separate UI color transform for Flashback and Axiom
     */
    @Overwrite
    protected String fragmentShaderGlsl120(){
        return ((DataAccessor) data).getGlslVersion() + "\n#ifdef GL_ES\n    precision mediump float;\n#endif\nuniform sampler2D Texture;\nvarying vec2 Frag_UV;\nvarying vec4 Frag_Color;\nvoid main()\n{\n    gl_FragColor = Frag_Color * texture2D(Texture, Frag_UV.st);\n}\n";    }
}
