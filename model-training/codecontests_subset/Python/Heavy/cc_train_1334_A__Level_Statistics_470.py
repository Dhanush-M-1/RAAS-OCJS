t = int(input())
decir = []
for i in range(0, t):
    c = int(input())
    played = []
    cleared = []
    for j in range(0, c):
        d = input()
        played.append(int(d.split(" ")[0]))
        cleared.append(int(d.split(" ")[1]))
    estado = "idle"
    if c == 1:
        if cleared > played:
            estado = "NO"
        else:
            estado = "YES"
    if c > 1:
        for z in range(0, c-1):
            if estado != "NO":
                if cleared[z+1] - cleared[z] < 0:
                    estado = "NO"
                elif played[z] - cleared[z] < 0:
                    estado = "NO"
                elif (played[z+1] - played[z]) < 0:
                    estado = "NO"
                elif (played[z+1] - played[z]) - (cleared[z+1] - cleared[z]) < 0:
                    estado = "NO"
                else:
                    estado = "YES"
    print(estado)