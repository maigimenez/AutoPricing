from django.template import Context, loader
from django.http import HttpResponse
from testing.models import Track,Mobile,Test
from django.conf.urls.defaults import *
from django.shortcuts import render_to_response
from django.core import serializers


def index(request):
    tracks = Track.objects.all()
    t = loader.get_template('index.html')
    c = Context({'tracks': tracks})
    return HttpResponse(t.render(c))

def tStats(request, track_id):
    try:
        t = Track.objects.get(pk=track_id)
    except Track.DoesNotExist:
        raise Http404
    return render_to_response('tStats.html', {'track': t})
    
def jtracks(request, **kwargs):
    items = Track.objects.all()
    items = serializers.serialize('json', items, indent=4)
    return HttpResponse(items, mimetype='application/json')

def jtests(request, **kwargs):
    items = Test.objects.all()
    items = serializers.serialize('json', items, indent=4)
    return HttpResponse(items, mimetype='application/json')

def jmobiles(request, **kwargs):
    items = Mobile.objects.all()
    items = serializers.serialize('json', items, indent=4)
    return HttpResponse(items, mimetype='application/json')
