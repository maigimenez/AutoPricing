from clients.models import Client,Vehicle
from django.contrib import admin

class VehicleAdmin(admin.ModelAdmin):
    # Sort fields
    # fields = ['plate', 'owner','brand','model','color']
    
    # Split fields in the form
    fieldsets = [
        (None,{'fields':['plate','owner']}),
        ('Car details', {'fields':['brand','model','color'], 'classes':['collapse']}),
        ]


#class VehicleInline(admin.StackedInline):
class VehicleInline(admin.TabularInline):
    model = Vehicle
    extra = 1


class ClientAdmin(admin.ModelAdmin):
    fieldsets = [
        ('Personal information', {'fields':['dni','name','fSurname','lSurname']}),
        ('Contact information', {'fields':['mail','tel','address','city',],'classes':['collapse']}),
        ]
    inlines = [VehicleInline]
    #list_filter = ['dni']

admin.site.register(Client, ClientAdmin)
admin.site.register(Vehicle,VehicleAdmin)
