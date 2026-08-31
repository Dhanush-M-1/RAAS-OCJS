import bisect
from itertools import accumulate
from collections import Counter, defaultdict
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline


def solve():
    N = int(input())
    L = list(map(int, input().split()))
    C = Counter(L)
    L = sorted(list(set(L)), reverse=True)
    L_acc = [0]
    for l in L:
        L_acc.append(C[l])
    L_acc = list(accumulate(L_acc))

    ind = bisect.bisect_right(L_acc, N//2)
    for g_ind in range(1, ind):
        for s_ind in range(g_ind+1, ind):
            g = L_acc[g_ind]
            s = L_acc[s_ind]-L_acc[g_ind]
            b = L_acc[ind-1]-g-s
            if g < s and g < b:
                return [g, s, b]
    return []


T = int(input())
for _ in range(T):
    ret = solve()
    if len(ret) == 0:
        print("0 0 0")
    else:
        print(" ".join(map(str, ret)))
