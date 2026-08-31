n,m=map(int,input().split())
b=list(range(1,m+1))
for i in range(n):
    a=[int(n) for n in input().split()]
    for j in range(1,len(a)):
        p=a[j]
        if a[j] in b:
            b.remove(a[j])
if b==[]:
    print('YES')
else:
    print('NO')
