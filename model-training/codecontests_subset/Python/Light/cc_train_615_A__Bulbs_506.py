n, m = map(int, input().split())
res = set.union(*(set(map(int, input().split()[1:])) for _ in range(n)))
print("YES" if len(res) == m else "NO")