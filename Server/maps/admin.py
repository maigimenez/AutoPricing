from django.contrib.gis import admin
from models import Track

admin.site.register(Track, admin.GeoModelAdmin)
