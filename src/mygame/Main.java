package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;
import com.sun.scenario.Settings;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        
        settings.setResolution(1366, 768);
        app.setSettings(settings);
        
        app.start(JmeContext.Type.Display);
    }
    
    
    ButtonHolder holder;

    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        flyCam.setEnabled(false);
        
        holder = new ButtonHolder(guiNode, assetManager);
        
        rootNode.attachChild(geom);
        
        inputManager.addMapping("MouseLeftClicked", new MouseButtonTrigger(mouseInput.BUTTON_LEFT));
        
        inputManager.addListener(actionListener, "MouseLeftClicked");
    }
    
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean isPressed, float tpf) {
            if (name.equals("MouseLeftClicked") && isPressed == true) {
                holder.CheckMousePos(inputManager.getCursorPosition());
            }
        }
            
    };

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
