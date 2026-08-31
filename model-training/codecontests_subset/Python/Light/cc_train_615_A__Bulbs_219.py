k, l=[int(j) for j in input().split()]
b=[]
for i in range(l):
    b.append(0)
for i in range(k):
    a=[int(j) for j in input().split()]
    for j in range(1, a[0]+1):
        b[a[j]-1]=1
x=0
for i in b:
    if i==1:
        x+=1
if x==l:
    print('YES')
else:
    print('NO')