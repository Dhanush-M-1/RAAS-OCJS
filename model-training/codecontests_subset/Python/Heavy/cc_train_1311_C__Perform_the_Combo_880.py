def solve():
    t = inp()
    for _ in range(t):
        n,k = mul()
        temp = k+1
        s = strl()
        l = seq()
        arr = [[0 for z in range(n)] for y in range(26)]
        for j in range(n):
            val = ord(s[j])-97
            arr[val][j] = 1
        for j in range(26):
            for k in range(1,n):
                arr[j][k] +=arr[j][k-1]

        l.append(n)
        result = [0 for j in range(26)]
        for x in range(temp):
            val = l[x]-1
            for index in range(26):
                result[index]+=arr[index][val]
        print(*result)

import sys
import math
import bisect
from sys import stdin,stdout
from math import gcd,floor,sqrt,log
from collections import defaultdict as dd
from bisect import bisect_left as bl,bisect_right as br

inp    =lambda: int(input())
strng  =lambda: input().strip()
jn     =lambda x,l: x.join(map(str,l))
strl   =lambda: list(input().strip())
mul    =lambda: map(int,input().strip().split())
mulf   =lambda: map(float,input().strip().split())
seq    =lambda: list(map(int,input().strip().split()))

ceil   =lambda x: int(x) if(x==int(x)) else int(x)+1
ceildiv=lambda x,d: x//d if(x%d==0) else x//d+1

flush  =lambda: stdout.flush()
stdstr =lambda: stdin.readline()
stdint =lambda: int(stdin.readline())
stdpr  =lambda x: stdout.write(str(x))

solve()



