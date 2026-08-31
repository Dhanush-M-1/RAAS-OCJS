def solve():
    n = int(input())
    pprv = 0
    cprv = 0
    result = True
    for i in range(0,n):
        line = list(map(lambda x: int(x),input().split()))
        pnow =line[0]
        cnow =line[1]
        if result:
            if  pnow>=pprv and cnow>=cprv and (pnow-pprv)>=(cnow-cprv):
                pprv = pnow
                cprv = cnow
            else:
                result = False

    if result:
        print("YES")
    else:
        print("NO")

t = int(input())
for i in range(0,t):
    solve()