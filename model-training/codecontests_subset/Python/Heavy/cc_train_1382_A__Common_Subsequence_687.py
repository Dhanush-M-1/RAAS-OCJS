import heapq

from collections import deque
from collections import defaultdict

import sys

sys.setrecursionlimit(100000)

#input=sys.stdin.readline
#print=sys.stdout.write

I=lambda : list(map(int,input().split(' ')))
for _ in range(int(input())):
    n,m=I()
    a=I()
    b=I()
    as_=set(a)
    bs_=set(b)
    flag=0
    ans=None
    for ele in a+b:
        if ele in as_ and ele in bs_:
            ans=ele
            flag=1
            break
    if flag:
        print('YES')
        print(1,end=' ' )
        print(ele)
    else:
        print('NO')
            
        