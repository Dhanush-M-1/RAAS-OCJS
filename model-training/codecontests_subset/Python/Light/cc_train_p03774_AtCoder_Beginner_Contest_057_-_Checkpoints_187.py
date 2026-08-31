n,m=map(int,input().split())
ab=[list(map(int,input().split())) for i in range(n)]
cd=[list(map(int,input().split())) for j in range(m)]
for a,b in ab:
    abcd=[abs(a-c)+abs(b-d) for c,d in cd]
    print(abcd.index(min(abcd))+1)