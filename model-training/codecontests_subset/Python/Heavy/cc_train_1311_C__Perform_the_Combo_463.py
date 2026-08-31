import sys
# import bisect
# from collections import deque

Ri = lambda : [int(x) for x in sys.stdin.readline().split()]
ri = lambda : sys.stdin.readline().strip()
 
def input(): return sys.stdin.readline().strip()
def list2d(a, b, c): return [[c] * b for i in range(a)]
def list3d(a, b, c, d): return [[[d] * c for j in range(b)] for i in range(a)]
def list4d(a, b, c, d, e): return [[[[e] * d for j in range(c)] for j in range(b)] for i in range(a)]
def ceil(x, y=1): return int(-(-x // y))
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(N=None): return list(MAP()) if N is None else [INT() for i in range(N)]
def Yes(): print('Yes')
def No(): print('No')
def YES(): print('YES')
def NO(): print('NO')
INF = 10 ** 18
MOD = 998244353

for _ in range(int(ri())):
    n,m = Ri()
    s = ri()
    p = Ri()
    p = [i-1 for i in p]
    se = {}
    for i in p:
        if i in se:
           se[i]+=1
        else:
            se[i] = 1

    dic = {}
    summ  = 0
    for i in range(n-1,-1,-1):
        if i in se:
            summ+=se[i]
        if s[i] in dic:
            dic[s[i]]+=summ
        else:
            dic[s[i]] = summ
    for i in s:
        dic[i]+=1
    # print(dic)
    for i in range(26):
        if chr(ord('a')+i) in dic:
            print(dic[chr(ord('a')+i)],end=" ")
        else:
            print(0,end=" ")
    print()
    