inf = 10 ** 9

n, k, q = map(int, input().split())
a = tuple(map(int, input().split()))

ans = inf
for min_ in sorted(set(a)):
    res = []  # 最小値min_としたとき、取り除ける要素全て
    seq = 0
    for ind, a_ in enumerate(a):
        if a_ >= min_:
            seq += 1
        else:
            if seq >= k:
                sequence_le_k = a[ind - seq:ind]  # 長さk以上の数列
                pick = seq - k + 1  # この個数だけ取り除く
                res.extend(sorted(sequence_le_k)[:pick])
            seq = 0
    else:
        if seq >= k:
            sequence_le_k = a[-seq:]  # 長さk以上の数列
            pick = seq - k + 1  # この個数だけ取り除く
            res.extend(sorted(sequence_le_k)[:pick])
    if len(res) < q:
        continue
    res.sort()
    ans = min(ans, res[q - 1] - min_)  # q回目に取り除いた要素 = 取り除く最大値
print(ans)
