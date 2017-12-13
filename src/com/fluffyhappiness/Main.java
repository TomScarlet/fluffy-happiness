package com.fluffyhappiness;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;

import net.mmarss.grease.ecs.Entity;
import net.mmarss.grease.ecs.EntityManager;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * 
 * @author normenhansen
 */
public class Main extends SimpleApplication {
	
	private FluffyTerrain terrain;
	
	private EntityManager entityManager;
	
	private Entity townCenter;
	
	public Main() {
		
	}
	
	public static void main(String[] args) {
		
		Main app = new Main();
		
		// App settings
		AppSettings settings = new AppSettings(true);
		settings.setResolution(1366, 768);
		settings.setResizable(true);
		app.setSettings(settings);
		
		app.start(JmeContext.Type.Display);
	}
	
	@Override
	public void simpleInitApp() {
		
		flyCam.setMoveSpeed(20f);
		
		// Create terrain
		terrain = new FluffyTerrain(assetManager);
		terrain.initLod(getCamera());
		terrain.attachTo(rootNode);
		
		// Game entities
		entityManager = new EntityManager();
		
		// Town center
		townCenter = entityManager.createEntity();
		Geometry geometry = new Geometry("Box", new Box(1, 1, 1));
		geometry.setLocalTranslation(0, terrain.getHeight(0, 0), 0);
		Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		material.setColor("Color", ColorRGBA.Blue);
		geometry.setMaterial(material);
		entityManager.addComponent(townCenter, new RenderableComponent(geometry), RenderableComponent.class);
		
		entityManager.getComponent(townCenter, RenderableComponent.class).attachTo(rootNode);
		
		// Escape key toggles menu
		inputManager.deleteMapping(SimpleApplication.INPUT_MAPPING_EXIT);
		inputManager.addMapping("Menu", new KeyTrigger(KeyInput.KEY_ESCAPE));
		inputManager.addListener(new ActionListener() {
			
			private boolean menu = false;
			
			@Override
			public void onAction(String name, boolean isPressed, float tpf) {
				
				if (!isPressed) {
					flyCam.setEnabled(menu);
					inputManager.setCursorVisible(!menu);
					menu = !menu;
				}
			}
		}, "Menu");
		
	}
	
	@Override
	public void simpleUpdate(float tpf) {
		// TODO: add update code
	}
	
	@Override
	public void simpleRender(RenderManager rm) {
		// TODO: add render code
	}
}
