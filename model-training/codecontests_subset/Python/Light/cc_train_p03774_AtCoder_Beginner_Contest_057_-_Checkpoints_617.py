n,m=map(int,input().split())
p=[list(map(int,input().split())) for _ in range(n)]
q=[list(map(int,input().split())) for _ in range(m)]
for a,b in p:
    l=[]
    for c,d in q:
        l.append(abs(a-c)+abs(b-d))
    print(l.index(min(l))+1)