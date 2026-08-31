a = []
def calc(k: int):
  global a
  m = -1
  for i in range(1, len(a)):
    m = max(m, abs((k if a[i] == -1 else a[i]) - (k if a[i - 1] == -1 else a[i - 1])))
  return m

ttt = int(input())
while ttt > 0:
  ttt-= 1
  n, a, l, r, res = int(input()), [int(i) for i in input().split()], 0, int(1e9), (int(1e9), 0)
  while r - l >= 3:
    m1, m2 = l + (r - l) // 3, r - (r - l) // 3
    #print(f'{m1}: {calc(a, m1)}\t{m2}: {calc(a, m2)}')
    if calc(m1) > calc(m2):
      l = m1
    else:
      r = m2
  for i in range(l, r + 1):
    t = calc(i)
    if t < res[0]:
      res = (t, i)
  print(f'{res[0]} {res[1]}')
    