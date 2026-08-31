from sys import stdin

N = int(stdin.readline().rstrip())
trees = [None for n in range(N)]
for n in range(N):
    trees[n] = [int(x) for x in stdin.readline().rstrip().split()]
start = -1000000000
count = 1
for n in range(N - 1):
    tree = trees[n]
    if tree[0] - tree[1] > start:
        count += 1
        start = tree[0]
    elif tree[0] + tree[1] < trees[n+1][0]:
        count += 1
        start = tree[0] + tree[1]
    else:
        start = tree[0]
print(count)