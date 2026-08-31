buf = {}
for _ in range(int(input())):
  x = input()
  buf[x] = buf.get(x, 0) + 1
for x in ('AC','WA','TLE','RE'): print(x, 'x', buf.get(x, 0))