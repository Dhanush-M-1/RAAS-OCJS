N = int(input())

def dfs(ans, MAX):
    if len(ans) == N:
        print(ans)
        return
    for i in range(MAX-95):
        dfs(ans + chr(97+i), max(MAX, 97+i))

dfs('a', 97)