import math
def factor(n):
    x=[]
    i=1
    while(i<=math.sqrt(n)):
        if(n%i==0):
            if(n/i==i):
                x.append(i)
            else:
                x.append(i)
                x.append(n//i)

        i=i+1
    return x;   
import sys
input=sys.stdin.readline
a=int(input())
mini=math.inf
x=factor(a)
t=0
r=0
if(a==1):
    print(1,1)
else:
    x.sort()
    for i in range(len(x)):
        if(math.gcd(x[i],a//x[i])==1):
            
            if(max(x[i],a//x[i])<mini):
                mini=max(x[i],a//x[i])
                t=x[i]
                r=a//x[i]
        
    if(t==0):
        print(1,a)
    
    else:
        print(t,r)
        