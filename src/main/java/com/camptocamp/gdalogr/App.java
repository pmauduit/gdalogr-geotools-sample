package com.camptocamp.gdalogr;

import java.util.Iterator;

import org.geotools.data.DataStoreFactorySpi;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.ogr.OGRDataStoreFactory;
import org.geotools.data.ogr.jni.JniOGR;
import org.geotools.data.ogr.jni.JniOGRDataStoreFactory;

public class App {
	public static void main(String[] args) {
		// Dumping available datastores
		boolean containsOGR = false;
		System.out.println("[GDAL/OGR-SAMPLE] Available datastores:");
		Iterator<DataStoreFactorySpi> dtf = DataStoreFinder.getAllDataStores();
		while (dtf.hasNext()) {
			DataStoreFactorySpi dsfspi = dtf.next();
			System.out.println("\t" + dsfspi.getDisplayName());
			if ("OGR".equalsIgnoreCase(dsfspi.getDisplayName()))
				containsOGR = true;
		}
		if (!containsOGR) {
			System.out
					.println("[GDAL/OGR-SAMPLE] OGR Datastore could not be found.");
			System.out
					.println("[GDAL/OGR-SAMPLE] Trying to get an OGR Datastore via JNI anyway ...");
		}
		OGRDataStoreFactory f = new JniOGRDataStoreFactory();
		if (f.isAvailable()) {
			System.out
					.println("[GDAL/OGR-SAMPLE] OGR Datastore available. Available drivers:");
			for (String s : f.getAvailableDrivers()) {
				System.out.println("\tdriver: " + s);
			}
		} else {
			System.out.println("[GDAL/OGR-SAMPLE] OGR Datastore unavailable.");
		}
		JniOGR jo = new JniOGR();
		System.out.print("[GDAL/OGR-SAMPLE] Count " + jo.GetDriverCount()
				+ " drivers.\n");
	}
}
