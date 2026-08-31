n,k=map(int,input().split())
l=list(map(int,input().split()))
l.sort()
ld=[]
lj=[]
le=[]
for i in range(2*10**5+1):
    h=[0,0]
    le.append(h)
for i in range(n):
    g=[]
    j=0
    while(l[i]):
        g.append(l[i])
        l[i]=l[i]//2
        j+=1
    ld.append(g)
    lj.append(j)
j=0
mi=10**18
for i in range(n):
    for j in range(lj[i]):
        if le[ld[i][j]][0]<k:
            le[ld[i][j]][0]+=1
            le[ld[i][j]][1]+=j
        if le[ld[i][j]][0]==k:
            if le[ld[i][j]][1]<mi:
                mi=le[ld[i][j]][1]
print(mi)