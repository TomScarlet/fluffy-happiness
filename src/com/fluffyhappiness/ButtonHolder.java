/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluffyhappiness;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector2f;
import com.jme3.scene.Node;


/**
 *
 * @author thomas
 */
public class ButtonHolder implements ButtonClicked {
    
    
    
    private Button button;
    
    private Node guiNode;
    
    public ButtonHolder(Node guiNode, AssetManager assetManager) {
        button = new Button(this, assetManager);
        this.guiNode = guiNode;
        guiNode.attachChild(button);
    }
    
    public void CheckMousePos(Vector2f pos) {
        button.checkClickPosition(pos);
    }

    @Override
    public void ButtonCallback(String id) {
        System.out.println("Button Clicked");
    }
    /**
     * Takes size, texture and config
     */
    /**
     * 
     * @param width Width of button
     * @param height Height of button
     * @param texPath Path to texture and texture config files
     */
    public Button CreateButton(int width, int height, String texPath) {
        
        Button temp = new Button(this);
        return temp;
    }
    
}
