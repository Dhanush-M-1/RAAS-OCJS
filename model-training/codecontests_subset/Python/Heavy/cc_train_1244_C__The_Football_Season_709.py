def ExtendedEuklid(A, B, C):
    if B != 0:
        res1, res2 = ExtendedEuklid(B, A % B, C)
        x = res2
        y = res1 - A // B * res2
    else:
        x = C // A
        y = 0
    return x, y


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


[n, p, w, d] = map(int, input().split(' '))
res1, res2 = ExtendedEuklid(w, d, p)
if w * res1 + d * res2 != p:
    print(-1)
    quit()
if res1 < 0:
    q = d // gcd(w, d)
    m = (abs(res1) + q - 1) // q
    res1 += m * q
    res2 -= w // gcd(w, d) * m
if res2 < 0:
    q = w // gcd(w, d)
    m = (abs(res2) + q - 1) // q
    res2 += m * q
    res1 -= d // gcd(w, d) * m
if res1 < 0 or res2 < 0:
    print(-1)
    quit()
if res1 + res2 > n:
    one_diff = (w // gcd(w, d) - d // gcd(w, d))
    steps = (res1 + res2 - n + one_diff - 1) // one_diff
    res1 += d // gcd(w, d) * steps
    res2 -= w // gcd(w, d) * steps
if res1 < 0 or res2 < 0:
    print(-1)
    quit()
print(res1, res2, n - res1 - res2)
