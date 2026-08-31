n,m=map(int,input().split())
c=[]
z=[]
for i in range(1,m+1):
    c.append(i)
for i in range(n):
    a=list(map(int,input().split()))
    for j in range(1,len(a)):
        z.append(a[j])
z=list(set(z))
z.sort()
if z==c:
    print("YES")
else:
    print("NO")
