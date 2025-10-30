package com.studio.tamer.gardenia.blocks.glowingflower.models;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EmissiveBakedModel implements BakedModel {
    private final BakedModel original;
    private static final int FULL_BRIGHT = 0xF000F0;

    public EmissiveBakedModel(BakedModel original) {
        this.original = original;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState blockState, @Nullable Direction direction, RandomSource randomSource) {
        List<BakedQuad> quads = new ArrayList<>(original.getQuads(blockState, direction, randomSource));

        for (int i = 0; i < quads.size(); i++) {
            BakedQuad quad = quads.get(i);
            String texturePath = quad.getSprite().contents().name().getPath();

            if (texturePath.contains("emissive") || texturePath.contains("glow")) {
                int[] vertexData = quad.getVertices().clone();
                for (int v = 0; v < 4; v++) {
                    vertexData[7 + v * 8] = FULL_BRIGHT;
                }
                quads.set(i, new BakedQuad(
                        vertexData,
                        quad.getTintIndex(),
                        quad.getDirection(),
                        quad.getSprite(),
                        quad.isShade()
                ));
            }
        }
        return quads;
    }

    @Override public boolean useAmbientOcclusion() { return original.useAmbientOcclusion(); }
    @Override public boolean isGui3d() { return original.isGui3d(); }
    @Override public boolean usesBlockLight() { return original.usesBlockLight(); }
    @Override public boolean isCustomRenderer() { return false; }
    @Override public net.minecraft.client.renderer.texture.TextureAtlasSprite getParticleIcon() { return original.getParticleIcon(); }

    @Override
    public ItemTransforms getTransforms() {
        return null;
    }

    @Override public ItemOverrides getOverrides() { return original.getOverrides(); }
}
