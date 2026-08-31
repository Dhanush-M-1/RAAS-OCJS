n = int(input())
trees = []

for _ in range(n):
    x, h = map(int, input().split())
    trees.append([x, h])

count = 2
for i in range(1, n - 1):
    if trees[i][1] < trees[i][0] - trees[i - 1][0]:
        count += 1
    elif trees[i][1] < trees[i + 1][0] - trees[i][0]:
        count += 1
        trees[i][0] += trees[i][1]

print(count if len(trees) > 1 else 1)
