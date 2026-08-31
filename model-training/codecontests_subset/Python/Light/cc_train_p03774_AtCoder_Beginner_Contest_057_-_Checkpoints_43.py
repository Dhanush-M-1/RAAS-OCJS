n,m=map(int,input().split())
ab=[list(map(int,input().split())) for _ in range(n)]
cd=[list(map(int,input().split())) for i in range(m)]
for a,b in ab:
    ma=10**10
    tp=0
    for i in range(m):
        if ma>abs(a-cd[i][0])+abs(b-cd[i][1]):
            ma=abs(a-cd[i][0])+abs(b-cd[i][1])
            tp=i+1
    print(tp)