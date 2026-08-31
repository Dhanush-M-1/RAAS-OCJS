n,k=map(int,input().split())
z=[]
x=[]
y=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a&b:z.append(t)
    elif a:x.append(t)
    elif b:y.append(t)
x.sort()
y.sort()
for i in range(min(len(x),len(y))):z.append(x[i]+y[i])
print(-1if len(z)<k else sum(sorted(z)[:k]))