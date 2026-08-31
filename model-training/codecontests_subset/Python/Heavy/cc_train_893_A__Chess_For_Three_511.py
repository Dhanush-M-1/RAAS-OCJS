def validar_partidas(n,ganadores):
    perdedor = 3
    partida = [1,2]
    result = 0
    if ganadores[0]==3:
        result=-1
    else:
        for j in range(len(ganadores)):
            if ganadores[j]==perdedor:
                result=-1
            elif partida.count(ganadores[j])>0:
                if partida[0]==ganadores[j]:
                    espectador = perdedor
                    perdedor=partida[1]
                    partida[1]=espectador
                else:
                    espectador=perdedor
                    perdedor=partida[0]
                    partida[0]=espectador
    if result == -1:
        print("NO")
    else:
        print("YES")

if __name__ == "__main__":
    n = int(input(""))
    ganadores = list()
    for i in range(n):
        ganadores.append(int(input("")))
    validar_partidas(n,ganadores)