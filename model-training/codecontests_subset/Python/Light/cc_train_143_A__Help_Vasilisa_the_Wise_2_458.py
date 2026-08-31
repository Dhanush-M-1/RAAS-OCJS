r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
for i in range(1,10):
    for j in range(1,10):
        for k in range(1,10):
            for l in range(1,10):
                if i!=j and i!=k and i!=l and j!=k and j!=l and k!=l:
                    if r1==i+j and r2==k+l and c1==i+k and c2==j+l and d1==i+l and d2==j+k:
                        print(i,j)
                        print(k,l)
                        exit()
print(-1)