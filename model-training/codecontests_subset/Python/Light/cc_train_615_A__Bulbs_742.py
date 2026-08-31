n, m = map(int, input().split())
l = [False] * m
for _ in range(n):
    for i in map(int, input().split()[1:]):
        l[i - 1] = True
print("YES" if all(l) else "NO")
