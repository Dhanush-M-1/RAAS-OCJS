import math
n,p,w,d=map(int,input().split())
c=0
r=p//w
var=n*w-p
vary=w-d
for i in range(10**5+1):
    z=i
    if (p+d*i-d*n)%(w-d)==0:
        x=(p+d*i-d*n)//(w-d)
        y=n-(x+z)
       
        if y<=n and z<=n and y>=0 and z>=0 and x>=0 and x<=n :
            c=1
            break   
if c==0:
    for i in range(10**5+1):
        x=i
        if (p-i*w)%d==0:
            y=(p-i*w)//d
            z=n-(x+y)
            if y<=n and z<=n and y>=0 and z>=0 and x>=0 and x<=n:
                c=1
                break
if c==0:            
    for i in range(10**5+1):
        y=i
        if (p-i*d)%w==0:
            x=(p-i*d)//w
            z=n-(x+y)
            if y<=n and z<=n and y>=0 and z>=0 and x>=0 and x<=n:
                c=1
                break

if c==1:
    print(int(x),int(y),int(z))
else:
    print(-1)