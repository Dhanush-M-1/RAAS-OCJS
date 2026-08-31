'''
    Auther: ghoshashis545 Ashis Ghosh
    College: jalpaiguri Govt Enggineering College

'''
from os import path
import sys
from heapq import heappush,heappop
from functools import cmp_to_key as ctk
from collections import deque,defaultdict as dd
from bisect import bisect,bisect_left,bisect_right,insort,insort_left,insort_right
from itertools import permutations
from datetime import datetime
from math import ceil,sqrt,log,gcd
def ii():return int(input())
def si():return input().rstrip()
def mi():return map(int,input().split())
def li():return list(mi())
abc='abcdefghijklmnopqrstuvwxyz'
# mod=1000000007
mod=998244353
inf = float("inf")
vow=['a','e','i','o','u']
dx,dy=[-1,1,0,0],[0,0,1,-1]

def bo(i):
    return ord(i)-ord('a')

def ceil1(a,b):
    return (a+b-1)//b



    
def solve():


    for _ in range(ii()):

        n = ii()
        a = []
        for i in range(n):
            a.append(list(si()))

        x = [[0,1],[1,0],[n-2,n-1],[n-1,n-2]]

        for i in range(16):

            ok = True
            for j in range(4):
                if i&(1<<j):
                    p = x[j]
                    x1 = a[p[0]][p[1]]
                    x1 = int(x1) ^ 1
                    a[p[0]][p[1]] = str(x1)

            q = deque([[0,0]])
            vis = [[0]*n for i in range(n)]
            vis[0][0] = 1
            while len(q) > 0:
                u = q[0][0]
                v = q[0][1]
                if ok == False:
                    break
                q.popleft()
                for k in [[0,1],[1,0]]:
                    x1 = u + k[0]
                    x2 = v + k[1]
                    if x1 >= n or x2 >= n or vis[x1][x2]:
                        continue
                    if a[x1][x2] == 'F':
                        ok = False
                        break
                    if a[x1][x2] == '0':
                        continue
                    vis[x1][x2] = 1
                    q.append([x1,x2])

            q = deque([[0,0]])
            vis = [[0]*n for i in range(n)]
            vis[0][0] = 1
            while len(q) > 0:
                u = q[0][0]
                v = q[0][1]
                if ok == False:
                    break
                q.popleft()
                for k in [[0,1],[1,0]]:
                    x1 = u + k[0]
                    x2 = v + k[1]
                    if x1 >= n or x2 >= n or vis[x1][x2]:
                        continue
                    if a[x1][x2] == 'F':
                        ok = False
                        break
                    if a[x1][x2] == '1':
                        continue
                    vis[x1][x2] = 1
                    q.append([x1,x2])
                



            





            ans = []
            for j in range(4):
                if i&(1<<j):
                    ans.append(x[j])
                    p = x[j]
                    x1 = a[p[0]][p[1]]
                    x1 = int(x1) ^ 1
                    a[p[0]][p[1]] = str(x1)
            if ok:
                print(len(ans))
                for i in ans:
                    print(i[0]+1,i[1]+1)
                break

        















        
if __name__ =="__main__":

    
    if path.exists('input.txt'):
        sys.stdin=open('input.txt', 'r')
        sys.stdout=open('output.txt','w')
    else:
        input=sys.stdin.readline
    solve()