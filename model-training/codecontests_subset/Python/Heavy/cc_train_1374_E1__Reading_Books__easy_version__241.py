n,k=map(int,input().split())
x=[]
y=[]
z=[]
for _ in range(n):
    t,a,b=map(int,input().split())
    if(a==1 and b==1):
        x.append(t)
    elif(a==1 and b==0):
        y.append(t)
    elif(a==0 and  b==1):
        z.append(t)
x.sort()
y.sort()
z.sort()
kk=[]
p=min(len(y),len(z))
for i in range(p):
    kk.append(y[i]+z[i])
if(len(kk)+len(x)<k):
    print(-1)
else:
    i = 0
    j = 0
    c = []
    while (True):
        if (i == len(kk)):
            c.extend(x[j:])
            break
        if (j == len(x)):
            c.extend(kk[i:])
            break
        if (kk[i] > x[j]):
            c.append(x[j])
            j += 1
        elif (kk[i] == x[j]):
            c.append(x[j])
            c.append(x[j])
            i += 1
            j += 1
        else:
            c.append(kk[i])
            i += 1
    print(sum(c[:k]))