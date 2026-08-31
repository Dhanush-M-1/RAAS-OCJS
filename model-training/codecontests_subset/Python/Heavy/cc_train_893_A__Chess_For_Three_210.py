num_juegos=int(input(""))
espectador=3;
encuentro=[1,2]
contador=0
aux=0;
for i in range(num_juegos):
    ganador=int(input(""))
    if(encuentro.count(ganador)>0):
        contador=1
        if(encuentro[0]==ganador):
            aux=espectador
            espectador=encuentro[1]
            encuentro[1]=aux
        else:
            aux=espectador
            espectador=encuentro[0]
            encuentro[0]=aux
    else:
        contador=-1
        break

if(contador==1):
    print("Yes")
else:
    print("NO")












