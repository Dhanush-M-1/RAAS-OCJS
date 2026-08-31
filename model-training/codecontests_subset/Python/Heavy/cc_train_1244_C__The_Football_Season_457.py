n,p,w,d=[int(i) for i in input().split(" ")]

def exgcd(a,b):
    if b==0:
        return (1,0)
    tx,ty=exgcd(b,a%b)
    return (ty,tx-a//b*ty)

def gcd(a,b):
    if b==0:
        return a
    return gcd(b,a%b)

x,y=exgcd(w,d)
g=gcd(w,d)
if p%g!=0:
    print("-1")
    exit()
p//=g
x*=p
y*=p
w//=g
d//=g
if x<0:
    tmp=(-x+d-1)//d
    x+=tmp*d
    y-=tmp*w
if y<0:
    tmp=(-y+w-1)//w;
    y+=tmp*w
    x-=tmp*d
if x<0:
    print("-1")
    exit()
if y>=w:
    tmp=y//w
    y-=tmp*w;
    x+=tmp*d;
if x+y>n:
    print("-1")
    exit()
print(int(x),int(y),int(n-x-y))