from django.contrib.gis import admin
from . import models

#class TrackAdmin(admin.GeoModelAdmin):
class TrackAdmin(admin.OSMGeoAdmin):
    #No funcion con GeoModelAdmin.
    #default_lon= 40.0
    search_fields = ['name']
    list_display = ['name']
admin.site.register(models.Track,TrackAdmin)
