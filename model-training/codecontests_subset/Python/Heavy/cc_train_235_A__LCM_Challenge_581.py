# import io, os
# input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
import sys
# sys.stdin=open('input.txt','r')
# sys.stdout=open('output.txt','w')
input=sys.stdin.readline
# sys.setrecursionlimit(300010)
MOD = 1000000007
MOD2 = 998244353
ii = lambda: int(input().strip('\n'))
si = lambda: input().strip('\n')
dgl = lambda: list(map(int,input().strip('\n')))
f = lambda: map(int, input().strip('\n').split())
il = lambda: list(map(int, input().strip('\n').split()))
ls = lambda: list(input().strip('\n'))
let = 'abcdefghijklmnopqrstuvwxyz'
from math import gcd
def lcm(x,y,z):
    tem=(x*y)//gcd(x,y)
    return (tem*z)//gcd(tem,z)
lcms=[0,1,2,6,12,60,60]
n=ii()
if n<7:
    print(lcms[n])
else:
    if n&1:
        print(n*(n-1)*(n-2))
    else:
        print(max(lcm(n,n-1,n-2),lcm(n,n-1,n-3),lcm(n-1,n-2,n-3)))