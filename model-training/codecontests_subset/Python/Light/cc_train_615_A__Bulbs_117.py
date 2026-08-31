n, m = map(int, input().split())
bulbs = set()

for _ in range(n):
    bulbs |= set(list(map(int, input().split()))[1:])

print('YES' if len(bulbs) == m else 'NO')