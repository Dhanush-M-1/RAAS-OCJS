def main():
    import sys
    input = sys.stdin.readline

    n,k,q = map(int,input().split())
    a = list(map(int,input().split()))

    res = 10**9
    for e in a:
        tank = []
        new = []
        for je in a:
            if e <= je:
                tank.append(je)
            else:
                if len(tank) >= k:
                    tank.sort()
                    for i in range(len(tank)-k+1):
                        new.append(tank[i])
                tank = []
        if len(tank) >= k:
            tank.sort()
            for i in range(len(tank)-k+1):
                new.append(tank[i])
        new.sort()
        if len(new) > q-1:
            res = min(res,new[q-1]-e)
    print(res)

if __name__ =='__main__':
    main()