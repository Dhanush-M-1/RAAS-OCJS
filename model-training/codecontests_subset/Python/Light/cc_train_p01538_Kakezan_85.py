def solve(dic, cnt, n):
  if n < 10:
    return cnt

  if n in dic:
    return -1

  dic[n] = True

  s = str(n)
  max_score = 0
  for i in range(1, len(s)):
    a, b = int(s[:i]), int(s[i:])
    max_score = max(max_score, a * b)

  return solve(dic, cnt + 1, max_score)

q = int(input())
for _ in range(q):
  dic = dict()
  print(solve(dic, 0, int(input())))
