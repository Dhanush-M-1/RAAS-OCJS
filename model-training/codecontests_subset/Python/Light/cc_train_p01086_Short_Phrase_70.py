from collections import defaultdict,deque
import sys,heapq,bisect,math,itertools,string,queue,datetime
sys.setrecursionlimit(10**8)
INF = float('inf')
mod = 10**9+7
eps = 10**-7
def inpl(): return list(map(int, input().split()))
def inpl_str(): return list(input().split())

while True:
    n = int(input())
    if n == 0:
        break
    else:
        ww = [len(input()) for i in range(n)]

        L = [5,7,5,7,7]
        for i in range(n):
            k = i
            tmp = 0
            S = 0
            flag = False
            while True:
                w = ww[k]
                if L[tmp] - S > w:
                    S += w
                elif L[tmp] - S == w:
                    tmp += 1
                    S = 0
                else:
                    break

                if tmp == 5:
                    flag = True
                    break

                k += 1

            if flag:
                print(i+1)
                break

