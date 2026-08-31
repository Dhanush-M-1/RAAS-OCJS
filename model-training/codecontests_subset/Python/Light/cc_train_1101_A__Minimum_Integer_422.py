for i in range(int(input())):
    l, r, d = map(int, input().split())
    if l <= d <= r:
        print((r // d + 1)*d)
    else:
        print(d)
