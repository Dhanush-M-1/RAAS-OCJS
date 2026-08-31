n,m = map(int,input().split())
ab = [list(map(int,input().split())) for x in [0]*n]
cd = [list(map(int,input().split())) for x in [0]*m]
for a,b in ab:
    l = [abs(a-c)+abs(b-d) for c,d in cd]
    print(l.index(min(l))+1)