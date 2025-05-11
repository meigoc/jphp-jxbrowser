package org.develnext.jphp.ext.jxbrowser.engine.settings;

import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

// Lol какойто баг, когда используется BaseWrapper..

@Reflection.Namespace(JXBrowserExtension.NS + "\\engine\\settings")
@Reflection.Name("JXBrowserSettings")
@Reflection.Final
public class JXBrowserSettings extends BaseObject {
    protected BrowserContextParams __browserContextParams;

    public JXBrowserSettings(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void xuy()
    {

    }

    @Reflection.Signature
    public void __construct(String dataDir)
    {
        __browserContextParams = new BrowserContextParams(dataDir);

    }

    @Reflection.Signature
    public void __construct(String dataDir, String acceptLanguage)
    {
        __browserContextParams = new BrowserContextParams(dataDir, acceptLanguage);
    }

    @Reflection.Getter
    public String getAcceptLanguage(){return __browserContextParams.getAcceptLanguage();}

    @Reflection.Setter
    public void setAcceptLanguage(String acceptLanguage){__browserContextParams.setAcceptLanguage(acceptLanguage);}

    @Reflection.Getter
    public String getDataDir(){return __browserContextParams.getDataDir();}

    @Reflection.Setter
    public void setCacheDataDir(String cacheDir){__browserContextParams.setCacheDir(cacheDir);}

    @Reflection.Setter
    public void setMemoryDir(String memoryDir){__browserContextParams.setMemoryDir(memoryDir);}

    @Reflection.Getter
    public String getMemoryDir(){return __browserContextParams.getMemoryDir();}

    public BrowserContextParams getBrowserContextParams(){return __browserContextParams;}
}
