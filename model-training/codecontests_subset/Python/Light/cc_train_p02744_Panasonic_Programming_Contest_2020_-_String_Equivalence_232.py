n = int(input())

def dfs(N, s, c):
    if N == n:
        s = "".join([chr(int(i) + 97) for i in s])
        print(s)

    else:
        for i in range(c+1):
            dfs(N + 1, s+str(i), c+1 if i == c else c)

dfs(0, "", 0)