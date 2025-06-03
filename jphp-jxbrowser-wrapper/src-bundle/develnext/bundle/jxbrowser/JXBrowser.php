<?php

namespace develnext\bundle\jxbrowser;

use ide\bundle\AbstractBundle;
use ide\bundle\AbstractJarBundle;
use ide\formats\GuiFormFormat;
use ide\Ide;
use ide\library\IdeLibraryBundleResource;
use ide\project\Project;
use php\desktop\Runtime;
use php\io\File;
use php\lib\fs;

class JXBrowser extends AbstractJarBundle
{
    public function onAdd(Project $project, AbstractBundle $owner = null){
        parent::onAdd($project, $owner);
    }
    public function onRemove(Project $project, AbstractBundle $owner = null){
        parent::onRemove($project, $owner);
    }

    public function onRegister(IdeLibraryBundleResource $resource)
    {
        parent::onRegister($resource);
    }
}
