import sys
# sys.setrecursionlimit(10**6) 
import math
input=sys.stdin.readline
t=int(input())
for t1 in range(t):
    n=int(input())
    a=0
    b=0
    if(n==1):
        print(0)
    else:
        while(n%2==0):
            n=n//2
            a+=1
        while(n%3==0):
            n=n//3
            b+=1
        # print(a,b)
        if(n>1 or b==0 or a>b):
            print(-1)
        else:
            if(a==0):
                print((b-1)*2+2)
            else:
                
                z=a-1
                b-=z
                a=1
                # print(a,b)
                print((b-1)*2+z+1)
