import math
from collections import Counter
for test in range(int(input())):
    n=int(input())
    A=list(map(int,input('').split()))
    ans=[1,2,n]
    if A[0]+A[1]<=A[-1]:
        print(*ans)
    else:
        print(-1)
