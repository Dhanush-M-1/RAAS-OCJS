import sys
sys.setrecursionlimit(1000000)

def xgcd(a, b):
    """return (g, x, y) such that a*x + b*y = g = gcd(a, b)"""
    if b == 0:
        return (a, 1, 0)
    else:
        g, x, y = xgcd(b, a%b)
        return (g, y, x- (a // b) * y)

n,p,w,d=map(int,input().split());
g,x,y=xgcd(w,d);

if p%g:
  print(-1);
  sys.exit(0);

if g<0:
  g*=-1;
x*=p//g;
y*=p//g;

t=0;
if x<0:
  t=(0-x)*g//d+(0 if (0-x)*g%d == 0 else 1);
  x+=t*d//g;
  y-=t*w//g;

if y<0:
  t=(0-y)*g//w+(0 if (0-y)*g%w==0 else 1);
  x-=t*d//g;
  y+=t*w//g;

if n-(x+y)<0:
  t=(n-(x+y))*g//(d-w) + (0 if (n-(x+y))*g%(d-w)==0 else 1);
  x+=t*d//g;
  y-=t*w//g;

if x<0 or y<0 or n-x-y<0:
  print(-1)
else:
  print(x,y,n-x-y)