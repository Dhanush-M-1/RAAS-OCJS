import io
import os

from collections import Counter, defaultdict, deque
from bisect import bisect_left


def solve(N, M, A, X):
    pref = [0]
    for x in A:
        pref.append(pref[-1] + x)
    for i in range(1, N + 1):
        pref[i] = max(pref[i], pref[i - 1])
    pref.pop(0)

    cycleLen = N
    cycleSum = sum(A)
    excess = max(0, pref[-1] - cycleSum)
    ans = []
    for x in X:
        t = bisect_left(pref, x)
        if t < len(pref) and pref[t] >= x:
            ans.append(t)
        else:
            if cycleSum <= 0:
                ans.append(-1)
            else:
                fullCycles = (x - excess - 1) // cycleSum
                x -= cycleSum * fullCycles
                base = fullCycles * cycleLen
                assert 0 <= x <= pref[-1]
                t = bisect_left(pref, x)
                ans.append(base + t)

    return " ".join(map(str, ans))


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    TC = int(input())
    for tc in range(1, TC + 1):
        N, M = [int(x) for x in input().split()]
        A = [int(x) for x in input().split()]
        X = [int(x) for x in input().split()]
        ans = solve(N, M, A, X)
        print(ans)

