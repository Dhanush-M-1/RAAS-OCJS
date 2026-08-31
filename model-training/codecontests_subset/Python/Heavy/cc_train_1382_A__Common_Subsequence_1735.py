def examA():
    T = I()
    for _ in range(T):
        N, M = LI()
        A = LI()
        B = LI()
        B = set(B)
        cur = -1
        for a in A:
            if a in B:
                cur = a
                break
        if cur==-1:
            print("NO")
            continue
        print("YES")
        print("1",cur)
    return

def examB():
    T = I()
    ans = []
    for _ in range(T):
        cur = 0
        ans.append(cur)
    for v in ans:
        print(v)
    return

def examC():
    T = I()
    ans = []
    for _ in range(T):
        cur = 0
        ans.append(cur)
    for v in ans:
        print(v)
    return

def examD():
    ans = 0
    print(ans)
    return

def examE():
    ans = 0
    print(ans)
    return

def examF():
    ans = 0
    print(ans)
    return

from decimal import getcontext,Decimal as dec
import sys,bisect,heapq
from copy import deepcopy
from heapq import heappop,heappush,heapify
from collections import Counter,defaultdict,deque
read = sys.stdin.buffer.read
readline = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines
def I(): return int(input())
def LI(): return list(map(int,sys.stdin.readline().split()))
def DI(): return dec(input())
def LDI(): return list(map(dec,sys.stdin.readline().split()))
def LSI(): return list(map(str,sys.stdin.readline().split()))
def LS(): return sys.stdin.readline().split()
def SI(): return sys.stdin.readline().strip()
global mod,mod2,inf,alphabet,_ep
mod = 10**9 + 7
mod2 = 998244353
inf = 10**18
_ep = dec("0.000000000001")
alphabet = [chr(ord('a') + i) for i in range(26)]
alphabet_convert = {chr(ord('a') + i): i for i in range(26)}

getcontext().prec = 28

sys.setrecursionlimit(2*10**5)

if __name__ == '__main__':
    examA()

"""

"""