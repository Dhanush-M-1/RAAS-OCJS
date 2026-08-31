import math
t=int(input())
for ii in range(t):
    a,b,c=map(int,input().split())
    if c<a or c>b:
        print(c)
    else:
        if b%c==0:
            print(c*((b//c)+1))
        else:
            print(c*math.ceil(b/c))
                
