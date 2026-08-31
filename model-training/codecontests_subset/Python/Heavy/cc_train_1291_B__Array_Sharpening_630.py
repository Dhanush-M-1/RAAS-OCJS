for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    m = max(a)
    cntL = [0] * n
    cur = 0
    fl = 1
    for i in range(n):
        if a[i] < cur:
            fl = 0
        else:
            cur += 1
        cntL[i] = fl
    cntR = [0] * n
    cur = 0
    fl = 1
    for i in range(n - 1, -1, -1):
        if a[i] < cur:
            fl = 0
        else:
            cur += 1
        cntR[i] = fl
    fl = 0
    for i in range(n):
        if cntL[i] == cntR[i] == 1:
            fl = 1
    if fl:
        print("Yes")
    else:
        print("No")
