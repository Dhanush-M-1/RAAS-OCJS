t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    tank = []
    for i in range(1,n-1):
        if a[i] == -1:
            if a[i-1] != -1:
                tank.append(a[i-1])
            if a[i+1] != -1:
                tank.append(a[i+1])
    if a[0] == -1 and a[1] != -1:
        tank.append(a[1])
    if a[n-1] == -1 and a[n-2] != -1:
        tank.append(a[n-2])
    tank.sort()

    
    if len(tank) == 1:
        k = tank[0]
    elif len(tank) == 0:
        k = 0
    else:
        k = (tank[-1]+tank[0])//2
    ma = 0
    for i in range(n):
        if a[i] == -1:
            a[i] = k
        if i == 0:
            continue
        ma = max(ma,abs(a[i]-a[i-1]))
    print(ma,k)
