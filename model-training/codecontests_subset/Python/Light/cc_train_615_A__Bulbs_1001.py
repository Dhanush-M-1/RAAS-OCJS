n,m=map(int,input().split())
s_total=[]
for i in range(n):
    l=[int(x)for x in input().split()]
    del(l[0])
    s_total.extend(l)
s=set(s_total)
x=True
i=1
while i<=m:
    if i not in s:
        x=False
        break
    i+=1
if x:
    print('YES')
else:
    print('NO')