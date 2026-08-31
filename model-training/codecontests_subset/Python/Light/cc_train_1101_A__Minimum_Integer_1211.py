n = int(input())

for _ in range(n):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
    else:
        print(d - r % d + r)
