<?php
namespace php\gui\jxbrowser;

use php\gui\layout\UXStackPane;
use php\gui\UXApplication;
use php\gui\UXNode;
use php\gui\jxbrowser\engine\JXBrowserEngine;
use php\gui\jxbrowser\engine\settings\JXBrowserSettings;
class UXJXBrowser extends UXStackPane
{

    /**
     * @var JXBrowserEngine
     */
    public $engine;

     /**
      * ПРЕНастойка браузера
      * @param JXBrowserSettings $jxbrowserSettings
      */
    public function __construct($jxbrowserSettings)
    {

    }


}
