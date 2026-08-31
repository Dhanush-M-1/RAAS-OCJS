
N = int(input())
def dfs(s, l, char_num):
    if l == N:
        print(s)
    else:
        for i in range(char_num+1):
            ns = s+chr(97+i)
            dfs(ns, l+1, len(set(ns)))

dfs('a',1, 1)
