test = int(input())
for t in range(test):
    n = int(input())
    lst = list(map(int, input().split()))
    maxm = max(lst)
    minm = lst[0]
    final =list()
    for i in range(n):
        if lst[i] == maxm:
            c = i+1
            break
    Ase = False
    for i in range(1, len(lst)):
        if minm + lst[i] <= maxm:
            b = i + 1
            Ase = True
            break
    if Ase == True:
        print(1,b,c)

    else:
        print(-1)

