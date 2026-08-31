for _ in range(int(input())):
    l, r, d = map(int, input().split())

    if r % d == 0:
        num = r + d
    else:
        num = (r // d + 1) * d

    if d < l:
        num = min(num, d)

    print(num)