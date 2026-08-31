TC = int(input())

for T in range(TC):
    l, r, d = map(int, input().split())
    res = d
    if l <= res <= r:
        res = (r // d + 1) * d
    print(res)
