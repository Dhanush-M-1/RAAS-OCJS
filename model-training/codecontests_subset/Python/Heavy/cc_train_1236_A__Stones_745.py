t=int(input())
salida=[0]*t
for i in range(0,t):
    cad=input()
    cad=cad.split(' ')
    a=int(cad[0])
    b=int(cad[1])
    c=int(cad[2])
    x=0
    while((a>=1 and b>=2) or (b>=1 and c>=2)):
        if(b>c):
            if(a>=1 and b>=2):
                x=x+3
                a=a-1
                b=b-2
            
            else:
                x=x+3
                b=b-1
                c=c-2
        else:
            if(b>=1 and c>=2):
                x=x+3
                b=b-1
                c=c-2
            else:
                x=x+3
                a=a-1
                b=b-2
    salida[i]=x
    
for i in range (0,t):
    print(salida[i])