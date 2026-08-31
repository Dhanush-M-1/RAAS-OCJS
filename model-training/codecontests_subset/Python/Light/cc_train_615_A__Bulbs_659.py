a=input().split()
n,m=int(a[0]),int(a[1])
b=set()
for i in range(1,m+1):
    b.add(str(i))
p=set()
for i in range(1,n+1):
    a=input().split()
    a.pop(0)
    p=p.union(set(a))
if (p==b): print("YES")
else: print("NO")