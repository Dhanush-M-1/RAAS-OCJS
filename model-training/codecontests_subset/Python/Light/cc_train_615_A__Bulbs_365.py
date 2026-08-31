n,m=map(int,input().split())
l=[]
for i in range(n):
    a=[int(x) for x in input().split()]
    a.remove(a[0])
    l+=a
l=list(set(l))
if len(l)==m:
    print("YES")
else:
    print("NO")