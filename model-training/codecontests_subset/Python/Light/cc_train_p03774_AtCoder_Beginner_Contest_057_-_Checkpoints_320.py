n,m=map(int,input().split())
ab=[]
cd=[]
for i in range(n):
    ab.append(list(map(int,input().split())))
for j in range(m):
    cd.append(list(map(int,input().split())))

for k in range(n):
    s=[abs(ab[k][0]-cd[l][0])+abs(ab[k][1]-cd[l][1]) for l in range(m)]
    print(s.index(min(s))+1)