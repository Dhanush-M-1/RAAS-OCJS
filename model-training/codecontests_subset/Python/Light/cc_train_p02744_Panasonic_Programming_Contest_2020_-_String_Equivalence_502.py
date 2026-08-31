n=int(input())

def dfs(s,mx):
  #print("s",s)
  if len(s)==n:
    print(s)
    return
  for i in range(ord("a"),mx+2):
    #print(i)
    #print(s+chr(i))
    dfs(s+chr(i),max(mx,i))

dfs("a",ord("a"))
