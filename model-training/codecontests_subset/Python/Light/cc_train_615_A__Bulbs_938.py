import re, sys, math, string, operator, functools, fractions, collections
sys.setrecursionlimit(10**7)
dX= [-1, 1, 0, 0,-1, 1,-1, 1]
dY= [ 0, 0,-1, 1, 1,-1,-1, 1]
RI=lambda: list(map(int,input().split()))
RS=lambda: input().rstrip().split()
#################################################
n,m=RI()
f=[0]*m
for i in range(n):
    inp=RI()[1:]
    for j in inp:
        f[j-1]=1
print(["NO","YES"][all(f[i] for i in range(m))])

