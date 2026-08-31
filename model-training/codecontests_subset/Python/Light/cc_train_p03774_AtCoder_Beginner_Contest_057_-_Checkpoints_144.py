#57b
n,m = map(int,input().split())
a=[list(map(int,input().split())) for _ in range(n)]
b=[list(map(int,input().split())) for _ in range(m)]

for i in range(n):
    ans=[]
    for j in range(m):
        ans.append(abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1]))
    print(ans.index(min(ans))+1)