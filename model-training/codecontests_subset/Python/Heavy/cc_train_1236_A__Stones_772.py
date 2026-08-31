from collections import defaultdict as dc
import sys
import math
input=sys.stdin.readline
for _ in range(int(input())):
    a,b,c=map(int,input().split())
    if b==0:
        print(0)
    else:
        x=0
        p=c//2
        #print('p',p)
        if p<=b:
            x+=p+2*p
            b-=p
        else:
            x+=b+2*b
            b=0
        #print('b1',b)
        #print('x',x)
        q=b//2
        if q<=a:
            x+=q+2*q
            a-=q
        else:
            x+=a+2*a
        print(x)
        
            
        