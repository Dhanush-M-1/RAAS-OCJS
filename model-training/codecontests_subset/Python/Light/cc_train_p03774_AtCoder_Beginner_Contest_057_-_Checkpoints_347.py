n,m=map(int,input().split())
p=[list(map(int,input().split())) for i in range(n)]
c=[list(map(int,input().split())) for i in range(m)]

for i in p:
    cnt=1
    d=10**9
    for j in c:
        if abs(i[0]-j[0])+abs(i[1]-j[1])<d:
            d=abs(i[0]-j[0])+abs(i[1]-j[1])
            ans=cnt
        cnt+=1
    print(ans)