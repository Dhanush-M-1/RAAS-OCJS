n=int(input())

abc='abcdefghij'

def dfs(s):
  if len(s)==n:
    print(s)
    return

  st_l=len(set(s))
  for i in range(st_l+1):
    dfs(s+abc[i])

dfs('a')