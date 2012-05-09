from django.conf.urls.defaults import *
#from piston.resource import Resource
#from api.handlers import CalcHandler

#class CsrfExemptResource( Resource ):
#    def __init__( self, handler, authentication = None ):
#        super( CsrfExemptResource, self ).__init__( handler, authentication )
#        self.csrf_exempt = getattr( self.handler, 'csrf_exempt', True )

#calc_resource = CsrfExemptResource( CalcHandler )

urlpatterns = patterns( '',
    url( r'^calc/(?P<expression>.*)$', 'demo')
)

