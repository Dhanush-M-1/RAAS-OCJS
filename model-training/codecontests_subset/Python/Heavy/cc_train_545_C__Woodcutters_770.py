n = int(input())

tree_pos = []
tree_height = []
tree_falls_in = []
fallen_trees = 0

for t in range(n):
    pos, height = map(int,input().strip().split())
    tree_pos.append(pos)
    tree_height.append(height)
    tree_falls_in.append(pos)

tree_falls_in[0] = tree_pos[0] - tree_height[0]
fallen_trees += 1

for t in range(1, n):
    if tree_pos[t] - tree_height[t] > max(tree_pos[t - 1], tree_falls_in[t - 1]):
        tree_falls_in[t] = tree_pos[t] - tree_height[t]
        fallen_trees += 1
    elif t == n - 1:
        fallen_trees += 1
    elif tree_pos[t] + tree_height[t] < tree_pos[t + 1]:
        tree_falls_in[t] = tree_pos[t] + tree_height[t]
        fallen_trees += 1

print(fallen_trees)