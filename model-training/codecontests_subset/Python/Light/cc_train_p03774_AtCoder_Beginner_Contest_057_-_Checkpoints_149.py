n,m=map(int,input().split())
a=[list(map(int,input().split())) for _ in range(n)]
c=[list(map(int,input().split())) for _ in range(m)]
INF=10**9+7
for i in a:
    ans=INF
    for j in range(m):
        tmp=abs(i[0]-c[j][0])+abs(i[1]-c[j][1])
        if tmp<ans:
            ans=tmp
            num=j+1
    print(num)