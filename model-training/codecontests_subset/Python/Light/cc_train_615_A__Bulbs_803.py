n,m=map(int,input().split())
a = []
for i in range(n):
    b = list(map(int,input().split()))
    for j in range(1,len(b)):
        a.append(b[j])
a = list(set(a))
if len(a) == m: print("YES")
else: print("NO")