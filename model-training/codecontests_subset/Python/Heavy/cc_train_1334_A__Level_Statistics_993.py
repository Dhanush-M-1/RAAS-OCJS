from collections import Counter
import math
t=int(input())
for _ in range(t):
    n=int(input())
    px,py=list(map(int,input().split()))
    cc=0
    for __ in range(n-1):
        x,y=list(map(int,input().split()))
        if cc==1:
            continue
        if not (x-px>=0 and y-py>=0 and y-py<=x-px and px>=py):
            cc=1
        px=x
        py=y
    if n==1:
        if px>=py:
            print("YES")  
        else:
            print("NO")    
    elif cc==0:
        print("YES")
    
    else:
        print("NO")