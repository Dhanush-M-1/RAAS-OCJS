n,m=map(int,input().split())
a=[list(map(int,input().split())) for i in range(n)]
b=[list(map(int,input().split())) for i in range(m)]


for i in range(n):
    x=[0]*m
    for j in range(m):
        x[j]=abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1])
    print(x.index(min(x))+1)