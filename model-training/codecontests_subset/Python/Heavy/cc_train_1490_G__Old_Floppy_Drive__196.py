from collections import defaultdict
from itertools import accumulate
import sys
import bisect
input = sys.stdin.readline
'''
for CASES in range(int(input())):
n, m = map(int, input().split())
n = int(input())
A = list(map(int, input().split()))
S = input().strip()
sys.stdout.write(" ".join(map(str,ANS))+"\n")
'''
inf = 100000000000000000  # 1e17
mod = 998244353

for CASES in range(int(input())):
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    S=[0]
    for a in A:
        S.append(S[-1]+a)
    S1=S.copy()
    for i in range(1,len(S1)):
        S1[i]=max(S1[i-1],S1[i])
    # print(S)
    MAX=max(S1)
    ACU=S[-1]

    for que in B:
        times=0
        if que>MAX and ACU<=0:
            print(-1,end=" ")
            continue
        elif que>MAX and ACU>0:
            times=(que-MAX+ACU-1)//ACU
        print(times*n+bisect.bisect_left(S1,que-times*ACU)-1,end=" ")
    print()
