import fractions

def judge(A, B, C, D):
    if A < B:   # そもそも買えない
        return False
    if D < B:   # 補充が間に合わないのでいずれ在庫が尽きる
        return False
    if B <= C:  # 補充が間に合う状況で、必ず0個以上の在庫がある
        return True
    G = fractions.gcd(B, D)   # 昼の買い物の後に残る在庫数の候補のステップ数
    R = A % G       # 例えば A = 3, G = 2の場合、必ず1個あまる
    if C + G - R - B  < 0:
        # C + G - R: 在庫の最小数
        return False
    else:
        return True

T = int(input())
data = []
for _ in range(T):
    data.append([int(xi) for xi in input().split()])
for A, B, C, D in data:
    print('Yes') if judge(A, B, C, D) else print('No')
