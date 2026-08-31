from typing import List
def guest():
    lenRoom = int(input())
    invitados = [1]*lenRoom
    numeroCuarto = [0]*lenRoom
    respuesta=1
    valoresNumeroCuarto = input()
    numeroCuarto = list(map(int,valoresNumeroCuarto.split()))
    if( lenRoom == 1 ):
        print("YES")
    else:
        for i in range(lenRoom):
            invitados[i]=invitados[i]-1
            invitados[(i+numeroCuarto[i])%(lenRoom)-1] = invitados[(i+numeroCuarto[i])%(lenRoom)-1] + 1
        for i in range(lenRoom):
            if(invitados[i]==0):
                respuesta = 0
        if(respuesta == 1):
            print("YES")
        else:
            print("NO")
t = int(input())
for i in range(t):
    guest()