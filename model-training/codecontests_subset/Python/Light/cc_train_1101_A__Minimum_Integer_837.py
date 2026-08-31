def solve(l, r, d):
    if d < l:
        return d
    else:
        return (r//d + 1) * d


x = int(input())

while x > 0:
    [l, r, d] = list(map(int, input().split()))
    print(solve(l, r, d))
    x -= 1
