#Codeforce 615A
n,k = (int(v) for v in input().split())
s=set()
for i in range(n):
    x=[int(u) for u in input().split()]
    x.remove(x[0])
    x=set(x)
    s=s.union(x)
if len(s) == k:
    print("YES")
else:
    print("NO")