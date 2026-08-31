n,m = map(int, input().split())
ab = [list(map(int,input().split())) for _ in range(n)]
cd = [list(map(int,input().split())) for _ in range(m)]
res = []
for a,b in ab:
    tmp = []
    for c,d in cd:
        tmp.append(abs(a-c)+abs(b-d))
    res.append(tmp.index(min(tmp))+1)
for r in res:
    print(r)