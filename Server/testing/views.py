from django.template import Context, loader
from django.http import HttpResponse
from testing.models import Track
from django.shortcuts import render_to_response

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
