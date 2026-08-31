n = int(input())
trees = [list(map(int, input().split())) for _ in range(n)]
last_tree = trees[0][0]
cut = 1

for i in range(1, n):
    if trees[i][1] + last_tree >= trees[i][0]:
        if i + 1 != n:
            if trees[i + 1][1] + trees[i][0] > trees[i][0] and trees[i + 1][0] - trees[i][0] > trees[i][1]:
                cut += 1
                last_tree = trees[i][0] + trees[i][1]

            else:
                last_tree = trees[i][0]

        else:
            cut += 1

    else:
        last_tree = trees[i][0]
        cut += 1

print(cut)