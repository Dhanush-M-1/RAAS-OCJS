from sys import stdin, setrecursionlimit, stdout
setrecursionlimit(100) #use "python" instead of "pypy" to avoid MLE
from collections import deque
from math import sqrt, floor, ceil, log, log2, log10, pi, gcd, sin, cos, asin
from heapq import heapify, heappop, heappush, heapreplace, heappushpop
from bisect import bisect_right, bisect_left
def ii(): return int(stdin.readline())
def fi(): return float(stdin.readline())
def mi(): return map(int, stdin.readline().split())
def fmi(): return map(float, stdin.readline().split())
def li(): return list(mi())
def si(): return stdin.readline().rstrip()
def lsi(): return list(si())
mod=1000000007
res=['NO', 'YES']


#######################################################################################
###########################    M Y     F U N C T I O N S    ###########################
#######################################################################################

def solve():
    n, m=mi()
    a=set(li())
    b=set(li())
    for i in a:
        if i in b:
            print('YES')
            print(1, i)
            return
    print('NO')

#######################################################################################
###########################    M A I N     P R O G R A M    ###########################
#######################################################################################



test=1
test_case=ii()
while test<=test_case:
    test+=1


    solve()

