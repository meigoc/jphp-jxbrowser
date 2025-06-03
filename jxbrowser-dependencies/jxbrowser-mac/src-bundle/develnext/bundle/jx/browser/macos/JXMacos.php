<?php

namespace develnext\bundle\jx\browser\win64;

use ide\bundle\AbstractBundle;
use ide\bundle\AbstractJarBundle;
use ide\library\IdeLibraryBundleResource;
use ide\project\Project;
use ide\forms\MessageBoxForm;
use ide\Logger;

/**
 * Class JXMacos
 * @package develnext\bundle\jx\browser\macos
 */
class JXMacos extends AbstractJarBundle
{
    /**
     * @param Project $project
     * @param AbstractBundle|null $owner
     */
    public function onAdd(Project $project, AbstractBundle $owner = null){
        parent::onAdd($project, $owner);

        $this->logLegalWarning();
        $this->showLicenseWarning();

    }

    /**
     * @param Project $project
     * @param AbstractBundle|null $owner
     */
    public function onRemove(Project $project, AbstractBundle $owner = null){
        parent::onRemove($project, $owner);
    }

    /**
     * @param IdeLibraryBundleResource $resource
     */
    public function onRegister(IdeLibraryBundleResource $resource)
    {
        parent::onRegister($resource);
    }

    protected function showLicenseWarning() {
        $msg = new MessageBoxForm(
            "macOS зависимости JXBrowser\n\n" .
            "Для использования в коммерческих продуктах требуется:\n" .
            "- Действующая лицензия JXBrowser\n" .
            "- Соблюдение лицензионных ограничений TeamDev",
            ['Я согласен с условиями', 'Отказаться']
        );

        if ($msg->showDialog() && $msg->getResultIndex() == 1) {
            exit;
        }
    }

    protected function logLegalWarning() {
        var_dump("JXBrowser macOS Dependencies - WARNING: " .
            "This is not a hacked version but requires proper JXBrowser license. " .
            "Unauthorized use may lead to legal consequences. " .
            "License info: https://teamdev.com/jxbrowser-licence-agreement " .
            "Purchase: https://teamdev.com/jxbrowser#licensing");
    }
}
