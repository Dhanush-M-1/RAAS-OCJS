N = int(input())
def dfs(s):
  if len(s) == N:
    print(s)
    return
  else:
    for i in range(ord("a"), ord("z")+1):
      if i < ord(max(list(s)))+2:
        dfs(s+chr(i))
      else:
        return
dfs("a")