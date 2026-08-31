from collections import Counter

sc = iter(open(0).read().split())
ni = lambda: int(next(sc))
ns = lambda: next(sc)

T = ni()
for _ in range(T):
    N, M = ni(), ni()
    S = [ord(s) - ord('a') for s in ns()]
    P = [ni() - 1 for _ in range(M)]
    P.append(N - 1)

    C = Counter(P)
    K = sorted(C.keys(), reverse=True)

    ans = [0] * 26

    k = K.pop()
    cur = 0
    for i, s in enumerate(S):
        ans[s] += M + 1 - cur

        if i == k:
            cur += C[k]
            if K:
                k = K.pop()

    print(*ans)