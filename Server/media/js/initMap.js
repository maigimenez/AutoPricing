function init() {
    map = new OpenLayers.Map("basicMap");
    var mapnik = new OpenLayers.Layer.OSM();
    map.addLayer(mapnik);
    map.setCenter(new OpenLayers.LonLat(0.0,52.52) // Center of the map
		  .transform(
		      new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
		      new OpenLayers.Projection("EPSG:900913") // to Spherical Mercator Projection
		  ), 15 // Zoom level
		 );
}