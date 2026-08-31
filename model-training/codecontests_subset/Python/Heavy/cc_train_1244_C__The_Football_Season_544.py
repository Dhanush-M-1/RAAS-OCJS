import math
 
def func(a,b):
    if(b==0):
        return (1,0)
    (x,y)=func(b,a%b)
    return (y,x-a//b*y)
 
 
N,P,W,D=input().split()
n=int(N)
p=int(P)
w=int(W)
d=int(D)
 
g=math.gcd(w,d)
w=w//g
d=d//g

flag=0
if(p%g!=0):
    flag=1
p=p//g
 
(x,y)=func(w,d)
x=x*p
y=y*p

if(x<0):
    t=(-x+d-1)//d
    x+=t*d
    y-=t*w
if(y<0):
    t=(-y+w-1)//w
    x-=t*d
    y+=t*w
 
t=y//w
x+=t*d
y-=t*w
 
if(flag==1 or x<0 or y<0 or x+y>n or x*w+y*d!=p):
    print(-1)
else:
    print("%d %d %d"%(x,y,n-x-y))