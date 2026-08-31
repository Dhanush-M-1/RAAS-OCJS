n,m=map(int,input().split())
x=[list(map(int,input().split())) for i in range(n+m)]
for a,b in x[:n]:
    l=[abs(a-c)+abs(b-d) for c,d in x[n:]]
    print(l.index(min(l))+1)