/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fluffyhappiness;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Quad;
import com.jme3.shader.VarType;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.ui.Picture;


/**
 *
 * @author thomas
 */
class Button extends Node{

    private ButtonClicked bc;
    
    private String id;
    
    private Vector2f position;
    private Vector2f size;
    
    Picture mainImage;
    
    public Button(ButtonClicked bc, AssetManager assetManager) {
        this.bc = bc;
        id = "TEST";
        position = new Vector2f(400,400);
        size = new Vector2f(64, 64);
        
        
        Quad q = new Quad(size.x, size.y);
        Geometry geom = new Geometry("buttonQuad", q);
        
        
        //Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //mat2.setColor("Color", ColorRGBA.Green);
        
        Material mat2 = new Material(assetManager, "MatDefs/GuiButtonSpritesheet.j3md");
        
        Texture tex = assetManager.loadTexture("Interface/ButtonTemp.png");
        tex.setMinFilter(Texture.MinFilter.NearestLinearMipMap);
        tex.setMagFilter(Texture.MagFilter.Nearest);
        tex.setWrap(Texture.WrapMode.Repeat);
        
        mat2.setTexture("ColorMap", tex);
        mat2.setVector2("ImageSize", new Vector2f(64f, 64f));
        mat2.setFloat("BorderWidth", 2f);
        mat2.setVector2("ButtonSize", size);
        
        geom.setMaterial(mat2);
        
        this.attachChild(geom);
        
        geom.setLocalTranslation(position.x, position.y, 0);
    }
    
    public Button (ButtonClicked bc) {
        this.bc = bc;
    }
    
    public void checkClickPosition(Vector2f pos) {
        if (pos.x > position.x && pos.x < position.x + size.x) {
            if (pos.y > position.y && pos.y < position.y + size.y) {
                bc.ButtonCallback(id);
            }
        }
    }
    
    /*public void setImage(AssetManager assetManager, String path) {
        int borderWidth = 2;
        
        mainImage = new Picture("ButtonImage");
        mainImage.setImage(assetManager, path, true);
        
        Texture tex = assetManager.loadTexture(path);
        //tex.getImage().
        
        //mainImage.setTexture(assetManager, tex, true);
        
    }*/
    
}
