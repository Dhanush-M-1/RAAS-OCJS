n, m = map(int, input().split())
a = list(range(m))
for i in range(n):
    for elem in [e - 1 for e in list(map(int, input().split(' ')))[1:]]:
        a[elem] = -1

print("YES" if a.count(-1) == m else "NO")
