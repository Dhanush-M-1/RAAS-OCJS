from sys import stdin, stdout, setrecursionlimit
input = stdin.readline
# setrecursionlimit(int(1e6))
inf = float('inf')
from functools import cmp_to_key
from collections import defaultdict as dd
from collections import Counter, deque
from heapq import *
import math
from math import floor, ceil, sqrt
def geti(): return map(int, input().strip().split())
def getl(): return list(map(int, input().strip().split()))
def getis(): return map(str, input().strip().split())
def getls(): return list(map(str, input().strip().split()))
def gets(): return input().strip()
def geta(): return int(input())
def print_s(s): stdout.write(s+'\n')

def solve():
    n = geta()
    a = getl()
    ans = 0
    mod = 998244353
    count = dd(int)
    for i in a:
        count[len(str(i))] += 1
    for i in a:
        for j in count:
            new = ''
            now = str(i)
            index = len(now) - 1
            other = ''
            for zero in range(j):
                if index == -1:
                    break
                other = now[index] + other
                other = '0' + other
                new = '0' + new
                new = now[index] + new
                index -= 1
            while index != -1:
                new = now[index] + new
                other = now[index] + other
                index -= 1
            # print(new, other, i, count[j])
            ans += int(new)*count[j]
            ans %= mod
            ans += int(other)*count[j]
            ans %= mod
    print(ans)

if __name__=='__main__':
    solve()
