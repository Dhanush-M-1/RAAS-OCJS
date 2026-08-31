N,M = map(int,input().split(" "))
ab = [0]*N
cd = [0]*M
for i in range(N):
    ab[i] = list(map(int,input().split(" ")))

for i in range(M):
    cd[i] = list(map(int,input().split(" ")))+[i+1]

for a,b in ab:
    m = min(cd,key=lambda x:10000*(abs(a-x[0])+abs(b-x[1]))+x[2])
    print(m[2])