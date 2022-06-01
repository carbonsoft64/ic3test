
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.carbonsoft.ic.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import net.carbonsoft.ic.world.features.plants.RubberTreeFeature;
import net.carbonsoft.ic.world.features.ores.TinOreFeature;
import net.carbonsoft.ic.world.features.ores.CopperOreFeature;
import net.carbonsoft.ic.world.features.RubberTree2Feature;
import net.carbonsoft.ic.world.features.RubberTree1Feature;
import net.carbonsoft.ic.Ic3Mod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class Ic3ModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, Ic3Mod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> TIN_ORE = register("tin_ore", TinOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, TinOreFeature.GENERATE_BIOMES, TinOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> RUBBER_TREE = register("rubber_tree", RubberTreeFeature::feature, new FeatureRegistration(
			GenerationStep.Decoration.VEGETAL_DECORATION, RubberTreeFeature.GENERATE_BIOMES, RubberTreeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> RUBBER_TREE_1 = register("rubber_tree_1", RubberTree1Feature::feature, new FeatureRegistration(
			GenerationStep.Decoration.SURFACE_STRUCTURES, RubberTree1Feature.GENERATE_BIOMES, RubberTree1Feature::placedFeature));
	public static final RegistryObject<Feature<?>> RUBBER_TREE_2 = register("rubber_tree_2", RubberTree2Feature::feature, new FeatureRegistration(
			GenerationStep.Decoration.SURFACE_STRUCTURES, RubberTree2Feature.GENERATE_BIOMES, RubberTree2Feature::placedFeature));
	public static final RegistryObject<Feature<?>> COPPER_ORE = register("copper_ore", CopperOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, CopperOreFeature.GENERATE_BIOMES, CopperOreFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
