def dfs(s,mx):
  if len(s)==n:
    print(s)
    return
  for c in range(ord("a"),ord(mx)+1):
    dfs(s+chr(c),chr(ord(mx)+1) if ord(mx)==c else mx)

n=int(input())
dfs("","a")