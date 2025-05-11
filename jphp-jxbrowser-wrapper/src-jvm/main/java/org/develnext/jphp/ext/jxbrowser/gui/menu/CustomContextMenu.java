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

import java.awt.*;


public class CustomContextMenu extends ContextMenu {

    protected static ContextMenu instance;

    protected CustomContextMenu() {
        super();

        if (instance == null) {
            setAutoHide(true);
            instance = this;
        }
    }

    public static void createInstance()
    {
        new CustomContextMenu();
    }

    public static void addItemMenu(MenuItem menuI)
    {
        instance.getItems().add(menuI);
    }

    public static boolean removeItemMenu(MenuItem menuI)
    {
        return instance.getItems().remove(menuI);
    }

    public static MenuItem removeItemMenu(int index)
    {
        return instance.getItems().remove(index);
    }

    public static void showCustomContextMenu(BrowserView browserV, ContextMenuParams params)
    {
        Platform.runLater(() -> {
            instance.hide();

            Point location = params.getLocation();
            Point2D screenCoords = browserV.localToScreen(
                    location.getX(),
                    location.getY()
            );

            instance.show(browserV, screenCoords.getX(), screenCoords.getY());
        });
    }
}
