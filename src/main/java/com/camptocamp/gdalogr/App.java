package com.camptocamp.gdalogr;
import java.util.Iterator;
import java.util.Set;

import org.geotools.data.DataStoreFinder;
import org.geotools.data.DataStoreFactorySpi;
import org.geotools.data.ogr.OGRDataStoreFactory;
import org.geotools.data.ogr.jni.JniOGRDataStoreFactory;


public class App 
{
  public static void main( String[] args )
  {
    // Dumping available datastores
    boolean containsOGR = false;
    Iterator<DataStoreFactorySpi> dtf =  DataStoreFinder.getAllDataStores();
    System.out.println("[GDAL/OGR-SAMPLE] Available datastores:");
    while (dtf.hasNext()) {
      DataStoreFactorySpi dsfspi = dtf.next();
      System.out.println("\t" + dsfspi.getDisplayName());
      if ("OGR".equalsIgnoreCase(dsfspi.getDisplayName()))
        containsOGR = true;
    }
    if (! containsOGR) {
      System.out.println("[GDAL/OGR-SAMPLE] OGR Datastore could not be found.");
    }

    // Dumping OGR drivers (should fail if unable to load the ogrjni library)
    System.out.println("[GDAL/OGR-SAMPLE] trying to enumerate OGR drivers.");
    try {
      OGRDataStoreFactory factory = new JniOGRDataStoreFactory();
      Set<String> drivers = factory.getAvailableDrivers();
      for (String driver : drivers) {
        System.out.println("\tdriver: "+ driver);
      }
    } catch (UnsatisfiedLinkError e) {
      System.out.println("[GDAL/OGR-SAMPLE] Error: Check java.library.path.");
    }
  }
}
