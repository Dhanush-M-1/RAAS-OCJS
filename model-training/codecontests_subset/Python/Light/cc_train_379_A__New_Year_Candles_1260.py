def solve():
    a, b = [int(x) for x in input().split()]
    res = a
    while a//b > 0:
        extra = a % b
        a = a//b
        res += a
        a += extra
    print(res)
    return

solve()