N = int(input())
def dfs(ch, Ma):
    if len(ch) == N:
        print(ch)
        return
    for i in range(97, Ma+2):
        dfs(ch+chr(i), max(Ma, i))
dfs('a', 97)
