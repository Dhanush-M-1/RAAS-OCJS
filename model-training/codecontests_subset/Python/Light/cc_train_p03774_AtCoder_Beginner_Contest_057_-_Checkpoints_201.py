n,m=map(int,input().split())
a=[list(map(int,input().split())) for _ in range(n)]
c=[list(map(int,input().split())) for _ in range(m)]

for i in range(n):
    l=[abs(c[j][0]-a[i][0])+abs(c[j][1]-a[i][1]) for j in range(m)]
    print(l.index(min(l))+1)