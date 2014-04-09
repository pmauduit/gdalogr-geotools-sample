package com.camptocamp.gdalogr;
import java.util.Iterator;

import org.geotools.data.DataStoreFinder;
import org.geotools.data.DataStoreFactorySpi;


public class App 
{
    public static void main( String[] args )
    {
    	Iterator<DataStoreFactorySpi> dtf =  DataStoreFinder.getAllDataStores();
        System.out.println("Available datastores from GDAL/OGR:");
    	while (dtf.hasNext()) {
    		DataStoreFactorySpi dsfspi = dtf.next();
    		System.out.println("\t" + dsfspi.getDisplayName());
    	}	
    }
}
