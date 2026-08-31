a=[int(i) for i in input().split()]
s=0
g=0
while a[0]!=0:
    a[0]=a[0]-1
    s+=1
    g+=1
    if s==a[1]:
        a[0]+=1
        s=0
print(g)
