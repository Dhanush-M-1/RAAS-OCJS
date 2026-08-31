a,b=map(int,input().split())
s=set()
for i in range(a):
    l=list(map(int,input().split()))
    l.remove(l[0])
    c=set(l)
    s=s.union(c)
if len(s)==b:
    print("YES")
else:
    print("NO")
