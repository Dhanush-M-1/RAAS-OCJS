n = int(input())

def chrinc(s,n):
  return chr(ord(s)+1)

def dfs(s,mx):
  if len(s) == n:
    print(s)
  else:
    c = 'a'
    while c <= mx:
      dfs(s+c, chrinc(mx,1) if c==mx else mx)
      c = chrinc(c,1)

dfs('','a')