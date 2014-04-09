#!/bin/sh
export JAVA_LIBRARY_PATH=/usr/lib/jni:/opt/gdal-georchestra/lib:/opt/gdal-georchestra/java
export JAVA_CLASSPATH=./gdalogr-geotools-sample-1.0-SNAPSHOT-jar-with-dependencies.jar:/usr/share/java:/opt/gdal-georchestra/java/gdal.jar
#export LD_LIBRARY_PATH=${JAVA_LIBRARY_PATH}

if [ -d target ] ; then
  cd target/ ;
  java -cp ${JAVA_CLASSPATH} -Djava.library.path=${JAVA_LIBRARY_PATH} com.camptocamp.gdalogr.App ;
  cd ../ ;
else
  java -cp ${JAVA_CLASSPATH} -Djava.library.path=${JAVA_LIBRARY_PATH} com.camptocamp.gdalogr.App ;
fi
