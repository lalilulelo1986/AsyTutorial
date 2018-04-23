/*
 * AsytutorialModule.java
 *
 * Created on Apr 19, 2018 11:30:35 AM
 */

package kz.asytutorial.module;

import so.kernel.core.modules.ModuleInstall;
import so.kernel.server.DocumentModulesManager;

/**
 *
 */
public class AsytutorialModule extends ModuleInstall {
    
    /** Creates a new instance of AsytutorialModule */
    public AsytutorialModule() {
    }
    
    /** Called when an already-installed module is restored (at System startup
     * time). Should perform whatever initializations are required. The module
     * can load resource about the module. The class loader is a module class
     * loader.
     *
     */
    public void restored() {
        DocumentModulesManager.registerModule(new AsytutorialDocumentInfo());
    }
    
}
