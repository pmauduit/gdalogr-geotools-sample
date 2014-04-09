package com.camptocamp.gdalogr;
import java.util.Iterator;

import org.geotools.data.DataStoreFinder;
import org.geotools.data.DataStoreFactorySpi;


public class App 
{
    public static void main( String[] args )
    {
    	boolean containsOGR = false;
    	
    	Iterator<DataStoreFactorySpi> dtf =  DataStoreFinder.getAllDataStores();
        System.out.println("Available datastores:");
    	while (dtf.hasNext()) {
    		DataStoreFactorySpi dsfspi = dtf.next();
    		System.out.println("\t" + dsfspi.getDisplayName());
    		if ("OGR".equalsIgnoreCase(dsfspi.getDisplayName()))
    			containsOGR = true;
    	}
    	if (! containsOGR) {
    		System.out.println("\nOGR Datastore could not be found.");
    		
    	}
    }
}
