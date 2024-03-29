from django.conf.urls.defaults import patterns, include, url
from django.conf import settings

# Uncomment the next two lines to enable the admin:
from django.contrib import admin
admin.autodiscover()


urlpatterns = patterns('',
                       (r'^media/(?P<path>.*)$', 'django.views.static.serve', {'document_root': settings.MEDIA_ROOT }),
                       #Tracks
                       #(r'^tracks/$', 'tracks.views.index'),    
                       #(r'^tracks/(?P<track_id>\d+)/$', 'tracks.views.tStats'),    
                       #(r'^tracks/$', include('tracks.urls')),    

                       #Testing
                       (r'^tracks/$', 'testing.views.tracks'),    
                       (r'^track/(?P<track_id>\d+)/$', 'testing.views.tStats'),
                       
                       #Api
                       (r'^api/tracks/$', 'testing.views.jtracks'),
                       (r'^api/tests/$', 'testing.views.jtests'),
                       (r'^api/mobiles/$', 'testing.views.jmobiles'),
                       (r'^api/vehicles/$', 'testing.views.jvehicles'),
                       (r'^api/clients/$', 'testing.views.jclients'),
                       (r'^api/invoices/$', 'testing.views.jinvoices'),
                       
                       
                       #Admin
                       url(r'^admin/', include(admin.site.urls)),
)

