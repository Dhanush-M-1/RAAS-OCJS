n,m=[int(x) for x in input().split()]
l=[1 for x in range(m)]
for i in range(n):
    s=[int(x) for x in input().split()]
    s=s[1:]
    for j in s:
        l[j-1]=0
if sum(l)==0:
    print('YES')
else:
    print('NO')
