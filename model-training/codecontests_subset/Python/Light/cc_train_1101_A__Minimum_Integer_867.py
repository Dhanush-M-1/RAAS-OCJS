n = int(input())

for i in range(n):
    l, r, d = map(int, input().split())
    ld = (l + d - 1) // d
    rd = r // d
    if ld > 1:
        print(d)
    else:
        print((rd + 1) * d)

