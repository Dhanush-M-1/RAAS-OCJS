r=list(map(int,input().split()));c=list(map(int,input().split()));d=list(map(int,input().split()));ok=0
for i in range(1,10):
    for j in range(1,10):
        for k in range(1,10):
            for e in range(1,10):
                if(i!=j and i!=k and i!=e and j!=k and j!=e and k!=e and ok==0 and i+j==r[0] and k+e==r[1] and i+k==c[0] and j+e==c[1] and i+e==d[0] and j+k==d[1]):
                    print(i,j);print(k,e);ok=1
if(ok==0):print(-1)
