import sys
import math
from collections import defaultdict
t=int(sys.stdin.readline())
for _ in range(t):
    n,m=map(int,sys.stdin.readline().split())
    a=list(map(int,sys.stdin.readline().split()))
    b=list(map(int,sys.stdin.readline().split()))
    dica=defaultdict(int)
    # print(a,'a')
    # print(b,'b')
    for i in range(n):
        dica[a[i]]+=1
    z=True
    for i in range(m):
        if dica[b[i]]>=1:
            z=False
            print("YES")
            print(1,b[i])
            break
    if z:
        print("NO")