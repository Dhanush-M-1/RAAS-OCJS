n, m = map(int, input().split())
a = set()
for i in range(n):
    elems = list(map(int, input().split()))
    for elem in elems[1:]:
        a.add(elem)
print("YES" if len(a) == m else "NO")
