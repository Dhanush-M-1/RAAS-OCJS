import sys
input = sys.stdin.readline
def gcd(a, b):
    while b: a, b = b, a % b
    return a

N = int(input())
S = 0
Y = []
for i in range(N):
    a, b = map(int, input().split())
    if b > a:
        S += b-a
        Y.append((b, b, b-a, 0))
    else:
        Y.append((a, b, 0, a-b))

Y = sorted(Y)
YY = [0] * (N+1)
for i in range(N):
    YY[i+1] = YY[i] + Y[i][0]

def f(i, n):
    if Y[i][2]:
        return S - YY[n] if n <= i else S - (YY[n+1] - Y[i][0])
    return S - Y[i][3] - YY[n] if n <= i else S - Y[i][3] - (YY[n+1] - Y[i][0])

maa, mab = 0, 1
for i in range(N):
    l = 0
    r = N
    while r - l > 1:
        m = (l+r) // 2
        if f(i, m) >= 0:
            l = m
        else:
            r = m

    a = l * Y[i][1] + min(f(i, l), Y[i][1])
    b = N * Y[i][1]
    if a * mab > b * maa:
        maa, mab = a, b

g = gcd(maa, mab)
print(maa//g, mab//g)