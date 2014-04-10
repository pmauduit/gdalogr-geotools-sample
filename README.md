gdalogr-geotools-sample
=======================

gdalogr-geotools-sample is a program to test JVM setups against GDAL/OGR GeoTools bindings.


```
$ mvn clean package
$ mvn exec:java
```

or, by hand:

```
$ java -cp target/gdalogr-geotools-sample-1.0-SNAPSHOT-jar-with-dependencies.jar:other/path/for/classpath \
    -Djava.library.path=... com.camptocamp.gdalogr.App
```
You might need to compile GeoTools from geOrchestra before:

```
git clone https://github.com/georchestra/geotools
cd geotools
mvn clean install
```
