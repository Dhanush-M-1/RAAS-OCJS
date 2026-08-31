import sys


input = sys.stdin.readline
n = int(input())
a = [list(map(int, input().split())) for i in range(n-1)]
tree = [[] for i in range(n)]

for i in range(n - 1):
    tree[a[i][0] - 1].append(a[i][1] - 1)
    tree[a[i][1] - 1].append(a[i][0] - 1)

for i in range(n):
    if len(tree[i]) == 2:
        print("NO")
        exit()
print("YES")

