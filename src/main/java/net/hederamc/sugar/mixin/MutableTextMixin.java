package net.hederamc.sugar.mixin;

import net.hederamc.sugar.api.MutableTextApi;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import java.util.List;
import java.util.stream.Collectors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MutableText.class)
public abstract class MutableTextMixin implements MutableTextApi {
    @Override
    public Text deepCopy() {
        return new MutableText(
            this.getContent(),
            this.getSiblings().stream()
                .map(MutableText.class::cast)
                .map(mutableText -> mutableText.deepCopy())
                .collect(Collectors.toList()),
            this.getStyle()
        );
    }

    @Shadow
    public abstract TextContent getContent();

    @Shadow
    public abstract List<Text> getSiblings();

    @Shadow
    public abstract Style getStyle();
}
