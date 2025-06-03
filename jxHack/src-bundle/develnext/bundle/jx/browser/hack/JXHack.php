<?php

namespace develnext\bundle\jx\browser\hack;

use ide\bundle\AbstractBundle;
use ide\bundle\AbstractJarBundle;
use ide\library\IdeLibraryBundleResource;
use ide\project\Project;
use ide\forms\MessageBoxForm;
use ide\Logger;

/**
 * Class JXHack
 * @package develnext\bundle\jx\browser\hack
 */
class JXHack extends AbstractJarBundle
{

    const LICENSE_URL = 'https://teamdev.com/jxbrowser-licence-agreement';
    const PURCHASE_URL = 'https://teamdev.com/jxbrowser#licensing';

    /**
     * @param Project $project
     * @param AbstractBundle|null $owner
     */
    public function onAdd(Project $project, AbstractBundle $owner = null){
        parent::onAdd($project, $owner);

        $this->logLegalDisclaimer();
        $this->showLicenseAgreement();

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
        $this->logLegalDisclaimer();
    }

    protected function showLicenseAgreement(): bool
    {
        $msg = new MessageBoxForm(
            "JXBrowser ИНТЕГРАЦИЯ - ТОЛЬКО ДЛЯ ИССЛЕДОВАНИЙ\n\n" .
            "Данный модуль предоставляется исключительно для:\n" .
            "- Образовательных целей\n" .
            "- Тестирования совместимости\n" .
            "- Технических исследований\n\n" .
            "Продолжая, вы подтверждаете что:\n" .
            "1. Понимаете необходимость лицензии для коммерческого использования\n" .
            "2. Принимаете полную ответственность за соблюдение лицензии\n" .
            "3. Не будете использовать это в production-средах",
            [
                'Принимаю - Только для исследований',
                'Отказываюсь - Выход'
            ]
        );

        $msg->showDialog();

        if ($msg->getResultIndex() === 0) {
            alert("ВАЖНО: Для коммерческого использования ТРЕБУЕТСЯ лицензия:\n" . self::PURCHASE_URL);
            return true;
        }

        return false;
    }


    protected function logLegalDisclaimer()
    {
        $disclaimer = "
            Модуль интеграции JXBrowser - ЮРИДИЧЕСКОЕ УВЕДОМЛЕНИЕ
    
            Данное ПО предоставляет ТОЛЬКО ИНТЕРФЕЙС для работы с JXBrowser.
            Оно НЕ включает и НЕ модифицирует бинарные файлы JXBrowser.
    
            Важно:
            1. Требуется лицензия JXBrowser для любого использования кроме тестирования
            2. Разработчик НЕ предоставляет гарантий и НЕ несёт ответственности
            3. Все компоненты JXBrowser являются собственностью TeamDev
    
            Используя этот интерфейс, вы соглашаетесь с:
            - Лицензией JXBrowser:  https://teamdev.com/jxbrowser-licence-agreement
            - Условиями обслуживания: https://teamdev.com/tos
    
            Коммерческие пользователи должны приобрести лицензию: {self::PURCHASE_URL}
        ";

        var_dump($disclaimer);
    }
}
