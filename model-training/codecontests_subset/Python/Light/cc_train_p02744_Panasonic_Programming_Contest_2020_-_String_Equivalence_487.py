n=int(input())
def dfs(s,st):
  if len(s)==n:
    return print(s)
  else:
    for i in range(ord('a'),ord(st)+1):
      if i==ord(st):
        dfs(s+chr(i),chr(ord(st)+1))
      else:
        dfs(s+chr(i),chr(ord(st)))
dfs('','a')