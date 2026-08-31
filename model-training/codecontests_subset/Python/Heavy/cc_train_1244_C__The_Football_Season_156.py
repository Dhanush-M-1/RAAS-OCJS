import math
def gcd(a,b):
    if a==0:
        x0=0
        y0=1
        return b,x0,y0
    d=gcd(b%a,a)
    x0=d[2]-(b//a)*d[1]
    y0=d[1]
    return d[0],x0,y0

s=list(map(int,input().split()));
n=s[0]
p=s[1]
w=s[2]
d=s[3]
dd=gcd(w,d)
x0=dd[1]
y0=dd[2]
dd=dd[0]
x0*=p//dd
y0*=p//dd
dy=w//dd
dx=d//dd
if p%dd !=0:
    print(-1,flush=False)
    exit()
else:
    if y0<0:
        col=math.ceil(abs(y0)/dy)
        y0+=dy*col
        x0-=dx*col
    col=y0//dy
    y0-=dy*col
    x0+=dx*col
    if x0<0:
        print(-1,flush=False)
        exit()
    if(x0+y0<=n):
        print(x0,y0,n-x0-y0,flush=False)
    else:
        print(-1,flush=False)
