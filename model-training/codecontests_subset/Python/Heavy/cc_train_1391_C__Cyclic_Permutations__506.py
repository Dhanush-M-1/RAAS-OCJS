import sys,math
from collections import Counter,deque,defaultdict
input = sys.stdin.readline
L=lambda:list(map(int,input().split()))
M=lambda:map(int,input().split())
I=lambda:int(input())
IN=lambda:input()
C=lambda:input().strip().split()
mod=1000000007
def s(a):print(" ".join(list(map(str,a))))
#______________________-------------------------------_____________________#
def solve():
    n=I()
    fa=1
    for i in range(1,n+1):
        fa=((i%mod)*(fa%mod))%mod
    c=1
    for i in range(n-1):
        c=((c%mod)*2)%mod
    print((fa-c)%mod)
for _ in range(1):
    solve()
