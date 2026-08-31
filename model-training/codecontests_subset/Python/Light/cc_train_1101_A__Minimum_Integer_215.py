q = int(input())
while q:
    [l, r, d] = list(map(int, input().split()))
    minimum = 0
    if d <= l - 1:
        minimum = d
    elif d <= r:
        minimum = (r // d + 1) * d
    else:
        minimum = d
    print(minimum)
    q -= 1
