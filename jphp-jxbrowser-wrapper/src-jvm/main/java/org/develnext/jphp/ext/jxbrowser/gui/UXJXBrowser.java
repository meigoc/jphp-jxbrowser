package org.develnext.jphp.ext.jxbrowser.gui;

import com.teamdev.jxbrowser.chromium.*;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import org.develnext.jphp.ext.javafx.classes.layout.UXStackPane;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import org.develnext.jphp.ext.jxbrowser.engine.settings.JXBrowserSettings;
import org.develnext.jphp.ext.jxbrowser.gui.menu.CustomContextMenu;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.ext.JavaExtension;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseObject;
import php.runtime.lang.spl.Traversable;
import php.runtime.reflection.ClassEntity;

import java.awt.*;
import java.util.HashMap;

@Reflection.Namespace(JXBrowserExtension.NS)
@Reflection.Name("UXJXBrowser")
public class UXJXBrowser extends UXStackPane<BrowserView> {
    public UXJXBrowser(Environment env, BrowserView wrappedObject) {
        super(env, wrappedObject);
    }
    public UXJXBrowser(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }



    protected Browser engine;
    protected Invoker doShowContextMenu;
    protected Invoker showContextMenu;

    public BrowserView getWrappedObject(){
        return (BrowserView)super.getWrappedObject();
    }

    @Reflection.Signature
    public void initBrowser(JXBrowserSettings settings)
    {
        BrowserContext context = new BrowserContext(settings.getBrowserContextParams());

        engine = new Browser(context);

        __wrappedObject = new BrowserView(engine);

        CustomContextMenu.createInstance();

        _setEvents();

    }

    @Reflection.Getter
    public Browser getEngine(){return engine;}

    private void _setEvents()
    {
        engine.setContextMenuHandler(new ContextMenuHandler() {
            @Override
            public void showContextMenu(ContextMenuParams params) {
                try {
                    if (doShowContextMenu != null) {
                        doShowContextMenu.call();
                    }

                } catch (Throwable e) {
                   e.printStackTrace();
                }

                CustomContextMenu.showCustomContextMenu(getWrappedObject(), params);

                try {
                    if (showContextMenu != null) {
                        showContextMenu.call();
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Reflection.Signature
    public void setOnDoShowContextMenu(Invoker invoker)
    {
        doShowContextMenu = invoker;
    }

    @Reflection.Signature
    public void setOnShowContextMenu(Invoker invoker)
    {
        showContextMenu = invoker;
    }

    @Reflection.Signature
    public void addContextMenuItem(MenuItem menuItem)
    {
        CustomContextMenu.addItemMenu(menuItem);
    }

    @Reflection.Signature
    public void removeContextMenuItem(int i)
    {
        CustomContextMenu.removeItemMenu(i);
    }



}