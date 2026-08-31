
for tt in range(int(input())):
    n = int(input())
    g = [input() for i in range(n)]
    for i in range(2):
        m = []
        if g[0][1] != str(i) : m.append((0,1))
        if g[1][0] != str(i) : m.append((1,0))
        if g[n-1][-2] != str(i^1) : m.append((n-1,n-2))
        if g[-2][n-1] != str(i^1) : m.append((n-2,n-1))
        if len(m) <= 2:
            print(len(m))
            for j in m:
                print(j[0]+1,j[1]+1)
            break