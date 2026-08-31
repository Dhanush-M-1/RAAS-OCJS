n = int(input())
trees = [list(map(int, input().split())) for _ in range(n)]
timber = min(n, 2)

for i in range(1, n - 1):
    if trees[i][0] - trees[i][1] > trees[i - 1][0]:
        timber += 1
    elif trees[i][0] + trees[i][1] < trees[i + 1][0]:
        timber, trees[i][0] = timber + 1, trees[i][0] + trees[i][1]

print(timber)