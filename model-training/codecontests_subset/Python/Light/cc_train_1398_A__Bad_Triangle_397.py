t = int(input())
for i in range(t):
    n = int(input())
    pole = input().split()
    for j in range(n):
        pole[j] = int(pole[j])
    hran = pole[0]+pole[1]
    pravda = False
    for j in range(n):
        if pole[j] >= hran:
            pravda = True
            break
    if pravda == True:
        print(1,2,j+1)
    else:
        print(-1)