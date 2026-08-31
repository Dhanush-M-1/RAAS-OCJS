from collections import Counter
N = int(input())

def dfs(s):
    l = len(Counter(list(s)))
    if len(s) == N:
        print(s)
    else:
        for i in range(l+1):
            dfs(s+chr(i+97))
    return 
dfs("a")