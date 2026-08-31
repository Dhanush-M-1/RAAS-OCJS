def exgcd(a,b):
    if b==0:
        return [1,0,a]
    res=exgcd(b,a%b)
    t=res[0]
    res[0]=res[1]
    res[1]=t
    res[1]-=a//b*res[0]
    return res
inp=input().split()
n=eval(inp[0])
p=eval(inp[1])
d=eval(inp[2])
w=eval(inp[3])
gg=exgcd(d,w)
g=gg[2]
x=gg[0]
y=gg[1]
de=1
if p%g!=0:
    print(-1)
else :
    dx=w//g
    dy=d//g
    x*=p//g
    y*=p//g
    de=-10
    x+=de*dx
    y-=de*dy
    if x>0:
        de=-(x//dx)
    else :
        de=y//dy
    x+=de*dx
    y-=de*dy
    if x<0 or y<0:
        print(-1)
    else :
        if dx>dy:
            de=-(x//dx)
        else :
            de=y//dy
        x+=de*dx
        y-=de*dy
        if x+y<=n:
            print(x,y,n-x-y)
        else :
            print(-1)