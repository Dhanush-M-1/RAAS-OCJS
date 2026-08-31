n,k=list(map(int,input().split()))
x=[]
y=[]
z=[]
for i in range(n):
    
    t,a,b=list(map(int,input().split()))
    if a==1 and b==1:
        z.append(t)
    elif a==0 and b==1:
        y.append(t)
    elif a==1 and b==0:
        x.append(t)
x1=len(x)
y1=len(y)
z1=len(z)
if min(x1,y1)+z1<k:
    print(-1)
else:
    x.sort()
    y.sort()
    s=min(x1,y1)
    i=0
    while i<s:
        z.append(x[i]+y[i])
        i+=1
    z.sort()
    print(sum(z[:k]))
    
    
    
        
    
   
