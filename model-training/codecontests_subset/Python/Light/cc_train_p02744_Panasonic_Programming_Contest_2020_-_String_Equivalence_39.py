N=int(input())
ABC=["a","b","c","d","e","f","g","h","i","j"]
def dfs(n,s):
  if len(s)==N:
    print(s)
    return
  
  for i in range(n+1):
    _s=s+ABC[i]
    dfs(max(n,i+1),_s)
    
dfs(0,"")