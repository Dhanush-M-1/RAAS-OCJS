def solve():
    n = int(input())
    num = [int(x) for x in input().split()]
    max_v = 10 ** 6
    min_v = 1
    l = min_v
    r = max_v

    for x in num:
        if x <= max_v / 2:
            l = x
        else:
            r = x
            break

    l = l - min_v
    r = max_v - r
    print(max(l, r))


solve()