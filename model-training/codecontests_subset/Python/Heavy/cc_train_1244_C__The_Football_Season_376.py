
ss=input().split()
n=int(ss[0])
p=int(ss[1])
w=int(ss[2])
d=int(ss[3])

x=0
y=0
def exgcd(a,b):
    global x
    global y
    if b==0:
        x=1
        y=0
        return a
    res=exgcd(b, a%b)
    t=y
    y=x-(a//b)*y
    x=t
    return res

g=exgcd(w, d)

def upp(x,y):
    flag=1
    if x<0:
        flag=-1
        x=-x
    if y<0:
        flag=-flag
        y=-y
    if flag<0:
        return x//y*flag
    return (x//y+(1 if x%y!=0 else 0))

def dwn(x,y):
    flag=1
    if x<0:
        flag=-1
        x=-x
    if y<0:
        flag=-flag
        y=-y
    if flag<0:
        return (x//y+(1 if x%y!=0 else 0))*flag
    else :
        return x//y
if p%g!=0:
    print("-1")
else :
    ll=upp(-x*p, d)
    rr=dwn(y*p, w)
    tt=upp(g*n-p*x-p*y, d-w)
    if ll<tt:
        ll=tt
    if ll<=rr:
        rx=p//g*x+ll*d//g
        ry=p//g*y-ll*w//g
        rz=n-rx-ry
        print(str(rx)+" "+str(ry)+" "+str(rz))
    else:
        print("-1")        