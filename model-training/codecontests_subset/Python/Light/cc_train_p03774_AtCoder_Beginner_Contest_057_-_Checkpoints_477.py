N,M = map(int,input().split())

St = [list(map(int,input().split()))for _ in range(N)]
Pt = [list(map(int,input().split()))for _ in range(M)]

for a,b in St:
    dis = [abs(a-c)+abs(b-d)for c,d in Pt]
    print(dis.index(min(dis))+1)
