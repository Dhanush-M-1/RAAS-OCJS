def dfs(S):
    if len(S) == N:
        ans.append(S)
    else:
        for c in range(max(S) + 2):
            dfs(S + [c])


N = int(input())
ans = []
dfs([0])
for li in ans:
    print("".join(chr(c + ord("a")) for c in li))
