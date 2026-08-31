for i in [0] * int(input()):
    l, r, d = map(int, input().split())
    print(d if l > d else (r // d + 1) * d)
