t="abcdefghijklmnopqrstuvwxyz"
n=int(input())
ans=[]
def dfs(s):
  global ans
  if len(s)==n:
    ans.append(s)
    return 
  for i in range(len(set(s))+1):dfs(s+t[i])
  return
dfs("")
ans.sort()
for i in ans:print(i)