N = int(input())

A = [chr(ord("a") + i) for i in range(26)]


def dfs(S, i):
    if len(S) == N:
        print(S)
        return
    for j in range(i):
        dfs(S + A[j], i)
    dfs(S + A[i], i + 1)


dfs("", 0)
