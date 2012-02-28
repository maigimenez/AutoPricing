from django.contrib.gis import admin
from maps.models import Track

class TrackAdmin(admin.OSMGeoAdmin):
    fields = ['name','rate','geom']
    map_width=1200
    default_lon = 0
    default_lat = 39
    default_zooom = 6

admin.site.register(Track,TrackAdmin)
