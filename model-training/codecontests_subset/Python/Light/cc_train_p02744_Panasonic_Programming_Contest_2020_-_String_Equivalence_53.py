N = int(input())
def dfs(s):
  if len(s) == N:
    print(s)
    return
  for i in range(ord("a"), ord("z")+1):
    dfs(s+chr(i))
    if max(list(s)) == chr(i-1):
      return
dfs("a")