from djangorestframework.resources import ModelResource
from testing.models import Track

class TracksResource(ModelResource):
    model = Track
    fields = ('name', 'area')
    ordering = ('name',)
