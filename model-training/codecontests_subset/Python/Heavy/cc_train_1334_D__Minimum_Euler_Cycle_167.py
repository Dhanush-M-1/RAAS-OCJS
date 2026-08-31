from sys import stdin
from collections import deque
mod = 10**9 + 7
import sys
import random
# sys.setrecursionlimit(10**6)
from queue import PriorityQueue
# def rl():
#     return [int(w) for w in stdin.readline().split()]
from bisect import bisect_right
from bisect import bisect_left
from collections import defaultdict
from math import sqrt,factorial,gcd,log2,inf,ceil
# map(int,input().split())
# # l = list(map(int,input().split()))
# from itertools import permutations
import heapq
# input = lambda: sys.stdin.readline().rstrip()
input = lambda : sys.stdin.readline().rstrip()
from sys import stdin, stdout
from heapq import heapify, heappush, heappop
from itertools import permutations
from math import factorial as f

# def ncr(x, y):
#     return f(x) // (f(y) * f(x - y))
def ncr(n, r, p):
    num = den = 1
    for i in range(r):
        num = (num * (n - i)) % p
        den = (den * (i + 1)) % p
    return (num * pow(den,
                      p - 2, p)) % p

def solve(n):
    return (n*(n+1))//2




t = int(input())

for _ in range(t):

    n,l,r = map(int,input().split())
    # print((2*n - 1)**2,4*l)
    if 2*(n)*n - (n)*(n+1)  + 1 == l:
        print(1)
        continue
    # print(2*(n)*n - (n)*(n+1))
    z_1 = (2*n - 1 + sqrt((2*n - 1)**2 - 4*l))
    z_2 = (2*n - 1 - sqrt((2*n - 1)**2 - 4*l))
    z1 = ceil(min(z_1,z_2) / 2)

    # print(2*(n)*n - (n)*(n+1))
    # z_1 = 2*n - 1 + sqrt((2*n - 1)**2 + 4*r)
    # z_2 = 2*n - 1 - sqrt((2*n - 1)**2 + 4*r)
    # z2 = max(-z_1,-z_2) // 2
    # print(z1)
    # print(z1)
    z0 = z1-1
    la = l
    l-= 2*(z0)*n - (z0)*(z0+1)

    # print(z1,l)l
    # z0 = z23
    # 2 1 3
    # 3 3 6
    # 99995 9998900031 9998900031
    # r-= 2*(z0)*n - (z0)*(z0+1)

    # z1+=1

    # print(z1)
    # if z1 == n:
    #     print(1)
    #     continue
    # z2+=1
    ans = []

    if l%2==0:
      k1 = l//2
      l = la
    else:
        ans.append(int(z1))
        k1 = (l+1)//2
        l = la
        if r-l +1 == len(ans):
            print(*ans)
            continue
        l+=1

    # print(k1)
    ha = z1+1 + (k1-1)

    ans.append(int(ha))
    l+=1
    cnt = max(ans)+1



    while l!=r+1:

        if ans[-1] == n:
            z1+=1


            cnt = z1+1
            if z1 == n+1 or z1 == n:

                ans.append(1)
                break
            else:
                ans.append(int(z1))
        else:

            if l%2 != 0:
                ans.append(int(z1))
            else:

                ans.append(int(cnt))
                cnt+=1

        l+=1

    print(*ans)


