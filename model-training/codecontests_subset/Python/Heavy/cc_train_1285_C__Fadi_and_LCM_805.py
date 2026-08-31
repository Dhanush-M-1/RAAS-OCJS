from math import ceil,sqrt,gcd
def ii():return int(input())
def mi():return map(int,input().split())
def li():return list(mi())
def si():return input()
def lcm(x,y):
    #print(x*y//gcd(x,y))
    s=x*y
    return s//gcd(x,y)
n=ii()
if(n==1):
    print(1,1)
else:
    b=[]
    y=1
    x=int(sqrt(n))+1
    for i in range(1,x):
        if(n%i==0):
            if(i!=n//i):
                b.append(i)
        if(i==n):
            b.append(i)
    for i in range(len(b)-1,-1,-1):
        j=b[i]
        if(lcm(j,n//j)==n):
            print(j,n//j)
            break