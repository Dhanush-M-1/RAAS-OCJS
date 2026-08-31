n,m=map(int,input().split())
ab = [list(map(int,input().split())) for i in range(n)]
cd = [list(map(int,input().split())) for j in range(m)]

for x in range(n):
    e = []
    for y in range(m):
        e.append(abs(ab[x][0]-cd[y][0]) + abs(ab[x][1]-cd[y][1]))

    print(e.index(min(e))+1)