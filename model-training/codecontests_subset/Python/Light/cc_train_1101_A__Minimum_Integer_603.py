for _ in range(int(input())):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
    else:
        k = d * (r // d)
        while k <= r:
            k += d
        print(k)