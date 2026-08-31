import math
from bisect import bisect_left, bisect_right
import sys

def get_ints(): return list(map(int, sys.stdin.readline().strip().split()))

T = int(input())
for _ in range(T):
    N, M = get_ints()
    A = get_ints()
    X = get_ints()

    # Q = []
    # for i in range(M):
    #     Q.append((X[i], i))
    # Q.sort()

    last_val = 0
    presum = []
    index = []
    sort_presum = []
    max_val = float('-inf')
    for i in range(N):
        if not presum or presum[-1] < last_val + A[i]:
            presum.append(last_val + A[i])
            index.append(i)

        # sort_presum.append((last_val + A[i], i))
        # max_val = max(max_val, presum[-1])
        last_val += A[i]
    # sort_presum.sort()

    vis = {}
    q_idx = 0
    p_idx = 0
    for q_idx in range(M):
        val = X[q_idx]
        if presum[-1] < val and last_val <= 0:
            vis[q_idx] = -1
            continue

        if presum[-1] < val:
            t = math.ceil((val - presum[-1]) / last_val)
        else:
            t = 0

        val -= t * last_val
        i = bisect_left(presum, val)
        vis[q_idx] = t * N + index[i]

    # print(vis)
    ans = [str(vis[i]) for i in range(M)]
    print((" ").join(ans))
