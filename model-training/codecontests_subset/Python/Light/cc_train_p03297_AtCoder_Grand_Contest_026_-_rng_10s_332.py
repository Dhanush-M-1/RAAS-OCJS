def makelist(n, m):
    return [[0 for _ in range(m)] for _ in range(n)]

def gcd(a, b):  # a >= b
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


T = int(input())

for turn in range(1, T+1):
    init, sell, base, add = map(int, input().split())

    hoge = gcd(sell, add)

    ans = "Yes"
    if init < sell or sell > add:
        ans = "No"
    elif base+hoge >= sell:
        if init % sell > base:
            ans = "No"
    else:
        ans = "No"

    print(ans)
