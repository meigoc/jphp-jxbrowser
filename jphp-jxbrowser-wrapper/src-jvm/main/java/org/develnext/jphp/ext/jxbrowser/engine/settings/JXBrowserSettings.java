package org.develnext.jphp.ext.jxbrowser.engine.settings;

import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import org.develnext.jphp.ext.jxbrowser.JXBrowserExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Namespace(JXBrowserExtension.NS + "\\engine\\settings")
@Reflection.Name("JXBrowserSettings")
@Reflection.Final
public class JXBrowserSettings extends BaseWrapper<BrowserContextParams> {
    public JXBrowserSettings(Environment env, BrowserContextParams wrappedObject) {
        super(env, wrappedObject);
    }

    public JXBrowserSettings(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(String dataDir)
    {
        __wrappedObject = new BrowserContextParams(dataDir);

    }

    @Reflection.Signature
    public void __construct(String dataDir, String acceptLanguage)
    {
        __wrappedObject = new BrowserContextParams(dataDir, acceptLanguage);
    }

    @Reflection.Getter
    public String getAcceptLanguage(){return __wrappedObject.getAcceptLanguage();}

    @Reflection.Setter
    public void setAcceptLanguage(String acceptLanguage){__wrappedObject.setAcceptLanguage(acceptLanguage);}

    @Reflection.Getter
    public String getDataDir(){return __wrappedObject.getDataDir();}

    @Reflection.Setter
    public void setCacheDataDir(String cacheDir){__wrappedObject.setCacheDir(cacheDir);}

    @Reflection.Setter
    public void setMemoryDir(String memoryDir){__wrappedObject.setMemoryDir(memoryDir);}

    @Reflection.Getter
    public String getMemoryDir(){return __wrappedObject.getMemoryDir();}
}
