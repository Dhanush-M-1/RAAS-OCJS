n,k=map(int,input().split())
x=[];y=[];z=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a and b:x.append(t)
    elif a==1:y.append(t)
    elif b==1:z.append(t)
y.sort();z.sort()
for p,q in zip(y,z):
    x.append(p+q)
x.sort()
if len(x)<k:print(-1)
else:print(sum(x[:k]))