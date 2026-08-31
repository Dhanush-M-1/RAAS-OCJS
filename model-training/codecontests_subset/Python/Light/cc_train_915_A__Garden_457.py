inp=lambda:map(int,input().split())
n,k=inp()

a=list(inp())

m=-1
for i in range(n):
    if k%a[i]==0: m=max(m,a[i])

print(int(k/m))