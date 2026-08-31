from collections import deque, OrderedDict


if __name__ == '__main__':
    n = int(input())
    tree_pos = []
    tree_len = []

    for i in range(n):
        x, h = map(int, input().split())
        tree_pos.append(x)
        tree_len.append(h)

    if n == 1:
        print(1)
        exit(0)
    current = 2
    prev = tree_pos[0]
    for i in range(1, n - 1):
        if tree_pos[i] - tree_len[i] > prev:
            current += 1
            prev = tree_pos[i]
        elif tree_pos[i] + tree_len[i] < tree_pos[i + 1]:
            current += 1
            prev = tree_pos[i] + tree_len[i]
        else:
            prev = tree_pos[i]

    # dp = sorted(dp, key=lambda k: k[0], reverse=True)
    print(current)




