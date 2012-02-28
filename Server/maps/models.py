from django.contrib.gis.db import models

class Track(models.Model):
    name = models.CharField(max_length=50)
    area = models.IntegerField()
    rate = models.FloatField()

    #Geo Django field to store a polygon
    geom = models.PolygonField()
    # We use GeoManager to make Geo Queries
    objects = models.GeoManager()

    # Returns the string representation of the model.
    def __unicode__(self):
        return self.name
    
