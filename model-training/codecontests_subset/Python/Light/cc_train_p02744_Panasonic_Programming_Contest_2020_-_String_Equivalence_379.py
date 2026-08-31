def dfs(s,n):
    if len(s) == n:
        print(s)
    else:
        for i in range(len(set(s))+1):
            dfs(''.join([s,chr(97+i)]),n)

N = int(input())
dfs('a',N)