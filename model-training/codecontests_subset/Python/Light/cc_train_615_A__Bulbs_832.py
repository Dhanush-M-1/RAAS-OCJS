n, m = map(int, input().split())
a = set()
for i in range(n):
    elems = list(map(int, input().split()))
    for j in range(1, elems[0] + 1):
        a.add(elems[j])
print("YES" if len(a) == m else "NO")
