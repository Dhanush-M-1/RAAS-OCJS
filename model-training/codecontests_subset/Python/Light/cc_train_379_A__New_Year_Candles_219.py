Datos=input()
Datos=Datos.split()
a=int(Datos[0])
b=int(Datos[1])
hora=0
cont=0
while a>=b:
    if a%b==0:
        hora+=a
        a=a//b
    else:
        cont+=a%b
        hora+=a
        a=a//b
        if cont>=b:
            a+=1
            cont=cont%b
hora+=a
if a+cont>=b:
    hora+=1
print(hora)
        
