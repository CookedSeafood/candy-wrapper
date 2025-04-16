package net.cookedseafood.candywrapper.util;

import java.util.List;
import java.util.Map;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;

public class NbtElements {
    public NbtCompound newNbtCompound(Map<String, NbtElement> entries) {
        return new NbtCompound(entries);
    }

    public NbtCompound newNbtCompound() {
        return new NbtCompound();
    }

    public NbtList newNbtList(List<NbtElement> list, byte type) {
        return new NbtList(list, type);
    }

    public NbtList newNbtList() {
        return new NbtList();
    }
}
