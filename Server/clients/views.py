from django.http import HttpResponse 
import datetime

def index(request):
    now = datetime.datetime.now()
    html = "<html><body>Ahora es %s </body></html>" % now
    #t = loader.get_template('clients/index.html')
    #c = Context()
    return HttpResponse(html)
