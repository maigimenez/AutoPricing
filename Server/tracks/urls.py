from django.conf.urls.defaults import patterns, include, url

#Uncomment the next two lines to enable the admin:
from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('tracks.views',
                       (r'^$', 'index'),    
                       (r'^(?P<track_id>\d+)/$', 'tStats'),
)
