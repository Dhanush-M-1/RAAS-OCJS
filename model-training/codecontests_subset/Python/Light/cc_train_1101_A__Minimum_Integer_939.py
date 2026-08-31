for _ in range(int(input())):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
    elif r % d:
        print(r // d * d + d)
    else:
        print(r + d)