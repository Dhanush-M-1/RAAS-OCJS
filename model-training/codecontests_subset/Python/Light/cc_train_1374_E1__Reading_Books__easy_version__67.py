n,k = map(int,input().split())
a=[]
b=[]
c=[]
d=[]
for i in range(n):
    x,y,z = map(int,input().split())
    if y==0 and z==0:
        d.append(x)
    elif y==1 and z==1:
        a.append(x)
    elif y==0 and z==1:
        c.append(x)
    else:
        b.append(x)
b.sort()
c.sort()
m=min(len(b),len(c))
for i in range(m):
    a.append(b[i]+c[i])
a.sort()
if len(a)<k:
    print("-1")
else:
    print(sum(a[:k]))