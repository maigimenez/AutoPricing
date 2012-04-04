from django.contrib.gis.db import models

class Track(models.Model):
    name = models.CharField(max_length=100)

    #Geo Django field to store a polygon
    area = models.PolygonField()
    objects = models.GeoManager()

    def __unicode__(self):
        return u"Track: %s" % self.name

