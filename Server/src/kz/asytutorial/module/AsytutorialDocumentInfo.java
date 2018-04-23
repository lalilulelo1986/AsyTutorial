/*
 * AsytutorialDocumentInfo.java
 *
 * Created on Apr 19, 2018 11:30:35 AM
 */

package kz.asytutorial.module;


import so.kernel.server.DocumentModuleInfo;
import so.kernel.server.Server;



/**
 *
 */
public class AsytutorialDocumentInfo extends DocumentModuleInfo {
    
    /** Creates a new instance of AsytutorialDocumentInfo */
    public AsytutorialDocumentInfo() {
        super();
    }
    
    protected void init() {
        String url = Server.getString("module.kz.asytutorial.gcf.url");
        String usr = Server.getString("module.kz.asytutorial.gcf.user");
        String passwd = Server.getString("module.kz.asytutorial.gcf.password");
        
        String iedTable = Server.getString("module.kz.asytutorial.gcf.tables.ied");
        String historyTable = Server.getString("module.kz.asytutorial.gcf.tables.history");
        String locksTable = Server.getString("module.kz.asytutorial.gcf.tables.locks");
        String trackTable = Server.getString("module.kz.asytutorial.gcf.tables.track");
        
        setIED(url, usr, passwd, iedTable);
        setHistory(url, usr, passwd, historyTable);
        setLocks(url, usr, passwd, locksTable);
        setTrack(url, usr, passwd, trackTable);
        
        
    }
    
}
