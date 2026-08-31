def gcd(a,b,L):
    if a==0:
        L[0]=0
        L[1]=1
        return b

    L2 = [0,0]
    d = gcd(b%a,a,L2)

    L[0] = L2[1] - (b//a)*L2[0]
    L[1] = L2[0]
    return d

inp=input().split()
n=int(inp[0])
p=int(inp[1])
w=int(inp[2])
d=int(inp[3])

Lp=[0,0]
g=gcd(w,d,Lp)

if p%g!=0:
    print(-1)

else:
    xb=d//g
    yb=w//g

    Lp[0]*=p//g
    Lp[1]*=p//g

    YMOD = Lp[1]%yb

    change = (Lp[1]-YMOD)//yb
    Lp[0] += xb*change
    Lp[1] -= yb*change

    if Lp[0]+Lp[1] > n or Lp[0]<0 or Lp[1]<0: print(-1)
    else: print(Lp[0],Lp[1],n-Lp[0]-Lp[1])
