from django.db import models

class Client(models.Model):
    dni = models.CharField(max_length=9, primary_key=True)
    name = models.CharField(max_length=20)
    fSurname = models.CharField(max_length=50)
    lSurname = models.CharField(max_length=50)
    address = models.CharField(max_length=100)
    city = models.CharField(max_length=50)
    tel = models.IntegerField(max_length=50)
    mail = models.EmailField(max_length=100)

    def __unicode__(self):
        return self.dni

class Vehicle(models.Model):
    owner = models.ForeignKey(Client)
    plate = models.CharField(max_length=10, primary_key=True)
    brand = models.CharField(max_length=20)
    model = models.CharField(max_length=20)
    color = models.CharField(max_length=10)
    
    def __unicode__(self):
        return self.plate;
