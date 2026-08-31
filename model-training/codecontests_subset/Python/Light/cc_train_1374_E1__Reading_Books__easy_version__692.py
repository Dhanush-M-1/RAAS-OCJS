import os,io
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
n,k = list(map(int,input().split()))
z,x,y = [],[],[]
for i in range(n):
    t,a,b = list(map(int,input().split()))
    if a&b: z.append(t)
    elif a: x.append(t)
    elif b: y.append(t)
x = sorted(x)
y = sorted(y)
n = min(len(x),len(y))
for i in range(n):
    z.append(x[i]+y[i])
if len(z)>=k:
    z = sorted(z)[:k]
    print(sum(z))
else:
    print(-1)