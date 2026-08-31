def  MCD(a,b):
        if a%b==0:
                return b
        else:
                return MCD(b,a%b)
        
x=int(input())
z=1
salida=0
salida2=0

a=x+1
b=a-1
c=b-1
if x>4:
        for k in range (3):
                a=a-1
                b=a

                for l in range (3):
                        b=b-1
                        c=b
                        if b<1:
                                break

                        for m in range (3):
                                c=c-1
                                if c<1:
                                        break
                                if  ((MCD(a,b)==1 and MCD(b,c)==1 and MCD(a,c)==1)  and (a!=1 and b!=1 and c!=1 ) ):
                                        respuesta=a*b*c
                                        salida=1
                                        salida2=1
                                        break
                        if salida==1:
                                break

                if salida2==1:
                        z=2
                        break
else:
        if x==4:
                respuesta=12
        elif x==3:
                respuesta=6
        else:
                respuesta=x
print(respuesta)