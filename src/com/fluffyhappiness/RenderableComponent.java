package com.fluffyhappiness;

import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import net.mmarss.grease.ecs.Component;

// An entity component that allows an entity to be rendered
public class RenderableComponent extends Component {
	
	private Spatial spatial;
	
	public RenderableComponent(Spatial spatial) {
		
		this.spatial = spatial;
	}
	
	public Spatial getSpatial() {
		
		return spatial;
	}
	
	/**
	 * Attaches this component's spatial to the specified node.
	 */
	public void attachTo(Node node) {
		
		node.attachChild(spatial);
	}
}
