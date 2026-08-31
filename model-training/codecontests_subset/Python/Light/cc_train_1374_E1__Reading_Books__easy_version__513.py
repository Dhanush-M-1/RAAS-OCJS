n,k=map(int,input().split())
l=[]
for i in range(n):
    l.append(list(map(int,input().split())))
x,y,z=[],[],[]
for i in range(n):
    if(l[i][1]==1 and l[i][2]==1):
        x.append(l[i][0])
    elif(l[i][1]==1 and l[i][2]==0):
        y.append(l[i][0])
    elif(l[i][1]==0 and l[i][2]==1):
        z.append(l[i][0])
y.sort()
z.sort()
for i in range(min(len(y),len(z))):
    x.append(y[i]+z[i])
x.sort()
if(len(x)<k):
    print(-1)
else:
    print(sum(x[:k]))
