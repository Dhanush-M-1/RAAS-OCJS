N = int(input())
from string import ascii_letters

def dfs(s, mx):
    if len(s) == N:
        print(s)
    else:
        for i, c in enumerate(ascii_letters[:mx]):
            dfs(s + c, mx + 1 if i + 1 == mx else mx)

dfs("", 1)