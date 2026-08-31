import io
import os

from collections import Counter, defaultdict, deque


def solve(N, K, books):
    bothLikes = []
    aLikes = []
    bLikes = []
    for t, a, b in books:
        if a and b:
            bothLikes.append(t)
        elif a:
            aLikes.append(t)
        elif b:
            bLikes.append(t)
    if len(bothLikes) + len(aLikes) < K or len(bothLikes) + len(bLikes) < K:
        return -1
    bothLikes = sorted(bothLikes)[:K]
    pref = [0]
    for x in bothLikes:
        pref.append(pref[-1] + x)
    maxIndiv = min(K, len(aLikes), len(bLikes))
    aLikes = sorted(aLikes)[:maxIndiv]
    bLikes = sorted(bLikes)[:maxIndiv]
    best = float('inf')
    indivTime = 0
    for i in range(maxIndiv + 1):
        if K - i < len(pref):
            best = min(best, indivTime + pref[K - i])
        if i != maxIndiv:
            indivTime += aLikes[i] + bLikes[i]
    return best


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    N, K = [int(x) for x in input().split()]
    books = [[int(x) for x in input().split()] for i in range(N)]
    ans = solve(N, K, books)
    print(ans)
