N, X = map(int, input().split())
TotalLength = N

Vert = N-X
Hor = X
Fin = False
while not Fin:
    if Vert < Hor:
        if Hor % Vert == 0:
            TotalLength += (2 * (Hor//Vert) - 1) * Vert
            Fin = True
        else:
            TotalLength += 2 * (Hor//Vert) * Vert
            Hor %= Vert
    else:
        if Vert % Hor == 0:
            TotalLength += (2 * (Vert//Hor) - 1) * Hor
            Fin = True
        else:
            TotalLength += 2 * (Vert//Hor) * Hor
            Vert %= Hor
print(TotalLength)