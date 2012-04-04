from django.contrib.gis import admin
from . import models

class TrackAdmin(admin.GeoModelAdmin):
    search_fields = ['name']
    list_display = ['name']
admin.site.register(models.Track,TrackAdmin)
