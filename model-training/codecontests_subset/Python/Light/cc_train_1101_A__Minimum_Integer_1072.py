n = int(input())

for _ in range(n):
    l, r, d = map(int, input().split())
    if d < l or d > r:
        print(d)
    else:
        print((r//d + 1) * d)