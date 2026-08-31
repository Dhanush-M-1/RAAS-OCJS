n = int(input())

x, h = map(int, input().split())
a = [[[x, 1], [x, 0], [x+h, 1]]]

for i in range(1, n):
    x, h = map(int, input().split())

    tree = [[-1, -1] for j in range(3)]
    
    left_i = x-h
    if a[-1][0][0] >= left_i:
        tree[0] = [x, -1]
    else:
        tree[0] = [x, max(a[-1][0][1], a[-1][1][1]) + 1]
    if a[-1][2][0] < left_i:
        tree[0] = [x, max(tree[0][1], a[-1][2][1]+1)]

    tree[1] = [x, max(a[-1][0][1], a[-1][1][1])]
    tree[2] = [x+h, tree[1][1]+1]
    if a[-1][2][0] < x:
        tree[1] = [x, max(tree[1][1], a[-1][2][1])]
        tree[2] = [x+h, tree[1][1]+1]

    a.append(tree)

print(max(a[-1][0][1], a[-1][1][1], a[-1][2][1]))