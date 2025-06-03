<?php
namespace php\gui\jxbrowser\menu;

use php\gui\jxbrowser\menu\UXJXContextMenu;
use php\gui\jxbrowser\UXJXBrowser;
use php\gui\UXMenuItem;
/**
 * Менеджер контекстного меню браузера
 *
 * @property-read UXJXContextMenu $contextMenu - текущее контекстное меню
 * @property-read UXJXBrowser $browserView - связанный BrowserView
 */
class UXJXContextMenuManager {

    /**
      * @var UXJXContextMenu
    */
    public $contextMenu;

    /**
      * @var UXJXBrowser
    */
    public $browserView;

    /**
     * Устанавливает обработчик, который вызывается перед показом контекстного меню
     *
     * @param callable $handler Функция-обработчик
     */
    public function setOnDoShowContextMenu(callable $handler) {}

    /**
     * Устанавливает обработчик, который вызывается после показа контекстного меню
     *
     * @param callable $handler Функция-обработчик
     */
    public function setOnShowContextMenu(callable $handler) {}

    /**
     * Добавляет пункт в контекстное меню
     *
     * @param UXMenuItem $menuItem Добавляемый пункт меню
     */
    public function addContextMenuItem($menuItem) {}

    /**
     * Удаляет пункт из контекстного меню по индексу
     *
     * @param int $index Индекс удаляемого пункта
     */
    public function removeContextMenuItem(int $index) {}

    /**
     * Показывает контекстное меню в указанных координатах
     *
     * @param float $x Координата X
     * @param float $y Координата Y
     */
    public function showContextMenu( float $x, float $y) {}

}


