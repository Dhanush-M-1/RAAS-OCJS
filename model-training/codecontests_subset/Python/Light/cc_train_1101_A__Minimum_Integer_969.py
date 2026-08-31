n = int(input())
for i in range(n):
    l, r, d = map(int, input().split())
    if l <= d <= r:
        print((r//d)*d + d)
    else:
        print(d)