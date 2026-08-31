from math import ceil,sqrt,gcd
def ii(): return int(input())
def si(): return input()
def mi(): return map(int,input().strip().split(" "))
def li(): return list(mi())
t=ii()
while(t):
    t-=1
    n=ii()
    a=li()
    x=1e9
    y=0
    f=0
    for i in range(n):
        if(a[i]==-1):
            if(i>0):
                if(a[i-1]!=-1):
                    f=1
                    x=min(x,a[i-1])
                    y=max(y,a[i-1])
            if(i<n-1):
                if(a[i+1]!=-1):
                    f=1
                    x=min(x,a[i+1])
                    y=max(y,a[i+1])
    if(f==0):
        print(0,1)
    else:
        s=x+(y-x)//2
        for i in range(n):
            if(a[i]==-1):
                a[i]=s
        x=0
        for i in range(1,n):
            x=max(x,abs(a[i]-a[i-1]))
            
        print(x,s)