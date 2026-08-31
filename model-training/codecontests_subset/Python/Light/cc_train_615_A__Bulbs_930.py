n,m=[int(x) for x in input().split()]
a=[1]*m
for i in range(n):
    b=[int(x) for x in input().split()]
    for j in range(b[0]):
        a[b[j+1]-1]=0
print(['YES','NO'][sum(a)!=0])