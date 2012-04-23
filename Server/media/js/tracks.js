var map;
var MarkerFile;
var lat = 38.0307;
var lon = -97.5146;
var zoom = 4;

function init() {

    map = new OpenLayers.Map("basicMap", {
        controls: [
            new OpenLayers.Control.Navigation(),
            new OpenLayers.Control.PanZoomBar(),
            new OpenLayers.Control.Attribution()],
                allOverlays: true
            });


    var layerOSM = new OpenLayers.Layer.OSM();
    map.addLayer(layerOSM);
    
    var proj = new OpenLayers.Projection("EPSG:4326");
    

    var style_green =
        {
            strokeColor: "#000000",
            strokeOpacity: 1,
            strokeWidth: 1,
            fillColor: "#00FF00",
            fillOpacity: 0.6
        };


    var Tracks = new OpenLayers.Layer.Vector("Tracks", { isBaseLayer: false });
    
    
    var format = new OpenLayers.Format.WKT({
        'internalProjection': map.baseLayer.projection,
        'externalProjection': proj
    });
       

    var track1 = format.read("POLYGON ((-0.6281409999999999 39.4897739999999970, -0.6272400000000000 39.4899720000000016, -0.6253950000000000 39.4857990000000001, -0.6275830000000000 39.4867599999999968, -0.6286990000000000 39.4878530000000012, -0.6286990000000000 39.4880179999999967, -0.6281409999999999 39.4897739999999970))");
    var track2 = format.read("POLYGON ((-0.6324330000000000 39.4854210000000023, -0.6326690000000000 39.4843770000000021, -0.6315960000000000 39.4843279999999979, -0.6294290000000000 39.4870769999999993, -0.6297720000000000 39.4875070000000008, -0.6301369999999999 39.4875570000000025, -0.6305440000000000 39.4875570000000025, -0.6308450000000000 39.4874579999999966, -0.6313170000000000 39.4871589999999983, -0.6317680000000000 39.4865959999999987, -0.6317460000000000 39.4862979999999979, -0.6320460000000000 39.4857849999999999, -0.6322610000000000 39.4855700000000027, -0.6324330000000000 39.4854210000000023))");

    Tracks.addFeatures([track1, track2]);

    map.addLayers([Tracks]);
    map.addControl(new OpenLayers.Control.LayerSwitcher());


    var lonLat = new OpenLayers.LonLat(lon, lat).transform(proj, map.getProjectionObject());

    var bounds = track1.geometry.getBounds();
    bounds.extend(track2.geometry.getBounds());

    map.zoomToExtent(bounds);
}