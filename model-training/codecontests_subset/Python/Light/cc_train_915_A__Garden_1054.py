import sys
import math
input = sys.stdin.readline
for _ in range(1):
    n,k = map(int,input().split())
    l = list(map(int,input().split()))
    ans = 10**18
    for i in l:
        if k%i == 0:
            ans = min(ans,k//i)

    print(ans)