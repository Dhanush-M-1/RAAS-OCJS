def solve(l, r, d):
    if d < l:
        return d
    elif (l - (l % d) > 0) and l % d != 0:
        return l - (l % d)
    else:
        return (int(r/d) + 1) * d


x = int(input())

while x > 0:
    [l, r, d] = list(map(int, input().split()))
    print(solve(l, r, d))
    x -= 1
