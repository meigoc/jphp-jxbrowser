<?php
namespace php\gui\jxbrowser;

use php\gui\layout\UXStackPane;
use php\gui\UXApplication;
use php\gui\UXNode;
use php\gui\jxbrowser\engine\JXBrowserEngine;
use php\gui\jxbrowser\engine\settings\JXBrowserSettings;
use php\gui\UXMenuItem;
class UXJXBrowser extends UXStackPane
{

    /**
     * @var JXBrowserEngine
     */
    public $engine;


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

     /**
      * Вызывается псоле появления меню
      * @param closure $cl
      */
    public function setOnDoShowContextMenu($cl){}


     /**
      * Добавляет item в contextMenu
      * @param UXMenuItem $itemC
      */
    public function addContextMenuItem($itemC)
    {
    }

     /**
      * Удаляет item в contextMenu
      * @param int $i
      */
    public function removeContextMenuItem($i)
    {
    }


}
