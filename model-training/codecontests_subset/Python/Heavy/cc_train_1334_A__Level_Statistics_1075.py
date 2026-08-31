import sys
# from collections import deque
# 26
input = lambda: sys.stdin.readline().strip()
ipnut = input
def ch(a):
    return a**0.5==int(a**0.5)
for i in range(int(input())):
    n = int(ipnut())
    # tt,tk = map(int,input().split())
    # a = list(input())
    f = True
    tt, tk = 0,0
    for i in range(n):
        t,k = map(int,input().split())
        if t<tt or k<tk:
            f = False

        dt = t-tt
        dk = k-tk
        if dt<dk:
            f = False
            
        tt = t
        tk = k
    if f:
        print('YES')
    else:
        print('NO')
