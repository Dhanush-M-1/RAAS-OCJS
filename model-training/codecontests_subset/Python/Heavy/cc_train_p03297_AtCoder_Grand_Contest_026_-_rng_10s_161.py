# https://www.youtube.com/watch?v=eB0eT-948Vw

# 一部の自明なケースを除くと、ループする
# [(C+1)-B,C+(D-B)]
# この範囲に0未満の値があって、取ることが可能ならNoである

# 2つの変化(-B),(D-B)は、まとめて-B(mod D)と捉える
# ループ区間で、
# g=gcd(D,B)を法として、
# Aと合同なXは、すべて取ることができる(らしい)

# 0未満の値を取れるならNoである
# gを法として、Aと合同なXのうち、0以上の最小値は、
# A%gと表せるので、
# gを法として、Aと合同なXのうち、0未満の最大値は、
# (A%g)-gである
# [(C+1)-B,0)に(A%g)-gが含まれるならNoである

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def judge(A, B, C, D):
    """A:初期値,B:減少量,C以下で増加,D増加量"""
    if (B > A) or (B > D):
        # 減る
        # 初回購入できない/増加が追い付かない
        return False

    if B <= C:
        # 増える
        # C以下の値は一度に削りきらないと増加してしまうが、削り切れない
        return True

    # ループ
    # (C < B) and (B <= A) and (B <= D)
    g = gcd(B, D)
    a = A % g
    return a - g < C + 1 - B
    # ループ範囲は、C+1-B以上なので、
    # gを法として、Aと合同な値のうち、0未満で最大の値a-gが
    # C+1-B未満なら、ループ範囲に0未満の値は含まれず、無限にジュースを飲める


T = int(input())
for _ in range(T):
    bl = judge(*map(int, input().split()))
    print('Yes' if bl else 'No')
    