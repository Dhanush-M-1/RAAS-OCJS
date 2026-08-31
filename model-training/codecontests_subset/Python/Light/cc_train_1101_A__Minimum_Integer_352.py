n = int(input())
for i in range(n):
    l, r, d = map(int, input().split())
    if l <= d:
        print((r // d + 1) * d)
    else:
        print(d)