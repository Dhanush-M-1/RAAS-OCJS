import sys
read = sys.stdin.buffer.read
readline = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines

from heapq import heappush, heappushpop, heapify
from fractions import gcd

N = int(readline())
m = map(int,read().split())
AB = sorted(zip(m,m),key=lambda x:(x[1],x[0]))
A,B = zip(*AB)

dp2 = [0]*N # T_B - T_A
for i in range(N-1,0,-1):
    a = A[i]; b = B[i]
    if a<b:
        dp2[i-1] = dp2[i]+(b-a)
    else:
        dp2[i-1] = dp2[i]

def F(n):
    opt_num = -1
    opt_den = 1
    q = list(-x for x in A[:n])
    heapify(q)
    S = -sum(q)
    for i in range(n,N):
        a = A[i]; b = B[i]
        x = S+a-dp2[i]
        if 0<=x<=b:
            den = b
            num = (n+1)*den-x
            if opt_num*den < opt_den*num:
                opt_num = num; opt_den = den
        x = a
        y = -heappushpop(q,-x)
        S += x-y
    return opt_num, opt_den

opt_num = 0; opt_den = 1
left = -1 # 値がある
right = N+10 # むり
while left+1 < right:
    mid = (left+right)//2
    num,den = F(mid)
    if num==-1:
        right=mid
    else:
        left=mid
        if opt_num*den < opt_den*num:
            opt_num = num; opt_den = den

opt_den *= N
g = gcd(opt_num,opt_den)
opt_num//=g; opt_den//=g
print(opt_num,opt_den)