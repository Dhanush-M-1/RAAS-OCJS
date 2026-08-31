n = int(input())


def dfs(s, mx):
    if len(s) == n:
        print(s)
        return
    for i in range(ord('a'), ord(mx) + 2):
        dfs(s + chr(i), max(mx, chr(i)))


dfs('a', 'a')
