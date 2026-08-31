n = int(input())
for i in range(n):
    l, r, d = tuple(map(int, input().split()))
    if l > d:
        print(d)
    else:
        x = (r//d + 1) * d
        print(x)

