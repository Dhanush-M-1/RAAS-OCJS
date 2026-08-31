import sys

def dfs(array, cnt):
    if len(array) == 1:
        idx = a.index(array[0])
        depth[idx] = cnt
        return

    value = max(array)

    depth_idx = a.index(value)
    depth[depth_idx] = cnt

    idx = array.index(value)
    left = array[:idx]
    right = array[idx + 1:]

    if len(left) > 0:
        dfs(left, cnt + 1)
    if len(right) > 0:
        dfs(right, cnt + 1)


t = int(sys.stdin.readline())
for i in range(t):
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split()))
    depth = [-1] * len(a)

    dfs(a, 0)

    for item in depth:
        print(item, end=" ")