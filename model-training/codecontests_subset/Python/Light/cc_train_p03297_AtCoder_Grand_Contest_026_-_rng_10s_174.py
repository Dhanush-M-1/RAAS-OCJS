import sys
from fractions import gcd

sr = lambda: sys.stdin.readline().rstrip()
ir = lambda: int(sr())
lr = lambda: list(map(int, sr().split()))

T = ir()

def check(a, b, c, d):
    if a < b or d < b:
        answer = 'No'
    # 以降 d >= b とする
    elif c >= b:
        answer = 'Yes'
    else:
        a %= b; d %= b
        # c < x < b の間に個数が入ると'No'
        g = gcd(b, d)
        if b - g + (a % g) > c:
            answer = 'No'
        else:
            answer = 'Yes'
    print(answer)

for _ in range(T):
    check(*lr())

# 16