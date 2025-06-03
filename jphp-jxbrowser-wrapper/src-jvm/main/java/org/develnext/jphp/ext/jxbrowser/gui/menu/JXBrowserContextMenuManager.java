package org.develnext.jphp.ext.jxbrowser.gui.menu;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.ContextMenuHandler;
import com.teamdev.jxbrowser.chromium.ContextMenuParams;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

@Reflection.Namespace(JXBrowserExtension.NS + "\\menu")
@Reflection.Name("UXJXContextMenuManager")
public class JXBrowserContextMenuManager extends BaseObject {
    protected Invoker doShowContextMenu;
    protected Invoker showContextMenu;
    protected CustomContextMenu customContextMenu;
    protected BrowserView browserView;

    protected JXBrowserContextMenuManager(ClassEntity entity) {
        super(entity);

        makeCustomContextMenu(getEnvironment()); // <---- LOL
    }

    public JXBrowserContextMenuManager(Environment env, ClassEntity clazz) {
        super(env, clazz);

        makeCustomContextMenu(env);
    }

    public JXBrowserContextMenuManager(Environment env) {
        super(env);

        makeCustomContextMenu(env);
    }

    private void makeCustomContextMenu(Environment env)
    {
        customContextMenu = new CustomContextMenu(env, new ContextMenu());
    }

    public void initEvent(BrowserView browserView)
    {
        this.browserView = browserView;

        this.browserView.getBrowser().setContextMenuHandler(new ContextMenuHandler() {
            @Override
            public void showContextMenu(ContextMenuParams params) {
                try {
                    if (doShowContextMenu != null) {
                        doShowContextMenu.call();
                    }

                } catch (Throwable e) {
                    e.printStackTrace();
                }

                customContextMenu.showCustomContextMenu(browserView, params);

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
        customContextMenu.addItemMenu(menuItem);
    }

    @Reflection.Signature
    public void removeContextMenuItem(int i)
    {
        customContextMenu.removeItemMenu(i);
    }

    @Reflection.Signature
    public void showContextMenu(double x, double y)
    {
        customContextMenu.showCustomContextMenu(browserView,x, y );
    }

    @Reflection.Getter
    public BrowserView getBrowserView(){return browserView;}

    @Reflection.Getter
    public CustomContextMenu getContextMenu()
    {
        return customContextMenu;
    }


}
