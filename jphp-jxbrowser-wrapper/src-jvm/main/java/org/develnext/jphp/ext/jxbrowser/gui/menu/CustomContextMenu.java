package org.develnext.jphp.ext.jxbrowser.gui.menu;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.ContextMenuParams;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.develnext.jphp.ext.javafx.classes.UXContextMenu;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

import java.awt.*;

@Reflection.Namespace(JXBrowserExtension.NS + "\\menu")
@Reflection.Name("UXJXContextMenu")
public class CustomContextMenu extends UXContextMenu<ContextMenu> {


    public CustomContextMenu(Environment env, ContextMenu wrappedObject) {
        super(env, wrappedObject);
    }

    public CustomContextMenu(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    public boolean removeItemMenu(MenuItem menuI)
    {
        return getWrappedObject().getItems().remove(menuI);
    }

    public MenuItem removeItemMenu(int index)
    {
        return getWrappedObject().getItems().remove(index);
    }

    public void addItemMenu(MenuItem menuI)
    {
         getWrappedObject().getItems().add(menuI);
    }

    public void showCustomContextMenu(BrowserView browserV, ContextMenuParams params)
    {
        Platform.runLater(() -> {
            getWrappedObject().hide();

            Point location = params.getLocation();
            Point2D screenCoords = browserV.localToScreen(
                    location.getX(),
                    location.getY()
            );

            showCustomContextMenu(browserV, screenCoords.getX(), screenCoords.getY());
        });
    }

    public void showCustomContextMenu(BrowserView browserV, double x, double y)
    {
        getWrappedObject().show(browserV, x, y);
    }


}
