# 拡張ユークリッド互除法
# ax + by = gcd(a,b)の最小整数解を返す
def egcd(a, b):
    if a == 0:
        return b, 0, 1
    else:
        g, y, x = egcd(b % a, a)
        return g, x - (b // a) * y, y

T = int(input())
for _ in range(T):
    A, B, C, D = map(int, input().split())
    if D < B or A < B:
        print("No")
    else:
        g = egcd(B, D)[0]
        mA = A % g
        mC = C % g
        k = C + (mA - mC if mA - mC > 0 else mA - mC + g)
        k -= B
        if k >= 0:
            print("Yes")
        else:
            print("No")
