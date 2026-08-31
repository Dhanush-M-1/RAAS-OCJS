n = int(input())

def dfs(s):
  if len(s) == n:
    print(s)
  else:
    for i in range(ord(max(s)) - ord('a') + 2):
      dfs(s + chr(i + ord('a')))
      
s = 'a'
dfs(s)