from sys import stdin

input = iter(stdin.readlines()).__next__

n = int(input())
trees = [tuple(map(int, input().split())) for _ in range(n)]

if len(trees) == 1:
    count = 1
else:
    count = 2
    last_covered = trees[0][0]
    for index, (pos, height) in enumerate(trees[1:-1], start = 1):
        if pos - height > last_covered:
            last_covered = pos
            count += 1
        elif pos + height < trees[index + 1][0]:
            last_covered = pos + height
            count += 1
        else:
            last_covered = pos
print(count)
