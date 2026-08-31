n,k = list(map(int,input().split()))
ca,cb=0,0
x,y,z = [],[],[]
for i in range(n):
    t,a,b, = list(map(int,input().split()))
    ca+=a
    cb+=b
    if(a==1 and b==0):
        x.append(t)
    elif(a==0 and b==1):
        y.append(t)
    elif(a==1 and b==1):
        z.append(t)
x.sort()
y.sort()
z.sort()
if(ca<k or cb<k):
    print("-1")
else:
    total = 0
    arr = []
    for i in range(min(len(z),k)):
        total += z[i]
        arr.append(z[i])
    if(len(z)<k):
        for i in range(len(z),k):
            total+= x[0]+y[0]
            del x[0]
            del y[0]
    while(len(x)>0 and len(y)>0 and len(arr)>0 and x[0]+y[0]<arr[-1]):
        total += (x[0]+y[0]-arr[-1])
        del arr[-1]
        del x[0]
        del y[0]
    print(total)