import sys

input = sys.stdin.readline
print = sys.stdout.write


def get_input():
    n, m = [int(x) for x in input().split(' ')]

    graph = [[] for _ in range(n + 1)]
    for _ in range(m):
        c1, c2 = [int(x) for x in input().split(' ')]
        graph[c1].append(c2)
        graph[c2].append(c1)

    if m % 2 != 0:
        print("No solution")
        exit(0)

    return graph


def dfs(graph):
    n = len(graph)
    w = [0] * n
    pi = [None] * n
    visited = [False] * n
    finished = [False] * n
    adjacency = [[] for _ in range(n)]

    stack = [1]
    while stack:
        current_node = stack[-1]

        if visited[current_node]:
            stack.pop()
            if finished[current_node]:
                w[current_node] = 0
                continue

            # print(current_node, adjacency[current_node])
            finished[current_node] = True
            unpair = []
            for adj in adjacency[current_node]:
                if w[adj] == 0:
                    # print('unpaired ->', adj, w[adj])
                    unpair.append(adj)
                else:
                    print(' '.join([str(current_node), str(adj), str(w[adj]), '\n']))
            
            while len(unpair) > 1:
                print(' '.join([str(unpair.pop()), str(current_node), str(unpair.pop()), '\n']))
            w[current_node] = unpair.pop() if unpair else 0            
            continue

        visited[current_node] = True
        not_blocked_neighbors = [x for x in graph[current_node] if not visited[x]]
        stack += not_blocked_neighbors
        adjacency[current_node] = not_blocked_neighbors
        # print('stack:', stack, current_node)


# def recursive_dfs(graph):
#     n = len(graph)
#     visited = [False] * n
#     recursive_dfs_visit(graph, 1, visited)


# def recursive_dfs_visit(graph, root, visited):    
#     unpair = []
#     visited[root] = True
#     adjacency = [x for x in graph[root] if not visited[x]]
#     for adj in adjacency:
#         w = recursive_dfs_visit(graph, adj, visited)
#         if w == 0:
#             unpair.append(adj)
#         else:
#             print(' '.join([str(root), str(adj), str(w), '\n']))

#     while len(unpair) > 1:
#         print(' '.join([str(unpair.pop()), str(root), str(unpair.pop()), '\n']))
    
#     if unpair:
#         return unpair.pop()
#     return 0


if __name__ == "__main__":
    graph = get_input()
    dfs(graph)
