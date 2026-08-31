N,M=map(int,input().split())
z=[list(map(int,input().split())) for i in range(N)]
c=[list(map(int,input().split())) for i in range(M)]
for i in z:
    d=10**9
    ans=C=0
    for j in c:
        C+=1
        k=abs(i[0]-j[0])+abs(i[1]-j[1])
        if d>k:
            ans=C
            d=k
    print(ans)
