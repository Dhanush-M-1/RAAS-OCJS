n, m = map(int, input().split())
a = set()
for i in range(n):
    for j in list(map(int, input().split()))[1:]:
        a.add(j)
print("YES" if len(a) == m else "NO")