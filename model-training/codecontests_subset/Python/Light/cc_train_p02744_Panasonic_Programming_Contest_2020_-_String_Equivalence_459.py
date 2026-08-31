n=int(input())
def dfs(s):
  if len(s)==n:
    print(s)
  else:
    for i in range(ord('a'),max(map(ord,list(s)))+2):
      dfs(s+chr(i))
dfs('a')