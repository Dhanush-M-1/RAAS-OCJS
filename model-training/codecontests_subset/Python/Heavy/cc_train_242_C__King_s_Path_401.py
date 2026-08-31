# from collections import defaultdict
#
# def valid(point, adj):
#     # if point[0] not in adj.keys():
#     #     return False
#
#     for item in adj[point[0]]:
#         if point[1] in range(item[0], item[1] + 1):
#             return True
#
#     return False
#
# def neighbors(item):
#     out = []
#     out.append((item[0] - 1, item[1] - 1))
#     out.append((item[0] - 1, item[1]))
#     out.append((item[0] - 1, item[1] + 1))
#
#     out.append((item[0], item[1] - 1))
#     out.append((item[0], item[1] + 1))
#
#     out.append((item[0] + 1, item[1] - 1))
#     out.append((item[0] + 1, item[1]))
#     out.append((item[0] + 1, item[1] + 1))
#
#     return out
#
#
# def bfs(start, end, adj):
#     out = 0
#     visted = []
#     visted.append(start)
#     frontier = [start]
#
#     while len(frontier) != 0:
#         next = []
#         out += 1
#         for item in frontier:
#             n = neighbors(item)
#             for i in n:
#                 if i == end:
#                     return out
#                 if i not in visted:
#                     if valid(i, adj):
#                         next.append(i)
#                         visted.append(i)
#         frontier = next
#     return -1
#
#
# x_0, y_0, x_1, y_1 = list(map(int, input().split()))
#
# segments = defaultdict(list)
#
# n = int(input())
# for _ in range(n):
#     temp = list(map(int, input().split()))
#     segments[temp[0]].append((temp[1], temp[2]))
#
# print(bfs((x_0, y_0), (x_1, y_1), segments))

#print(segments)
#print(valid((6, 11), {5: [(3, 8), (2, 5)], 6: [(7, 11)]}))
# {5: [(3, 8), (2, 5)], 6: [(7, 11)]}

from collections import deque

x_0, y_0, x_1, y_1 = list(map(int, input().split()))

n = int(input())

g = {}

for _ in range(n):
    r, a, b = list(map(int, input().split()))
    # all the valid cols have value -1
    for i in range(a, b + 1):
        g[(r, i)] = -1

# level zero
g[(x_0, y_0)] = 0

q = deque([(x_0, y_0)])

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

while len(q) != 0:
    current = q.popleft()

    for i in range(8):
        neigbor = (current[0] + dx[i], current[1] + dy[i])
        if neigbor in g and g[neigbor] == -1:
            q.append(neigbor)
            g[neigbor] = g[current] + 1

        if neigbor == (x_1, y_1):
            break

print(g[(x_1, y_1)])


