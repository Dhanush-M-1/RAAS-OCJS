N = int(input())
def dfs(s):
  if len(s) == N:
    print(s)
    return
  else:
    for i in range(ord("a"), ord("z")+1):
      if max(list(s)) != chr(i-2):
        dfs(s+chr(i))
      else:
        return
dfs("a")