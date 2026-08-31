from bisect import bisect_right

def find_le(a, x):
    'Find rightmost value less than or equal to x'
    i = bisect_right(a, x)
    return a[i-1]

def solve(drop_idx):
  if len(drop_idx) < 3:
    return (0, 0, 0)
  g = drop_idx[0]
  b = find_le(drop_idx, n//2)
  s = -1
  for idx in drop_idx:
    if idx - g > g and b - idx > g:
      s = idx
      break
  if s == -1:
    return (0,0,0)
  else:
    return (g, s-g, b-s)
  
t = int(input())
sol = []
for tc in range(t):
  n = int(input())
  p = list(map(int, input().split()))

  drop_idx = []
  for i in range(n-1):
    if p[i] > p[i+1]:
      drop_idx.append(i+1)
  # print('drop_idx', drop_idx)
  sol.append(solve(drop_idx))
  
for s in sol:
  print(*s)