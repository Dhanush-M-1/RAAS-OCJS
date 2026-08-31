n = int(input())
v = 'abcdefghijk'

w = []
def dfs(s,t):
  if len(s) == n:
    w.append(s)
    return
  u = len(set(s))
  for i in range(u+1):
    dfs(s+v[i],u+1)

dfs('a',1)

for i in w:
  print (i)