package net.hederamc.cw.mixin;

import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.EntityPassengersSetS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.hederamc.cw.api.EntityApi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin implements EntityApi{
    @Shadow private double lastX;
    @Shadow private double lastY;
    @Shadow private double lastZ;
    @Shadow private Vec3d pos;

    @Redirect(
        method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/EntityType;isSaveable()Z"
        )
    )
    private boolean isSaveableOrPlayer(EntityType<?> entityType) {
        if (entityType.isSaveable()) {
            return true;
        }

        return this.isPlayer();
    }

    @Inject(
        method = "addPassenger(Lnet/minecraft/entity/Entity;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/Entity;emitGameEvent(Lnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/entity/Entity;)V",
            shift = At.Shift.AFTER
        )
    )
    private void sendPassengerAdditionPacket(Entity passenger, CallbackInfo ci) {
        Entity entity = (Entity)(Object)this;
        if (entity instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity)entity).networkHandler.sendPacket(new EntityPassengersSetS2CPacket(entity));
        }
    }

    @Inject(
        method = "removePassenger(Lnet/minecraft/entity/Entity;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/Entity;emitGameEvent(Lnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/entity/Entity;)V",
            shift = At.Shift.AFTER
        )
    )
    private void sendPassengerRemovePacket(Entity passenger, CallbackInfo ci) {
        Entity entity = (Entity)(Object)this;
        if (entity instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity)entity).networkHandler.sendPacket(new EntityPassengersSetS2CPacket(entity));
        }
    }

    @Override
    public double getLerpedX(float tickProgress) {
        return MathHelper.lerp(tickProgress, this.lastX, this.pos.x);
    }

    @Override
    public double getLerpedY(float tickProgress) {
        return MathHelper.lerp(tickProgress, this.lastY, this.pos.y);
    }

    @Override
    public double getLerpedZ(float tickProgress) {
        return MathHelper.lerp(tickProgress, this.lastZ, this.pos.z);
    }

    @Override
    public boolean hasCommandTag(String commandTag) {
        return this.getCommandTags().contains(commandTag);
    }

    @Shadow
    public abstract Set<String> getCommandTags();

    @Shadow
    public abstract boolean isPlayer();
}
