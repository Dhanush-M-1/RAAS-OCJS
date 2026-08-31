rows = list(map(int,input().split()))
cols = list(map(int,input().split()))
diags = list(map(int,input().split()))


r1 = rows[0]
r2 = rows[1]
c1 = cols[0]
c2 = cols[1]
d1 = diags[0]
d2 = diags[1]

boo = True
n = 9

for i in range(1,n+1):
    for j in range(1,n+1):
        for k in range(1,n+1):
            for l in range(1,n+1):
                if (i!=j and i!=k and i!=l and j!=k and j!=l and k!=l) and i+j==r1 and k+l==r2 and i+k==c1 and j+l==c2 and i+l==d1 and k+j==d2:
                    boo = False
                    print(i,end=" ")
                    print(j)
                    print(k,end=" ")
                    print(l)



if boo:
    print(-1)
