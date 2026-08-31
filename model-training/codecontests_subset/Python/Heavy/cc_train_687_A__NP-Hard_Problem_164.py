def a():
    _, d = (int(x) for x in input().split())
    curr_win_streak = 0
    max_win_streak = 0
    for _ in range(d):
        if '0' in input():
            curr_win_streak += 1
        else:
            curr_win_streak = 0
        max_win_streak = max(max_win_streak, curr_win_streak)
    print(max_win_streak)


def b():
    x = input()
    print(x + x[::-1])


def c():
    nodes_nr, edges_nr = (int(x) for x in input().split())
    node_idx___neigh_idxes = [[] for _ in range(nodes_nr + 1)]
    for _ in range(edges_nr):
        n1, n2 = (int(x) for x in input().split())
        node_idx___neigh_idxes[n1].append(n2)
        node_idx___neigh_idxes[n2].append(n1)

    node_idx___color = [-1 for _ in range(nodes_nr + 1)]
    for node_idx in range(1, nodes_nr + 1):
        if node_idx___color[node_idx] != -1:
            continue
        stack = [node_idx]
        node_idx___color[node_idx] = 0
        while stack:
            node = stack.pop()
            curr_color = node_idx___color[node]
            neigh_color = (node_idx___color[node] + 1) % 2
            for neigh in node_idx___neigh_idxes[node]:
                if node_idx___color[neigh] == curr_color:
                    print(-1)
                    return
                elif node_idx___color[neigh] == -1:
                    node_idx___color[neigh] = neigh_color
                    stack.append(neigh)

    print(node_idx___color.count(0))
    print(*[idx for idx, color in enumerate(node_idx___color) if color == 0])
    print(node_idx___color.count(1))
    print(*[idx for idx, color in enumerate(node_idx___color) if color == 1])


if __name__ == '__main__':
    c()
