import math,string,itertools,fractions,heapq,collections,re,array,bisect,sys,random,time
# sys.setrecursionlimit(5*10**5)
inf = 10**20
mod = 10**9 + 7

def LI(): return list(map(int, input().split()))
def II(): return int(input())
def LS(): return list(input().split())
def S(): return input()

def solve():
    k, n, m = LI()
    a_list = collections.deque(LI())
    b_list = collections.deque(LI())
    ans = list()
    while a_list or b_list:
        # print(a_list, b_list)
        a = b = inf
        if a_list:
            a = a_list.popleft()
        if b_list:
            b = b_list.popleft()
        if a == 0 or a <= k:
            ans.append(a)
            if b < inf:
                b_list.appendleft(b)
            if a == 0:
                k += 1
            continue
        if b == 0 or b <= k:
            ans.append(b)
            if a < inf:
                a_list.appendleft(a)
            if b == 0:
                k += 1
            continue
        return [-1, ]
    return ans

def main():
    t = II()
    res = list()
    for _ in range(t):
        _ = S()
        res.append(solve())
    for ans in res:
        print(*ans)
    return 0

main()