n = int(input())


def dfs(s, mx):
    if len(s) == n:
        print(''.join([chr(ord('a') + i) for i in s]))
    else:
        for i in range(mx+1):
            dfs(s + [i], mx if i != mx else mx + 1)


dfs([], 0)
