N = int(input())
def dfs(s):
  if len(s) == N:
    print(s)
    return
  for i in "abcdefghijklmnopqrstuvwxyz":
    dfs(s+i)
    if max(list(s)) == chr(ord(i)-1):
      return
dfs("a")