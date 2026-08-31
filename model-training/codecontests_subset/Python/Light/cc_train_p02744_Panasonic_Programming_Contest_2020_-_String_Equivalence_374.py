N = int(input())

def dfs(s, mx):
  if len(s) == N:
    print(s)
  else:
    for i in range(ord('a'), ord(mx)+1):
      dfs(s+chr(i), chr(ord(mx)+1) if chr(i) == mx else mx)
      
dfs('', 'a')