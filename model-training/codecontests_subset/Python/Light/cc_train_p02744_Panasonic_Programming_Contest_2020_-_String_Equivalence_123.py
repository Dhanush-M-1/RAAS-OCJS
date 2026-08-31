N = int(input())
strlist = 'abcdefghij'

ans = [['a']]
for i in range(1, N):
  ans.append([])
  for s in ans[i-1]:
    n = ord(max(s)) - 96
    for j in range(n+1):
      ans[i].append(s+strlist[j])

print(*ans[-1], sep='\n')