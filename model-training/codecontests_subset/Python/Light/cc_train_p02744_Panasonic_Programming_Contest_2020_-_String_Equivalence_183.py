abc = "abcdefghij"

N = int(input())

def dfs(S, i):
    if len(S) == N:
        return S

    return "\n".join([dfs(S + c, i) for c in abc[:i]] + [dfs(S + abc[i], i + 1)])

print(dfs("a", 1))