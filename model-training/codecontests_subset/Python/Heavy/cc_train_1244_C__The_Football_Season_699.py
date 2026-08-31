import sys,math
n,p,w,d=map(int,sys.stdin.readline().split())
x=0
y=0
minx=0
miny=0
maxx=n
maxy=n
left1=-1
right1=-1
gg=-1
def shift_solution(a,b,cnt):
    global x,y
    x+=(cnt*b)
    y-=(cnt*a)
def gcd(a,b):
    global x,y
    if a==0:
        return (b,0,1)
    g,x1,y1=gcd(b%a,a)
    x=y1- (b//a) * x1
    y=x1
    return (g,x,y)
def find_any_solution(a,b,c):
    global x,y,gg
    g,x,y=gcd(a,b)
    gg=g
    if c%g!=0:
        return False
    x*=(c//g)
    y*=(c//g)
    return True
def find_all_solution(a,b,c):
    global x,y,gg,left1,right1
    if find_any_solution(a,b,c)==False:
        return 0
    a//=gg
    b//=gg
    shift_solution(a,b,math.floor((minx-x)/b))
    if (x<minx):
        shift_solution(a,b,1)
    elif x>maxx:
        return 0
    lx1=x
    shift_solution(a,b,math.floor((maxx-x)/b))
    if x>maxx:
        shift_solution(a,b,-1)
    rx1=x
    if y<miny:
        shift_solution(a,b,math.floor((-miny+y)/a))
    if y>maxy:
        return 0
    lx2=x
    shift_solution(a,b,math.floor((-maxy+y)/a))
    if y>maxy:
        shift_solution(a,b,1)
    rx2=x
    if lx2>rx2:
        p1=lx2
        lx2=rx2
        rx2=p1
    lx=max(lx1,lx2)
    rx=min(rx1,rx2)
    left1=lx
    right1=rx
    if lx>rx:
        return 0
    return (rx-lx)//b + 1

k=find_all_solution(w,d,p)
if k==0:
    print("-1")
else :
    x=right1
    y=(p-(w*x))//d
    if x+y<=n:
        print(x , y , n-(x+y))
    else :
        print("-1")
        
