from django.contrib.gis.db import models

class Track(models.Model):
    name = models.CharField(max_length=100)

    #Geo Django field to store a polygon
    area = models.PolygonField()
    objects = models.GeoManager()

    def __unicode__(self):
        return u"Track: %s" % self.name


class Mobile(models.Model):
    name = models.CharField(max_length=50)
    mac = models.CharField(max_length=17)

    def __unicode__(self):
        return u"Mobile name: %s" % self.name

class Car(models.Model):
    name = models.CharField(max_length=50)
    color = models.CharField(max_length=50)
    frame = models.IntegerField()

    def __unicode__(self):
        return u"Car name: %s" % self.name

class Test(models.Model):
    mobile = models.ForeignKey(Mobile)
    car = models.ForeignKey(Car)
