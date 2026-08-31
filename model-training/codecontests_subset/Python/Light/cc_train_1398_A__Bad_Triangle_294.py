import math
from collections import Counter,defaultdict
I =lambda:int(input())
M =lambda:map(int,input().split())
LI=lambda:list(map(int,input().split()))
for _ in range(I()):
    n=I()
    a=LI()
    if a[0]+a[1]<=a[-1]:
        print(1,2,n)
    else:
        print(-1)
