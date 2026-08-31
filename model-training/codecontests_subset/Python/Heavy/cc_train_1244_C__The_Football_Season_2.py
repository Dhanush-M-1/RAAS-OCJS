import math
def gcd(a,b):
    if a==0:
        x0,y0=0,1
        return b,x0,y0
    d=gcd(b%a,a)
    x0,y0=(d[2]-(b//a)*d[1]),d[1]
    return d[0],x0,y0
s=tuple(map(int,input().split()));
n,p,w,d=s[0],s[1],s[2],s[3]
dd=gcd(w,d)
dd,x0,y0=dd[0],dd[1],dd[2]
x0*=p//dd;y0*=p//dd
dy,dx=w//dd,d//dd
if p%dd !=0:
    print(-1)
    exit()
else:
    if y0<0:
        col=math.ceil(abs(y0)/dy)
        y0+=dy*col;x0-=dx*col
    col=y0//dy
    y0-=dy*col;x0+=dx*col
    if x0<0:
        print(-1,flush=False)
        exit()
    if(x0+y0<=n):
        print(x0,y0,n-x0-y0)
    else:
        print(-1)
