inf = float('inf')

N, K, Q = map(int, input().split())
a = tuple(map(int, input().split()))

ans = inf
for ma in sorted(set(a)):
    res = []
    seq = 0
    for i, aa in enumerate(a):
        if aa >= ma:
            # 最小値以上の要素は部分列に含めてよい
            seq += 1
        else:
            # 最小値未満の要素が来たら、
            # それまでの部分列を処理する
            if seq >= K:
                res.extend(sorted(a[i - seq:i])[:seq - K + 1])
            seq = 0
    if seq >= K:
        res.extend(list(sorted(a[-seq:]))[:seq - K + 1])
    seq = 0
    if len(res) < Q: continue
    res.sort()
    ans = min(ans, res[Q - 1] - ma)
print(ans)
