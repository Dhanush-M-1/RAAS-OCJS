from  math import gcd
def ii():return int(input())
def mi():return map(int,input().split())
def li():return list(mi())
def si():return input()
mod=1e9+7
n=ii()
if(n%2):
    x=n
    y=n-2
    if(y<=0):
        y=1
    #print(x,y)
    x=(x*y)//gcd(x,y)
    ans=x
    #print(ans)
    for i in range(n-1,0,-1):
        if(i==n-2):
            continue
        if((x*i)<=ans):
            break
        s=(x*i)//gcd(x,i)
        ans=max(ans,s)
else:
    x=n
    y=n-1
    if(y<=0):
        y=1
    x=(x*y)//gcd(x,y)
    ans1=x
    for i in range(n-1,0,-1):
        if(i==n-1):
            continue
        if((x*i)<=ans1):
            break
        s=(x*i)//gcd(x,i)
        ans1=max(ans1,s)
    x=n-1
    y=n-2
    if(y<=0):
        y=1
    x=(x*y)//gcd(x,y)
    ans2=x
    for i in range(n-1,0,-1):
        if(i==n-2):
            continue
        if((x*i)<=ans1):
            break
        s=(x*i)//gcd(x,i)
        ans2=max(ans2,s)
    ans=max(ans1,ans2)
print(ans)

