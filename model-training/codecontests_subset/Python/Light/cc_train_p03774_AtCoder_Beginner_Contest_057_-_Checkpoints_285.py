N,M = map(int,input().split())
ab = [tuple(map(int,input().split())) for _ in range(N)]
cd = [tuple(map(int,input().split())) for _ in range(M)]

for a,b in ab:
    tmp = []
    for c,d in cd:
        tmp.append(abs(a-c)+abs(b-d))
    
    print(tmp.index(min(tmp))+1)