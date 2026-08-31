import sys

def gcd(a,b):
    if 0==b:
        return a
    else:
        return gcd(b,a%b)

def lcm(a,b):
    return a*b//gcd(a,b)

def exgcd(a,b,X,Y):
    if 0==b:
        X[0]=1
        Y[0]=0
        return a
    g=exgcd(b,a%b,Y,X)
    Y[0]-=a//b*X[0]
    return g

def ceil(x,y):
    return (x+y-1)//y

def main():
    n,p,w,d=map(int,input().split())
    if 0==p:
        print('0 0 %d'%n)
        return
    g=gcd(w,d)
    if p%g!=0:
        print('-1')
        return
    X=[0]
    Y=[0]
    exgcd(w,d,X,Y)
    x=X[0]*p//g
    y=Y[0]*p//g
    k1=lcm(w,d)//w
    k2=lcm(w,d)//d

    if x<0:
        t=ceil(abs(x),k1)
        x=x+k1*t
        y=y-k2*t
    if y<0:
        t=ceil(abs(y),k2)
        x=x-k1*t
        y=y+k2*t

    if x<0 or y<0:
        print('-1')
        return

    t=y//k2
    x=x+k1*t
    y=y-k2*t

    if 0<=x<=n and 0<=y<=n and x+y<=n:
        print(x,y,n-x-y)
    else:
        print('-1')

main()