r1,r2=input().split()
c1,c2=input().split()
d1,d2=input().split()

r1=int(r1);r2=int(r2);c1=int(c1);c2=int(c2);d1=int(d1);d2=int(d2)

a=[[0 for i in range(2)]for j in range(2)]

for i in range(1,10):
    for j in range(1,10):
        for k in range(1,10):
            for l in range(1,10):
                if i+j==r1 and l+k==r2 and i+l==c1 and j+k==c2 and i+k==d1 and j+l==d2 and i!=j and i!=k and i!=l and j!=k and j!=l and l!=k:
                    a[0][0]=i
                    a[0][1]=j
                    a[1][0]=l
                    a[1][1]=k
flag=1
for i in range(2):
    for j in range(2):
        if a[i][j]==0:
            flag=flag*1
        else:
            flag=0

if flag==1:
    print('-1')
else:
    print(a[0][0],end=' ')
    print(a[0][1])
    print(a[1][0],end=' ')
    print(a[1][1])
        
