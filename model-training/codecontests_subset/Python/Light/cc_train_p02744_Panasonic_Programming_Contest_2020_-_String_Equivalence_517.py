C = 'abcdefghijklmnopqrstuvwxyz'
N = int(input())
def dfs(s):
  l = len(s)
  if l >= N:
    print(s)
    return
  for i in range(l+1):
    if len(set(s)) < i:
      continue
    dfs(s+C[i])
dfs('')