from django.contrib.gis.db import models

class Track(models.Model):
    name = models.CharField(max_length=100)
    price = models.FloatField()

    #Geo Django field to store a polygon
    area = models.PolygonField()
    objects = models.GeoManager()

    def __unicode__(self):
        return u"Track: %s" % self.name


class Mobile(models.Model):
    name = models.CharField(max_length=50)
    mac = models.CharField(max_length=17)

    def __unicode__(self):
        return u"%s (%s)" % (self.name,self.mac)

class Client(models.Model):
    name = models.CharField(max_length=20)
    company = models.CharField(max_length=20)
    
    def __unicode__(self):
        return u"%s (%s)" % (self.name, self.company)

class Vehicle(models.Model):
    name = models.CharField(max_length=50)
    color = models.CharField(max_length=50)
    frame = models.CharField(max_length=20)
    client = models.ForeignKey(Client)

    def __unicode__(self):
        return u"%s (Frame: %s - Client: %s)" % (self.name, self.frame, self.client)

class Invoice(models.Model):
    invoiceID =  models.AutoField(primary_key=True)
    date = models.DateField()
    client = models.ForeignKey(Client)
    total = models.FloatField()

    def __unicode__(self):
        return u"%s" % self.invoiceID

class Test(models.Model):
    mobile = models.ForeignKey(Mobile)
    car = models.ForeignKey(Vehicle)
    track = models.ForeignKey(Track)
    minutes = models.IntegerField()
    price = models.FloatField()
    invoice = models.ForeignKey(Invoice)

    def __unicode__(self):
        return u"Test: %s - %s (Invoice %s)" % (self.car, self.track, self.invoice)
