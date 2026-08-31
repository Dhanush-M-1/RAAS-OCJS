n,m=map(int,input().split())
ab=[list(map(int,input().split())) for _ in range(n)] #student
cd=[list(map(int,input().split())) for _ in range(m)] #check point
for i in range(n):
    l=[]
    for j in range(m):
        l.append(abs(ab[i][0]-cd[j][0])+abs(ab[i][1]-cd[j][1]))
    k=l.index(min(l))+1
    print(k)