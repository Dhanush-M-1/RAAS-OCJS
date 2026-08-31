N = int(input())
cur = [('a', 0)]
for _ in range(N-1):
    new = []
    for s, c in cur:
        for i in range(c + 2):
            new.append((s + chr(ord('a') + i), max(i, c)))
    cur = new
for s, c in cur:
    print(s)