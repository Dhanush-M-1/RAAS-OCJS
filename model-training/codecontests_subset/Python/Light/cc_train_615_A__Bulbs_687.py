n, m = map(int, input().split())
a = list([False for _ in range(m)])
for i in range(n):
    lamps = list(map(int, input().split(' ')))[1:]
    for lamp in lamps:
        a[lamp - 1] = True

print("YES" if a.count(True) == m else "NO")
