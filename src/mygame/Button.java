/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Quad;


/**
 *
 * @author thomas
 */
class Button extends Node{

    private ButtonClicked bc;
    private boolean eventOccured;
    
    private String id;
    
    private Vector2f position;
    private Vector2f size;
    
    public Button(ButtonClicked bc, AssetManager assetManager) {
        this.bc = bc;
        id = "TEST";
        eventOccured = false;
        position = new Vector2f(400,400);
        size = new Vector2f(70, 20);
        
        
        Quad q = new Quad(size.x, size.y);
        Geometry geom = new Geometry("buttonQuad", q);
        
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Green);
        geom.setMaterial(mat2);
        
        this.attachChild(geom);
        
        geom.setLocalTranslation(position.x, position.y, 0);
    }
    
    public void CheckPosition(Vector2f pos) {
        if (pos.x > position.x && pos.x < position.x + size.x) {
            if (pos.y > position.y && pos.y < position.y + size.y) {
                bc.buttonCallback(id);
            }
        }
    }
    
    
    
}
