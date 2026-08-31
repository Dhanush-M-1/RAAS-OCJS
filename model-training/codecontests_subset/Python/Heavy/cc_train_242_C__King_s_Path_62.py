x0, y0, x1, y1 = map(int, input().split())
n = int(input())

valid = set()
for _ in range(n):
    r, a, b = map(int, input().split())
    for x in range(a, b + 1):
        valid.add((r, x))

visited, moves, neighbors = {(x0, y0)}, 0, [(x0, y0)]
while neighbors:
    current, neighbors = neighbors, []
    for x, y in current:
        if (x, y) == (x1, y1):
            print(moves)
            exit()
        else:
            for p, q in (x + 1, y), (x, y + 1), (x + 1, y + 1), (x - 1, y), (x, y - 1), (x - 1, y - 1), (
            x - 1, y + 1), (x + 1, y - 1):
                if (p, q) in valid and (p, q) not in visited:
                    neighbors.append((p, q))
                    visited.add((p, q))
    moves += 1

print(-1)
