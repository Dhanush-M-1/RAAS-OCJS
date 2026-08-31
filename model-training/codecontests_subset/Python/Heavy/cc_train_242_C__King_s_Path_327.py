x0, y0, x1, y1 = map(int, input().split())
n = int(input())

graph = set()
visited = set()

for i in range(n):
    row, start, end = map(int, input().split())
    for col in range(start, end+1):
        graph.add((row, col))
dirs = ((0,1), (0,-1), (1, 0), (-1, 0), (1,1), (1,-1), (-1, 1), (-1, -1))

frontier = [(x0, y0)]
i = 0
while frontier:
    level = []
    for x, y in frontier: 
        if (x, y) == (x1, y1):
            print(i)
            exit()
        for dx, dy in dirs:
            if (x+dx, y+dy) in graph and (x+dx, y+dy) not in visited:
                visited.add((x+dx,y+dy))
                level.append((x+dx,y+dy))
    frontier = level
    i += 1
print(-1)
