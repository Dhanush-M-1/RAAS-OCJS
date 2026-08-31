n = int(input())
def dfs(x):
    if len(x) == n:
        print(''.join(map(lambda i: chr(ord('a') + i - 1), x)))
        return
    for i in range(max(x)+1):
        y = x.copy()
        y.append(i+1)
        dfs(y)
dfs([1])

