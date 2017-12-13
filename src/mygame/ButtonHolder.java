/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

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
        button.CheckPosition(pos);
    }

    @Override
    public void buttonCallback(String id) {
        System.out.println("Button Clicked");
    }
    
    
    
}
