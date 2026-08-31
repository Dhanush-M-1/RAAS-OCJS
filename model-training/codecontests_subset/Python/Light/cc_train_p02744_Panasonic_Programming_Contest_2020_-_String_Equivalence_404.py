n = int(input())

def dfs(s, cn):
    if len(s) == n:
        print(s)
    else:
        for i in range(0, cn + 1):
            c = chr(ord('a') + i)
            if i == cn: dfs(s+c, cn+1)
            else: dfs(s+c, cn)

dfs('', 0)