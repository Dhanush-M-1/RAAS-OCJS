N = int(input())
strlist = 'abcdefghij'

def dfs(s, i):
  if len(s) == N:
    print(s)
  else:
    for j in range(i+1):
      t = s + strlist[j]
      if j == i:
        dfs(t, i+1)
      else:
        dfs(t, i)

dfs('', 0)