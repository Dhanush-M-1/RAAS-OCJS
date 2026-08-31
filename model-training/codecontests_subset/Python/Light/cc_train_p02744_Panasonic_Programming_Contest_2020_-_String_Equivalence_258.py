n = int(input())


def dfs(s, mx):
    if len(s) == n:
        print(s)
        return

    for c in range(ord('a'), mx + 1 + 1):
        dfs(s + chr(c), max(mx, c))


dfs("", ord('a') - 1)
