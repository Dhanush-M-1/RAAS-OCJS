N = int(input())

def dfs(s, mx):
  global N
  if len(s) == N:
    print(s)
  else:
    for i in range(ord(mx) - ord('a') + 1):
      dfs(s + chr(ord('a') + i), chr(ord(mx) + 1) if chr(ord('a') + i) == mx else mx)

dfs('', 'a')