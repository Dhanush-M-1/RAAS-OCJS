def successors(pos):
    x, y = pos
    nextMoves = []
    if (x - 1, y) in allowed:
        nextMoves.append((x - 1, y))
    if (x + 1, y) in allowed:
        nextMoves.append((x + 1, y))
    if (x, y - 1) in allowed:
        nextMoves.append((x, y - 1))
    if (x, y + 1) in allowed:
        nextMoves.append((x, y + 1))

    if (x - 1, y - 1) in allowed:
        nextMoves.append((x - 1, y - 1))
    if (x - 1, y + 1) in allowed:
        nextMoves.append((x - 1, y + 1))
    if (x + 1, y - 1) in allowed:
        nextMoves.append((x + 1, y - 1))
    if (x + 1, y + 1) in allowed:
        nextMoves.append((x + 1, y + 1))

    return nextMoves


def BFS(start, end):
    explored = {}
    if start == end:
        return 0
    frontier = [start]
    explored[start] = 1
    h = 1
    while frontier:
        nextLevel = []
        for curPos in frontier:
            for x, y in successors(curPos):
                if (x, y) not in explored:
                    explored[(x, y)] = 1
                    if (x, y) == end:
                        return h
                    nextLevel.append((x, y))
        frontier = nextLevel
        h += 1
    return -1


allowed = {}
inp = str(input()).split(" ")
x0 = int(inp[0])
y0 = int(inp[1])
x1 = int(inp[2])
y1 = int(inp[3])

segs = int(input())
for _ in range(segs):
    inp = [int(i) for i in str(input()).split(" ")]
    for x in range(inp[1], inp[2] + 1):
        allowed[(inp[0], x)] = 1

print(BFS((x0, y0), (x1, y1)))
