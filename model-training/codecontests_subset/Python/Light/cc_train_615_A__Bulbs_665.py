def I(): return map(int, input().split())


n, m = I()
a = {}
for _ in range(n):
    a = set(a).union(set(list(I())[1:]))

print("YNEOS"[set(a) != set(range(1, m+1))::2])
