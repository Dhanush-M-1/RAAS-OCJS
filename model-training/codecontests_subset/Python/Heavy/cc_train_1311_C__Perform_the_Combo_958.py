import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
  n,m = map(int,input().split())
  raw = input()
  for i in range(n):
    if i == 0:
      dp = [[0 for _ in range(26)]]
      dp[0][ord(raw[i])-97] = 1
      continue
    tmp = dp[-1][:]
    tmp[ord(raw[i])-97] += 1
    dp.append(tmp)
  #for x in dp:
    #print(x)
  p = list(map(int,input().split()))
  ans = [0 for _ in range(26)]
  for x in p:
    x -= 1
    for d in range(26):
      ans[d] += dp[x][d]
  for d in range(26):
    ans[d] += dp[-1][d]
  print(' '.join(list(map(str,ans))))