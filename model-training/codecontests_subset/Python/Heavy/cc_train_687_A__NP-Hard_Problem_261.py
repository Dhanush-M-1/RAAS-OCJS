n, m = map(int, input().split())
colors = [0] * n
edges = [[] for x in range(n)]
visited = 0
root = 0
stack = []
isPossible = True

for x in range(m):
    i, j = map(int, input().split())
    edges[i - 1].append(j - 1)
    edges[j - 1].append(i - 1)

while visited < n or len(stack) > 0:
    if len(stack) == 0:
        while colors[root] > 0:
            root += 1
        stack.append((root, 1))
    current, color = stack.pop()
    #print(current, color, *stack)

    if colors[current] == color:
        continue
    elif colors[current] > 0:
        isPossible = False
        break

    visited += 1
    colors[current] = color
    color = 3 - color

    for neigh in edges[current]:
        stack.append((neigh, color))

if not isPossible:
    print(-1)
else:
    l = [[], []]
    for i in range(n):
        l[colors[i] - 1].append(i + 1)
    print(len(l[0]))
    print(*l[0])
    print(len(l[1]))
    print(*l[1])
