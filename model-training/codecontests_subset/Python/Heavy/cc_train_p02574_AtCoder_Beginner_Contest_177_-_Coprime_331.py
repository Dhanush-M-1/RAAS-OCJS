N = 1000001
 
spf = [*range(N)]
i = 2
while i * i < N:
  if spf[i] == i:
    for j in range(i * i, N, i):
      if spf[j] == j:
        spf[j] = i
  i += 1
  
r = 'pairwise'
n = int(input())
a = [int(x) for x in input().split() if x > '1']
if len(a) > 1:
  u = set()
  i = None
  for x in a:
    s = set()
    while x > 1:
      p = spf[x]
      if p in u:
        r = 'setwise'
      s.add(p)
      x //= p
    u |= s
    if len(a) == n:
      if i is None: i = s
      else: i &= s
  if i:
    r = 'not'
print(r, 'coprime')
