import os
import sys

if os.getenv("LOCAL"):
    sys.stdin = open("_in.txt", "r")

sys.setrecursionlimit(10 ** 9)
INF = float("inf")
IINF = 10 ** 18
MOD = 10 ** 9 + 7
# MOD = 998244353


N, K, Q = list(map(int, sys.stdin.buffer.readline().split()))
A = list(map(int, sys.stdin.buffer.readline().split()))

if Q == 1:
    print(0)
    exit()


def argsort(li, key=None, reverse=False):
    return [i for _, i in
            sorted([(a, i) for i, a in enumerate(li)], key=(lambda t: key(t[0])) if key else None, reverse=reverse)]


idx = argsort(A)
used = [False] * N
ans = INF
# 小さい方の値を決め打つ
for min_i in idx:
    groups = [[]]
    for i in range(N):
        if used[i]:
            if groups[-1]:
                groups.append([])
        else:
            groups[-1].append(A[i])
    nums = []
    for group in groups:
        if len(group) >= K:
            group.sort()
            nums += group[:len(group) - K + 1]
    if len(nums) < Q:
        break
    nums.sort()
    ans = min(ans, nums[Q - 1] - nums[0])
    used[min_i] = True
print(ans)
