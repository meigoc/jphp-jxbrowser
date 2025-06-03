<?php
namespace php\gui\jxbrowser;

use php\gui\layout\UXStackPane;
use php\gui\UXApplication;
use php\gui\UXNode;
use php\gui\jxbrowser\engine\JXBrowserEngine;
use php\gui\jxbrowser\engine\settings\JXBrowserSettings;
use php\gui\jxbrowser\menu\UXJXContextMenuManager;
use php\gui\UXMenuItem;
class UXJXBrowser extends UXStackPane
{

    /**
     * @var JXBrowserEngine
     * @readonly
     */
    public $engine;

    /**
     * @var UXJXContextMenuManager
     * @readonly
    */
    public $contextMenuManager;


    public function __construct()
    {

    }
     /**
      * Инициализация браузера, вызвать после создания instance браузера.
      * @param JXBrowserSettings $jxbrowserSettings
      */
    public function initBrowser()
    {
    }




}
