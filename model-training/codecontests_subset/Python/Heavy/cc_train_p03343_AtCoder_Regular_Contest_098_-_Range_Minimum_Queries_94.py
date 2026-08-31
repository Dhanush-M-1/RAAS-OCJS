N, K, Q = map(int,input().split())
A = list(map(int,input().split()))

ans = float("inf")

# 最小値Y決め打ち
for Y in A:
    # Y以下の場所で区切る
    B = []
    tmp = []
    for a in A:
        if a < Y:
            if tmp:
                B.append(tmp)
                tmp = []
        else:
            tmp.append(a)
    if tmp:
        B.append(tmp)
        tmp = []

    cand = []
    # 操作可能な区間を各々ソート
    B = [sorted(b) for b in B]
    for b in B:
        # 各区間 len(b)-K+1個まで取り除ける
        # 小さい方から選んでいく
        r = max(len(b)-K+1, 0)
        cand += b[:r]
    # 候補をソート
    cand = sorted(cand)
    # Q個以上ならok 最大値の最小値はQ番目になる
    if len(cand) >= Q:
        X = cand[Q-1]
        ans = min(ans, X - Y)

print(ans)