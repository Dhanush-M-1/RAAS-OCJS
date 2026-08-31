n = int(input())
v = 'abcdefghij'
def dfs(s):
  if len(s) == n:
    print (s)
    return
  for i in range(len(set(s))+1):
    dfs(s+v[i])
dfs('a')