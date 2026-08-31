import sys
def input():
    return sys.stdin.readline()[:-1]
T=int(input())
from fractions import gcd
for i in range(T):
    A,B,C,D=map(int,input().split())
    if A<B or D<B:
        print("No")
        continue
    if B<=C+1:
        print("Yes")
        continue
    if B==D:
        if A%B<=C:
            print("Yes")
        else:
            print("No")
        continue
    g=gcd(B,D-B)
    if (C-A%g)//g<(B-1-A%g)//g:
        print("No")
    else:
        print("Yes")