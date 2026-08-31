abc = "abcdefghij"

N = int(input())

def dfs(S, i):
    if len(S) == N:
        return S + "\n"

    res = ""
    for c in abc[:i]:
        res += dfs(S + c, i)
    res += dfs(S + abc[i], i + 1)

    return res

print(dfs("", 0))