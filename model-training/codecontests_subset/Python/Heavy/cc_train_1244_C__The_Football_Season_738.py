
def exgcd(a,b,x,y):
    if b==0:
        x[0]=1
        y[0]=0
        return a
    r=exgcd(b,a%b,y,x)
    y[0]-=(a//b)*x[0]
    return r;

def min_ans(a,b,x,y,n):
    g=exgcd(a,b,x,y)
    if n%g:
        return 0
    x[0]*=n//g
    y[0]*=n//g
    db=b//g
    x[0]=((x[0]%db)+db)%db
    y[0]=(n-a*x[0])//b;
    return g
s=input().split()
n=int(s[0])
p=int(s[1])
w=int(s[2])
d=int(s[3])
x=[0]
y=[0]
g=min_ans(w,d,x,y,p)
x=x[0]
y=y[0]
if g==0:
    print("-1")
else:
    if y<0:
        print("-1")
    elif x+y>n:
        da=w//g
        db=d//g
        if db>=da:
            print("-1")
        else:
            tmp=x+y-n
            tmp=(tmp+da-db-1)//(da-db)
            x+=tmp*db
            y-=tmp*da
            if 0<=x and x<=n and 0<=y and y<=n and 0<=x+y and x+y<=n:
                print("%d %d %d"%(x,y,n-x-y))
            else:
                print("-1")
    else:
        print("%d %d %d"%(x,y,n-x-y))