<?php


namespace develnext\bundle\jxbrowsermacosdependence;


use ide\bundle\AbstractBundle;
use ide\bundle\AbstractJarBundle;

class JXBrowserMacOsDependence extends AbstractJarBundle{
    function onAdd(Project $project, AbstractBundle $owner = null){
        parent::onAdd($project, $owner);
    }
    function onRemove(Project $project, AbstractBundle $owner = null){
        parent::onRemove($project, $owner);
    }

    public function onRegister(IdeLibraryBundleResource $resource)
    {
        parent::onRegister($resource);
    }
}