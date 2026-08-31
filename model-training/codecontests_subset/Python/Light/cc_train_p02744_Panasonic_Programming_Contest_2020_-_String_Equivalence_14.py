import sys
sys.setrecursionlimit(10**7)
n = int(input())

def dfs(s, mx):
  if len(s) == n:
    print(s)
  else:
    for i in range(mx):
      dfs(s+chr(ord("a")+i), mx)
    dfs(s+chr(ord("a")+mx), mx+1)
    
dfs("a", 1)