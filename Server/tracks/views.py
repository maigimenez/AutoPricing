from django.template import Context, loader
from django.http import HttpResponse
from tracks.models import Track

def index(request):
    tracks = Track.objects.all()
    t = loader.get_template('index.html')
    c = Context({'tracks': tracks})
    return HttpResponse(t.render(c))
