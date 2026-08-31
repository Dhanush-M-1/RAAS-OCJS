INF = 10000000001
def fill(s):
  s.insert(0, -INF)
  s.append(INF)
  i = 0
  for j in filter(lambda x: s[x] != '?', range(1, len(s))):
    d = i - j
    s[j] = int(s[j])
    if s[i] > s[j]+d:
      raise
    a = max(min(d//2, s[j]+d), s[i])
    for t in range(i+1, j):
      s[t] = a + t - i
    i = j
  return s[1:-1]
n, k = map(int, input().split())
s = input().split()
try:
  g = [fill([s[i] for i in range(j, n, k)]) for j in range(k)]
  print(' '.join(str(g[i%k][i//k]) for i in range(n)))
except:
  print('Incorrect sequence')
