n = int(input())
c = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']


def dfs(k, s):
    if len(s) == n:
        print(s)
        return
    for i in range(k):
        dfs(k, s+c[i])
    dfs(k + 1, s + c[k])


dfs(1, 'a')