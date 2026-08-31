N = int(input())
s = 'abcdefghij'

def dfs(word, n):
    if len(word)==N:
        print(word)
    else:
        for i in range(n+1):
            dfs(word+s[i], n+1 if i==n else n)
dfs('a', 1)