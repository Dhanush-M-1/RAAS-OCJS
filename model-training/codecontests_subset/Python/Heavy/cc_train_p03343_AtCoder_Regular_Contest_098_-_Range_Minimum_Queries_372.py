# https://atcoder.jp/contests/arc098/submissions/2581691
inf = float('inf')


def calc_max_a(min_a):
    cands = []  # 候補
    seq = 0
    for i, aa in enumerate(a):
        if aa < min_a:
            if seq >= K:
                cands.extend(sorted(a[i - seq:i])[:seq - K + 1])
            seq = 0
        else:
            seq += 1
    if seq >= K:
        cands.extend(sorted(a[- seq:])[:seq - K + 1])

    if len(cands) < Q:
        return -1  # Query回数の操作ができない
    else:
        return sorted(cands)[Q - 1]  # Q回目の操作で取り出す値


N, K, Q = map(int, input().split())
a = tuple(map(int, input().split()))

ans = inf
for min_a in sorted(set(a)):
    max_a = calc_max_a(min_a)
    if max_a < 0: break  # min_a以上の値を最小値にするような操作は存在しない
    ans = min(ans, max_a - min_a)
print(ans)
