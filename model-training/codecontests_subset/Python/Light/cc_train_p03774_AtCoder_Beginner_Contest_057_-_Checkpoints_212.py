n,m = map(int,input().split())
a = [list(map(int,input().split()))for x in range(n)]
b = [list(map(int,input().split()))for x in range(m)]
for x in range(n):
    c = list()
    for y in range(m):
        c.append(abs(a[x][0]-b[y][0]) + abs(a[x][1]-b[y][1]))
    print(c.index(min(c))+1)