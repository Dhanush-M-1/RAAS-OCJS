N, K, Q = map(int, input().split())
A = list(map(int, input().split()))

ans = float('inf')
for X in A:  # 下限候補

    # 下限候補未満の数で分割
    S = " ".join([(str(a) if a >= X else "x") for a in A])
    S = [list(map(int, Sx.split())) for Sx in S.split("x")]

    # Max候補を列挙
    C = []
    for s in S:
        s.sort(reverse=True)
        if len(s) >= K:
            for ss in s[K-1:]:
                C.append(ss)

    # Max候補の中の小さいほうからQ番目がMax
    C.sort()
    if len(C) >= Q:
        ans = min(ans, C[Q-1]-X)

print(ans)