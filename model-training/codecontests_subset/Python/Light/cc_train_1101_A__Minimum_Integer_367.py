for _ in range(int(input())):
    l, r, d = map(int, input().split())
    print((r + d) // d * d if l <= d else d)