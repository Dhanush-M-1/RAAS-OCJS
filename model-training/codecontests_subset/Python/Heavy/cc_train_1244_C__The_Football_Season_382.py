def exgcd(a,b,x,y):
    if b==0:
        x[0]=1
        y[0]=0
        return a
    r=exgcd(b,a%b,x,y)
    temp=y[0]
    y[0]=x[0]-(a//b)*y[0]
    x[0]=temp
    return r
def gcd(a,b):
    if b==0:
        return a
    else:
        return gcd(b,a%b)
n,p,w,d=map(int,input().split())
x=[0]
y=[0]
if p%gcd(w,d)!=0:
    print(-1)
    exit()
exgcd(w,d,x,y)
x[0]*=p//gcd(w,d)
y[0]*=p//gcd(w,d)
k1=w*d//gcd(w,d)//w
k2=w*d//gcd(w,d)//d
if x[0]>=0 and y[0]>=0:
    if x[0]+y[0]<=n:
        print(x[0],end=" ")
        print(y[0],end=" ")
        print(n-x[0]-y[0])
    else:
        b = y[0] //k2
        if x[0] + b * k1 + y[0] - b * k2 <= n:
            print(x[0] + b * k1,end=" ")
            print(y[0] - b * k2,end=" ")
            print( n - (x[0] + b * k1 + y[0] - b * k2))
        else:
            print(-1)
elif x[0]>=0 and y[0]<0:
    a = x[0]//k1
    y[0]=-y[0]
    if y[0] % k2 == 0:
        b = y[0] //k2
    else:
        b = y[0] // k2 + 1
    if a < b:
        print(-1)
    else:
         if x[0] - b * k1 + (-y[0]) + b * k2 <= n:
            print(x[0] - b * k1,end=" ")
            print(-y[0] + b * k2,end=" ")
            print(n - (x[0] - b * k1 + (-y[0]) + b * k2))
         else:
            print(-1)
elif x[0]<0 and y[0]>=0:
    x[0] = -x[0]
    b = y[0] // k2
    if x[0] % k1 == 0:
        a = x[0] // k1
    else:
        a = x[0] / k1 + 1
    if a > b:
        print(-1)
    else:
        if -x[0] + b * k1 + y[0] - b * k2 <= n:
            print(-x[0] + b * k1,end=" ")
            print(y[0] - b * k2,end=" ")
            print(n - (-x[0] + b * k1 + y[0] - b * k2))
        else:
            print(-1)
else:
    print(-1)
