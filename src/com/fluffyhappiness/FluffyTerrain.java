package com.fluffyhappiness;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.Vector2f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.terrain.geomipmap.TerrainLodControl;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;

/** The terrain manager for the game. */
public class FluffyTerrain {
	
	/** The JME terrain object. */
	private TerrainQuad	terrain;
	private Material	terrainMaterial;
	
	public FluffyTerrain(AssetManager assetManager) {
		
		// Hello terrain code from
			// https://jmonkeyengine.github.io/wiki/jme3/beginner/hello_terrain.html
		terrainMaterial = new Material(assetManager, "Common/MatDefs/Terrain/Terrain.j3md");
		terrainMaterial.setTexture("Alpha", assetManager.loadTexture("Textures/Terrain/splat/alphamap.png"));
		
		Texture grass = assetManager.loadTexture("Textures/Terrain/splat/grass.jpg");
		grass.setWrap(WrapMode.Repeat);
		terrainMaterial.setTexture("Tex1", grass);
		terrainMaterial.setFloat("Tex1Scale", 64f);
		
		Texture dirt = assetManager.loadTexture("Textures/Terrain/splat/dirt.jpg");
		dirt.setWrap(WrapMode.Repeat);
		terrainMaterial.setTexture("Tex2", dirt);
		terrainMaterial.setFloat("Tex2Scale", 32f);
		
		Texture road = assetManager.loadTexture("Textures/Terrain/splat/road.jpg");
		road.setWrap(WrapMode.Repeat);
		terrainMaterial.setTexture("Tex3", road);
		terrainMaterial.setFloat("Tex3Scale", 128f);
		
		AbstractHeightMap heightmap = null;
		Texture heightMapImage = assetManager.loadTexture("Textures/Terrain/splat/mountains512.png");
		heightmap = new ImageBasedHeightMap(heightMapImage.getImage());
		heightmap.load();
		
		int patchSize = 65;
		terrain = new TerrainQuad("my terrain", patchSize, 513, heightmap.getHeightMap());
		
		terrain.setMaterial(terrainMaterial);
		terrain.setLocalScale(2f, 1f, 2f);
	}
	
	/** Enables Level of Detail for this terrain mesh. */
	public void initLod(Camera camera) {
		
		TerrainLodControl control = new TerrainLodControl(terrain, camera);
		terrain.addControl(control);
	}
	
	/** Attaches this terrain's spatial to the specified node. */
	public void attachTo(Node node) {
		
		node.attachChild(terrain);
	}
	
	/**
	 * @param pos
	 *            the position at which to get the terrain height.
	 * @return the terrain height at the specified location.
	 */
	public float getHeight(Vector2f pos) {
		
		return terrain.getHeight(pos);
	}
	
	/**
	 * @param x
	 *            the x-component of the position at which to get the terrain
	 *            height.
	 * @param z
	 *            the z-component of the position at which to get the terrain
	 *            height.
	 * @return the terrain height at the specified location.
	 */
	public float getHeight(float x, float z) {
		
		return terrain.getHeight(new Vector2f(x, z));
	}
}
