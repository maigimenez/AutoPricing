from django.http import HttpResponse

def hello(request):
    retrun HttpResponse("Hello world")
