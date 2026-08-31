import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
# sys.setrecursionlimit(5*10**5)
inf = 10**20
mod = 10**9 + 7

def LI(): return list(map(int, input().split()))
def II(): return int(input())
def LS(): return list(input().split())
def S(): return input()

def main():
    n, k = LI()
    tab = [LI() for _ in range(n)]
    both = list()
    only_a = list()
    only_b = list()
    for t, a, b in tab:
        if a and b:
            both.append(t)
        elif a:
            only_a.append(t)
        elif b:
            only_b.append(t)
    m = min(len(only_a), len(only_b))
    only_b.sort()
    only_a.sort()
    for i in range(m):
        tmp = only_b[i] + only_a[i]
        both.append(tmp)
    both.sort()
    if len(both) < k:
        return -1
    return sum(both[:k])


print(main())