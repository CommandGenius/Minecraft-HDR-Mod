package xyz.rrtt217.HDRMod.fabric.mixin.compat.ixeris;

import me.decce.ixeris.api.IxerisApi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.rrtt217.HDRMod.util.GLFWColorManagement;

@Mixin(value = GLFWColorManagement.class, remap = false)
public class MixinGLFWColorManagement {

    @Inject(method = "glfwGetWindowSdrWhiteLevel", at = @At("HEAD"), cancellable = true, remap = false)
    private static void hdr_mod$getSdrWhiteLevelOnMainThread(long window,
                                                             CallbackInfoReturnable<Float> cir) {
        IxerisApi api = IxerisApi.getInstance();
        if (api.isEnabled() && !api.isOnMainThreadOrInit()) {
            cir.setReturnValue(api.query(() -> GLFWColorManagement.glfwGetWindowSdrWhiteLevel(window)));
        }
    }

    @Inject(method = "glfwGetWindowMinLuminance", at = @At("HEAD"), cancellable = true, remap = false)
    private static void hdr_mod$getMinLuminanceOnMainThread(long window,
                                                            CallbackInfoReturnable<Float> cir) {
        IxerisApi api = IxerisApi.getInstance();
        if (api.isEnabled() && !api.isOnMainThreadOrInit()) {
            cir.setReturnValue(api.query(() -> GLFWColorManagement.glfwGetWindowMinLuminance(window)));
        }
    }

    @Inject(method = "glfwGetWindowMaxLuminance", at = @At("HEAD"), cancellable = true, remap = false)
    private static void hdr_mod$getMaxLuminanceOnMainThread(long window,
                                                            CallbackInfoReturnable<Float> cir) {
        IxerisApi api = IxerisApi.getInstance();
        if (api.isEnabled() && !api.isOnMainThreadOrInit()) {
            cir.setReturnValue(api.query(() -> GLFWColorManagement.glfwGetWindowMaxLuminance(window)));
        }
    }

    @Inject(method = "glfwGetWindowPrimaries", at = @At("HEAD"), cancellable = true, remap = false)
    private static void hdr_mod$getPrimariesOnMainThread(long window,
                                                         CallbackInfoReturnable<Integer> cir) {
        IxerisApi api = IxerisApi.getInstance();
        if (api.isEnabled() && !api.isOnMainThreadOrInit()) {
            cir.setReturnValue(api.query(() -> GLFWColorManagement.glfwGetWindowPrimaries(window)));
        }
    }

    @Inject(method = "glfwGetWindowTransfer", at = @At("HEAD"), cancellable = true, remap = false)
    private static void hdr_mod$getTransferOnMainThread(long window,
                                                        CallbackInfoReturnable<Integer> cir) {
        IxerisApi api = IxerisApi.getInstance();
        if (api.isEnabled() && !api.isOnMainThreadOrInit()) {
            cir.setReturnValue(api.query(() -> GLFWColorManagement.glfwGetWindowTransfer(window)));
        }
    }
}
