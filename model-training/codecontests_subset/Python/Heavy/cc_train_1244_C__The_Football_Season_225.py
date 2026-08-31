from sys import setrecursionlimit
setrecursionlimit(10**8)
from math import gcd
class InEq:
    def __init__(self,a,b,c):
        self.a,self.b,self.c=a,b,c
        self.m,self.x0,self.y0=0,[0],[0]
        self.check=True
        g=gcd(self.a,self.b)
        if c%g!=0:
            self.check=False
        else:
            self.extgcd(self.a,self.b,self.x0,self.y0)
            self.x0=self.x0[0]*c//g
            self.y0=self.y0[0]*c//g
            self.a//=g
            self.b//=g
    def extgcd(self,a,b,x,y):
        if b==0:
            x[0],y[0]=1,0
            return a
        d=self.extgcd(b,a%b,y,x)
        y[0]-=(a//b)*x[0]
        return d
    def m_update(self,m):
        self.x0+=(m-self.m)*self.b
        self.y0-=(m-self.m)*self.a
        self.m=m

n,p,w,d=map(int,input().split())
eq=InEq(w,d,p)
if not eq.check:
    print(-1)
    exit()
if eq.y0>=0:
    eq.m_update(eq.y0//eq.a)
else:
    eq.m_update(eq.y0//eq.a)
if eq.x0<0 or eq.x0+eq.y0>n:
    print(-1)
else:
    print(eq.x0,eq.y0,n-eq.x0-eq.y0)